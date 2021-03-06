package com.g1;

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private Plano plano;
	private Estado estado;
	private Boolean isLogado = false;

	public Usuario(String nome, String email, String senha, Plano plano, Estado estado) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.plano = plano;
		this.estado = estado;
	}

	public void realizarLogin(String email, String senha) {
		if (this.getIsLogado() == true) {
			System.out.println("Usuário já está logado!");
		} else if (this.getEmail() == email && this.getSenha() == senha) {
			System.out.println("Usuário logado com sucesso!");
			this.setIsLogado(true);
		} else {
			System.out.println("Usuário e/ou senha inválidos!");
			this.setIsLogado(false);
		}
	}
	
	public String obterInformacoes() {
		if (this.getIsLogado() == false) return "";
		
		return "Nome: " + this.getNome() + "\n" 
				+ "Email: " + this.getEmail() + "\n" 
				+ "Plano: " + this.getPlano() + "\n" 
				+ "Estado: " + this.getEstado();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Boolean getIsLogado() {
		return isLogado;
	}

	private void setIsLogado(Boolean isLogado) {
		this.isLogado = isLogado;
	}

}
