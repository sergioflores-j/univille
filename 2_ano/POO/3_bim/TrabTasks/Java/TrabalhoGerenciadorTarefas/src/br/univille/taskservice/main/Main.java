package br.univille.taskservice.main;

import br.univille.taskservice.dao.TaskDao;
import br.univille.taskservice.dao.UserDao;
import br.univille.taskservice.model.Task;
import br.univille.taskservice.model.User;

public class Main {
	public static void main(String[] args) {
		User user = new User("sergio.flores@univille.br", "senha");
		
		UserDao userDao = new UserDao();
		userDao.insert(user);
		
		Task task = new Task("Titulo de uma tarefa a ser feita", user);
		
		TaskDao taskDao = new TaskDao();
		taskDao.insert(task);
	}
}
