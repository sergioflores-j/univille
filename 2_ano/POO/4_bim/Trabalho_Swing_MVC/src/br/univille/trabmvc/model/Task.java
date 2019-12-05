package br.univille.trabmvc.model;

import java.util.ArrayList;
import java.util.List;

import br.univille.trabmvc.dao.TaskDao;
import br.univille.trabmvc.utils.Observer;
import br.univille.trabmvc.utils.Subject;

// !todo list
// Ações com o banco
// Listagem das task na tela
// Edição do item selecionado
public class Task implements Subject {
	private int id;
	private String title;
	private boolean completed;
	private TaskDao dao = new TaskDao();
	private List<Observer> observerList = new ArrayList<Observer>();

	public Task() {
	}

	public Task(String title) {
		this.title = title;
	}

	public Task(int id, String title, boolean completed) {
		this.id = id;
		this.title = title;
		this.completed = completed;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", completed=" + completed + ", observerList=" + observerList
				+ "]";
	}

	@Override
	public void attach(Observer o) {
		this.observerList.add(o);
	}

	@Override
	public void detach(Observer o) {
		this.observerList.remove(o);
	}

	@Override
	public void notifyObservers() {
		// Avisa cada um dos observadores
		for (Observer o : this.observerList) {
			// Atualiza a informacao no observador
			o.update(this, this);
		}
	}

	public void delete() {
		dao.delete(this);
		this.novoRegistro();
	}

	public void save() throws Exception {
		if (title == null || title.isEmpty()) {
			throw new Exception("Titulo inválido");
		}
		// Novo registro
		if (id == 0) {
			this.dao.insert(this);
		} else {
			this.dao.update(this);
		}

		this.novoRegistro();
	}

	public void setValues(Task task) {
		this.id = task.id;
		this.title = task.title;
		this.completed = task.completed;

		notifyObservers();
	}

	public void novoRegistro() {
		this.id = 0;
		this.title = "";
		this.completed = false;

		notifyObservers();
	}

}
