package com.g1;

public class Autor extends Usuario {
	private int publicacoes = 0;

	public Autor(String nome, String email, String senha, Plano plano, Estado estado, int publicacoes) {
		super(nome, email, senha, plano, estado);
	}

	public void novaPublicacao() {
		this.setPublicacoes(this.getPublicacoes() + 1);
	}

	@Override
	public String obterInformacoes() {
		return "Nome: " + this.getNome() + "\n" + "Estado: " + this.getEstado();
	}

	public int getPublicacoes() {
		return publicacoes;
	}

	public void setPublicacoes(int publicacoes) {
		this.publicacoes = publicacoes;
	}
}
