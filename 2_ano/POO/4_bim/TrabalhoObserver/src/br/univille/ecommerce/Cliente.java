package br.univille.ecommerce;

import br.univille.interfaces.Observer;
import br.univille.interfaces.Subject;

public class Cliente implements Observer {
	private String nome;
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void update(Subject s, Object o) {
		String oferta = (String) o;
		System.out.println("Observador " + nome +" atualizado: Nova oferta = " + oferta);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
