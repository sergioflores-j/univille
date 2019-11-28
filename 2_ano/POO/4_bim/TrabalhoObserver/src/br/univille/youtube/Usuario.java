package br.univille.youtube;

import br.univille.interfaces.Observer;
import br.univille.interfaces.Subject;

public class Usuario implements Observer {
	private String nome;
	
	public Usuario(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void update(Subject s, Object o) {
		String oferta = (String) o;
		System.out.println("Observador " + nome +" atualizado: Novo vídeo = " + oferta);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

