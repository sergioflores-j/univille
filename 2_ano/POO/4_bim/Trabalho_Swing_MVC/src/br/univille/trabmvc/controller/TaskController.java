package br.univille.trabmvc.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import br.univille.trabmvc.model.Task;
import br.univille.trabmvc.view.TaskView;

public class TaskController {
	private TaskView view;
	private Task model;

	public TaskController(TaskView view, Task model) {
		this.view = view;
		this.model = model;

		this.model.attach(view);
		this.view.setModel(model);
		this.view.setControl(this);
	}

	public void exibirTela() {
		System.out.println("EXIBE TASKVIEW");
		this.view.setVisible(true);
		this.model.notifyObservers();
		this.view.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				model.novoRegistro();
			}
		});
	}

	public void deletar() {
		try {
			this.model.delete();
			this.closeView();
		} catch (Exception e) {
			e.printStackTrace();
			view.setMensagemStatusBar("Erro: " + e.getMessage());
		}
		this.view.setMensagemStatusBar("Registro deletado.");
		this.view.getBotaoDeletar().setEnabled(false);
	}

	public void cancelar() {
		this.model.novoRegistro();
		this.closeView();
	}

	public void novo() {
		this.model.novoRegistro();
		this.view.getBotaoDeletar().setEnabled(false);
		this.view.setMensagemStatusBar("Novo Registro");
	}

	public void edit(Task task) {
		this.model.setValues(task);
		this.view.getBotaoDeletar().setEnabled(true);
		this.view.setMensagemStatusBar("Edição da tarefa: " + this.model.getId());
	}

	public void closeView() {
		this.view.dispatchEvent(new WindowEvent(this.view, WindowEvent.WINDOW_CLOSING));
	}

	public void salvar() {
		this.model.setId(Integer.parseInt(this.view.getId()));
		this.model.setTitle(this.view.getTitle());
		this.model.setCompleted(Boolean.valueOf(this.view.getCompleted()));

		try {
			this.model.save();
			this.closeView();
			view.setMensagemStatusBar("Registro salvo com sucesso.");
			view.getBotaoDeletar().setEnabled(true);
		} catch (Exception e) {
			e.printStackTrace();
			view.setMensagemStatusBar("Erro: " + e.getMessage());
		}
	}
}