package br.univille.trabmvc.main;

import br.univille.trabmvc.controller.TaskController;
import br.univille.trabmvc.model.Task;
import br.univille.trabmvc.view.TaskView;

public class Main {
	public static void main(String[] args) {
		Task p = new Task();
//		p.setCpf("456.455.454-31");
//		p.setEmail("fulano@gmail.com");
//		p.setNome("Fulano");
//		p.setId(123);

		TaskController control = new TaskController(new TaskView(), p);
		control.exibirTela();
	}
}
