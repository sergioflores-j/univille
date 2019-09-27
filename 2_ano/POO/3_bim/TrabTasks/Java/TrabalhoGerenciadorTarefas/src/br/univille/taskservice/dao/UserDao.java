package br.univille.taskservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletar um usuário pelo email
	 * 
	 * @param user
	 */
	public void delete(User user) {
		String sql = " DELETE FROM user WHERE id = ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, user.getEmail());
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualizar a senha do usuário pelo email
	 * @param user
	 */
	public void update(User user) {
		String sql = "UPDATE user SET password = ? WHERE email = ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getEmail());
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
		User user = null;
		String sql = "SELECT id, email, password FROM user WHERE email = ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt(1));
				user.setEmail(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * Obter todas as pessoas da tabel
	 * 
	 * @return
	 */
	public List<Pessoa> getAll() {
		List<Pessoa> list = new ArrayList<>();
		String sql = " select id, nome, sobrenome from pessoa order by nome";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(resultSet.getInt(1));
				pessoa.setNome(resultSet.getString(2));
				pessoa.setSobrenome(resultSet.getString(3));

				list.add(pessoa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
