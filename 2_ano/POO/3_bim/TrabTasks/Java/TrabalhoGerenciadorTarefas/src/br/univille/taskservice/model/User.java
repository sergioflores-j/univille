package br.univille.taskservice.model;

import java.util.Date;

public class User {
	private int id;
	private String email;
	private String password;
	private Date createdAt;

	public User() {
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public User(int id, String email, String password, Date createdAt) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", createdAt=" + createdAt + "]";
	}
}
