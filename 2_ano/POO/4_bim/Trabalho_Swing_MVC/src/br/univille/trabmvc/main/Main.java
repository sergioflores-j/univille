package br.univille.trabmvc.main;

import br.univille.trabmvc.controller.TaskController;
import br.univille.trabmvc.controller.TaskListController;
import br.univille.trabmvc.model.Task;
import br.univille.trabmvc.view.TaskListView;
import br.univille.trabmvc.view.TaskView;

public class Main {
	public static void main(String[] args) {
		Task p = new Task();

		TaskListController control = new TaskListController(new TaskListView(), p);
		control.setup(new TaskController(new TaskView(), p));

		control.exibirTela();
	}
}
