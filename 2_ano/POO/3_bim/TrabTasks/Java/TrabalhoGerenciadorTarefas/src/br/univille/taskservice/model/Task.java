package br.univille.taskservice.model;

import java.util.Date;

public class Task {
	private String title;
	private Date createdAt;
	private Date updatedAt;
	private boolean completed;
	private boolean deleted;
	private int priority;
	private Date dueDate;
	private User user;

	public Task() {}
	
	public Task(String title, User user) {
		this.title = title;
		this.user = user;
	}
	
	public Task(String title, boolean completed, boolean deleted, int priority, Date dueDate, User user) {
		this.title = title;
		this.completed = completed;
		this.deleted = deleted;
		this.priority = priority;
		this.dueDate = dueDate;
		this.user = user;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
