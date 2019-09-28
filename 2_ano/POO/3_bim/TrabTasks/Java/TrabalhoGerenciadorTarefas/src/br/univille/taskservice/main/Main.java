package br.univille.taskservice.main;

import java.util.Date;
import java.util.List;

import br.univille.taskservice.dao.TaskDao;
import br.univille.taskservice.dao.UserDao;
import br.univille.taskservice.model.Task;
import br.univille.taskservice.model.User;

public class Main {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		TaskDao taskDao = new TaskDao();
		
		String email = "sergio.flores@univille.br";

		User user = userDao.getByEmail(email);

		// Cria um novo usuário caso não exista
		if (user.getEmail() == null) {
			// Cria um novo usuário
			User newUser = new User(email, "senha");
			userDao.insert(newUser);
			
			// Busca os dados do usuário que foi criado e atribui ao objeto user
			user = userDao.getById(newUser.getId());
		}
		
		if (user.getPassword() != "123456") {
			user.setPassword("123456");
			// Atualiza a senha do usuário
			userDao.update(user);
		}

		System.out.println("User" + user.toString());

		// Busca a lista de tarefas do usuário
		List<Task> taskList = taskDao.listByUser(user);
		
		System.out.println("Lista de Tarefas do usuário:");
		
		for (Task task : taskList) {
			System.out.println(task.toString());
		}
		
		// Cria novas tarefas
		Task task = new Task("Titulo - " + Math.random(), user);
		Task task2 = new Task("Titulo2 - " + Math.random(), user);
		taskDao.insert(task);
		taskDao.insert(task2);
		
		// Busca os dados da primeira task criada
		task = taskDao.getById(task.getId(), user);
		task.setCompleted(true);
		
		// Seta a tarefa como completada
		taskDao.setCompleted(task);
		
		// Busca os dados da segunda task criada
		task2 = taskDao.getById(task2.getId(), user);
		task2.setDueDate(new Date());
		task2.setDeleted(true);
		
		// Atualiza os dados da tarefa
		taskDao.update(task2);
		
		List<Task> taskListByTitle = taskDao.listByTitle("Titulo", user);
		
		System.out.println("Lista de Tarefas contendo o titulo:");
		
		for (Task t : taskListByTitle) {
			System.out.println(t.toString());
		}
		
		// Apaga a tarefa que foi marcada como excluída
		taskDao.delete(task2);
	}
}
