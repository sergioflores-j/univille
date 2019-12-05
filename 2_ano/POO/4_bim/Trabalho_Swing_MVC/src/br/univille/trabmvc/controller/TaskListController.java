package br.univille.trabmvc.controller;

import java.util.ArrayList;
import java.util.List;

import br.univille.trabmvc.dao.TaskDao;
import br.univille.trabmvc.model.Task;
import br.univille.trabmvc.view.TaskListView;

public class TaskListController {
	private TaskListView view;
	private Task model;
	private TaskController taskController;
	private TaskDao dao;

	public TaskListController(TaskListView view, Task model) {
		this.view = view;
		this.model = model;
		this.dao = new TaskDao();

		this.model.attach(view);
		this.view.setControl(this);
	}

	public void setup(TaskController control) {
		this.taskController = control;
	}

	public void exibirTela() {
		System.out.println("EXIBE TASKLISTVIEW");
		this.view.initView();
		this.view.setVisible(true);
	}

	public List<Task> getList() {
		List<Task> list = new ArrayList<Task>();

		try {
			list = this.dao.list();
		} catch (Exception e) {
			e.printStackTrace();
			view.setMensagemStatusBar("Erro: " + e.getMessage());
		}
		
		System.out.println("LIST SIZE: " + list.size());

		this.view.setMensagemStatusBar("Lista de Registros, total: " + list.size());

		return list;
	}

	public void newTask() {
		this.view.setEditId(0);

		this.taskController.novo();
		this.taskController.exibirTela();
	}

	public void edit(int id) {
		Task task = new Task();

		try {
			task = this.dao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
			view.setMensagemStatusBar("Erro: " + e.getMessage());
		} finally {
			this.taskController.edit(task);
			this.taskController.exibirTela();
		}
	}
}
