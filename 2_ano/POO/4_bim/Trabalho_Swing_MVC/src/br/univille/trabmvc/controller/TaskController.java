package br.univille.trabmvc.controller;


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
        this.view.setVisible(true);
        this.model.notifyObservers();
    }

    public void deletar() {
        try {
			this.model.delete();
		} catch (Exception e) {
			e.printStackTrace();
            view.setMensagemStatusBar("Erro: " + e.getMessage());
		}
        this.view.setMensagemStatusBar("Registro deletado.");
        this.view.getBotaoDeletar().setEnabled(false);
    }

    public void novo() {
        this.model.novoRegistro();
        this.view.getBotaoDeletar().setEnabled(false);
        this.view.setMensagemStatusBar("Registro novo.");
    }

    public void salvar() {
    	this.model.setId(Integer.parseInt(this.view.getId()));
    	this.model.setTitle(this.view.getTitle());
    	this.model.setCompleted(Boolean.valueOf(this.view.getCompleted()));

        try {
            this.model.save();
            view.setMensagemStatusBar("Registro salvo com sucesso.");
            view.getBotaoDeletar().setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
            view.setMensagemStatusBar("Erro: " + e.getMessage());
        }
    }
}