package br.univille.trabmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.univille.trabmvc.model.Task;

public class TaskDao extends BaseDao {
	public TaskDao() {
	}

	/**
	 * Inserir uma nova tarefa
	 * 
	 * @param task
	 */
	public void insert(Task task) {
		String sql = " INSERT INTO tasks(" + "title," + "completed)" + "VALUES(?,?)";

		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			statement.setString(1, task.getTitle());
			statement.setBoolean(2, task.isCompleted());

			int affectedRows = statement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Tarefa não foi criada.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					task.setId(generatedKeys.getInt(1));
				} else {
					throw new SQLException("Criação da tarefa falhou, não foi possível obter o ID gerado.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletar uma tarefa pelo id
	 * 
	 * @param task
	 */
	public void delete(Task task) {
		String sql = " DELETE FROM tasks WHERE id = ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, task.getId());
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualizar uma tarefa pelo id
	 * 
	 * @param task
	 */
	public void update(Task task) {
		String sql = "UPDATE tasks SET " + "title = ?," + "completed = ?" + " WHERE id = ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, task.getTitle());
			statement.setBoolean(2, task.isCompleted());
			statement.setInt(3, task.getId());
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Atualizar o status da tarefa pelo id
	 * 
	 * @param task
	 */
	public void setCompleted(Task task) {
		String sql = "UPDATE tasks SET completed = ? WHERE id = ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setBoolean(1, task.isCompleted());
			statement.setInt(2, task.getId());
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Obtem a lista de tasks
	 */
	public List<Task> list() {
		List<Task> list = new ArrayList<>();
		String sql = "SELECT" + " tasks.id," + " tasks.title," + " tasks.completed" + " FROM tasks";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Task task = new Task();
				task.setId(resultSet.getInt(1));
				task.setTitle(resultSet.getString(2));
				task.setCompleted(resultSet.getBoolean(3));

				list.add(task);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Obter tasks pelo titulo
	 * 
	 * @param title
	 * @return
	 */
	public List<Task> listByTitle(String title) {
		List<Task> list = new ArrayList<>();
		String sql = "SELECT" + " tasks.id," + " tasks.title," + " tasks.completed" + " FROM tasks"
				+ " WHERE tasks.title LIKE ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, "%" + title + "%");

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Task task = new Task();
				task.setId(resultSet.getInt(1));
				task.setTitle(resultSet.getString(2));
				task.setCompleted(resultSet.getBoolean(3));

				list.add(task);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Obter uma tarefa pelo id
	 * 
	 * @param id
	 * @return
	 */
	public Task getById(int id) {
		Task task = new Task();
		String sql = "SELECT" + " tasks.id," + " tasks.title," + " tasks.completed" + " FROM tasks"
				+ " WHERE tasks.id = ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				task.setId(resultSet.getInt(1));
				task.setTitle(resultSet.getString(2));
				task.setCompleted(resultSet.getBoolean(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return task;
	}
}