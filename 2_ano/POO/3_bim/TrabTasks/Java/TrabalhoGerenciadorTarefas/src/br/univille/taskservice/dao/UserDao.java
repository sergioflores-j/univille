package br.univille.taskservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.univille.taskservice.model.User;

public class UserDao extends BaseDao {
	public UserDao() {
	}

	/**
	 * Inserir um novo usuário
	 * 
	 * @param user
	 */
	public void insert(User user) {
		String sql = " INSERT INTO user(email, password) VALUES(?,?)";

		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());

			int affectedRows = statement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Usuário não foi criado.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					user.setId(generatedKeys.getInt(1));
				} else {
					throw new SQLException("Criação do usuário falhou, não foi possível obter o ID gerado.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletar um usuário pelo id
	 * 
	 * @param user
	 */
	public void delete(User user) {
		String sql = " DELETE FROM user WHERE id = ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, user.getId());
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualizar a senha do usuário pelo id
	 * 
	 * @param user
	 */
	public void update(User user) {
		String sql = "UPDATE user SET password = ? WHERE id = ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, user.getPassword());
			statement.setInt(2, user.getId());
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obter um usuário pelo email
	 * 
	 * @param email
	 * @return
	 */
	public User getByEmail(String email) {
		User user = new User();
		String sql = "SELECT id, email, password, created_at FROM user WHERE email = ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				user.setId(resultSet.getInt(1));
				user.setEmail(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setCreatedAt(resultSet.getTimestamp(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	/**
	 * Obter um usuário pelo id
	 * 
	 * @param id
	 * @return
	 */
	public User getById(int id) {
		User user = null;
		String sql = "SELECT id, email, password, created_at FROM user WHERE id = ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt(1));
				user.setEmail(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setCreatedAt(resultSet.getTimestamp(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	/**
	 * Obter todas os usuários da tabela
	 * 
	 * @return
	 */
	public List<User> getAll() {
		List<User> list = new ArrayList<>();
		String sql = "SELECT id, email, created_at FROM user ORDER BY created_at DESC";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setEmail(resultSet.getString(2));
				user.setCreatedAt(resultSet.getTimestamp(3));

				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
