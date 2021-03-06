package br.univille.taskservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.univille.taskservice.model.Task;
import br.univille.taskservice.model.User;

public class TaskDao extends BaseDao {
	public TaskDao() {
	}

	/**
	 * Inserir uma nova tarefa
	 * 
	 * @param task
	 */
	public void insert(Task task) {
		String sql = " INSERT INTO tasks(" + "title," + "completed," + "deleted," + "priority," + "due_date,"
				+ "user_id) " + "VALUES(?,?,?,?,?,?)";

		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			statement.setString(1, task.getTitle());
			statement.setBoolean(2, task.isCompleted());
			statement.setBoolean(3, task.isDeleted());
			statement.setInt(4, task.getPriority());
			statement.setTimestamp(5, task.getDueDateTimestamp());
			statement.setInt(6, task.getUser().getId());

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
		String sql = "UPDATE tasks SET " + "title = ?," + "completed = ?," + "deleted = ?," + "priority = ?,"
				+ "due_date = ?," + "user_id = ?" + " WHERE id = ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, task.getTitle());
			statement.setBoolean(2, task.isCompleted());
			statement.setBoolean(3, task.isDeleted());
			statement.setInt(4, task.getPriority());
			statement.setTimestamp(5, task.getDueDateTimestamp());
			statement.setInt(6, task.getUser().getId());
			statement.setInt(7, task.getId());
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
	 * Obter tasks pelo titulo
	 * 
	 * @param title
	 * @return
	 */
	public List<Task> listByTitle(String title, User user) {
		List<Task> list = new ArrayList<>();
		String sql = "SELECT" + " tasks.id," + " tasks.title," + " tasks.created_at," + " tasks.updated_at,"
				+ " tasks.completed," + " tasks.deleted," + " tasks.priority," + " tasks.due_date," + " user.id,"
				+ " user.email," + " user.password," + " user.created_at" + " FROM tasks"
				+ " INNER JOIN user ON user.id = tasks.user_id" + " WHERE tasks.title LIKE ? AND tasks.user_id = ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, "%" + title + "%");
			statement.setInt(2, user.getId());

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Task task = new Task();
				task.setId(resultSet.getInt(1));
				task.setTitle(resultSet.getString(2));
				task.setCreatedAt(resultSet.getTimestamp(3));
				task.setUpdatedAt(resultSet.getTimestamp(4));
				task.setCompleted(resultSet.getBoolean(5));
				task.setDeleted(resultSet.getBoolean(6));
				task.setPriority(resultSet.getInt(7));
				task.setDueDate(resultSet.getTimestamp(8));

				User taskUser = new User();
				taskUser.setId(resultSet.getInt(9));
				taskUser.setEmail(resultSet.getString(10));
				taskUser.setPassword(resultSet.getString(11));
				taskUser.setCreatedAt(resultSet.getTimestamp(12));

				task.setUser(taskUser);

				list.add(task);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Obter um usuário pelo id
	 * 
	 * @param id
	 * @return
	 */
	public Task getById(int id, User user) {
		Task task = new Task();
		String sql = "SELECT" + " tasks.id," + " tasks.title," + " tasks.created_at," + " tasks.updated_at,"
				+ " tasks.completed," + " tasks.deleted," + " tasks.priority," + " tasks.due_date," + " user.id,"
				+ " user.email," + " user.password," + " user.created_at" + " FROM tasks"
				+ " INNER JOIN user ON user.id = tasks.user_id" + " WHERE tasks.id = ? AND tasks.user_id = ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.setInt(2, user.getId());

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				task.setId(resultSet.getInt(1));
				task.setTitle(resultSet.getString(2));
				task.setCreatedAt(resultSet.getTimestamp(3));
				task.setUpdatedAt(resultSet.getTimestamp(4));
				task.setCompleted(resultSet.getBoolean(5));
				task.setDeleted(resultSet.getBoolean(6));
				task.setPriority(resultSet.getInt(7));
				task.setDueDate(resultSet.getTimestamp(8));

				User taskUser = new User();
				taskUser.setId(resultSet.getInt(9));
				taskUser.setEmail(resultSet.getString(10));
				taskUser.setPassword(resultSet.getString(11));
				taskUser.setCreatedAt(resultSet.getTimestamp(12));

				task.setUser(taskUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return task;
	}

	/**
	 * Obter tasks pelo id do usuário
	 * 
	 * @param user
	 * @return
	 */
	public List<Task> listByUser(User user) {
		List<Task> list = new ArrayList<>();
		String sql = "SELECT" + " tasks.id," + " tasks.title," + " tasks.created_at," + " tasks.updated_at,"
				+ " tasks.completed," + " tasks.deleted," + " tasks.priority," + " tasks.due_date," + " user.id,"
				+ " user.email," + " user.password," + " user.created_at" + " FROM tasks"
				+ " INNER JOIN user ON user.id = tasks.user_id" + " WHERE tasks.user_id = ?";

		try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, user.getId());

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Task task = new Task();
				task.setId(resultSet.getInt(1));
				task.setTitle(resultSet.getString(2));
				task.setCreatedAt(resultSet.getTimestamp(3));
				task.setUpdatedAt(resultSet.getTimestamp(4));
				task.setCompleted(resultSet.getBoolean(5));
				task.setDeleted(resultSet.getBoolean(6));
				task.setPriority(resultSet.getInt(7));
				task.setDueDate(resultSet.getTimestamp(8));

				User taskUser = new User();
				taskUser.setId(resultSet.getInt(9));
				taskUser.setEmail(resultSet.getString(10));
				taskUser.setPassword(resultSet.getString(11));
				taskUser.setCreatedAt(resultSet.getTimestamp(12));

				task.setUser(taskUser);

				list.add(task);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
