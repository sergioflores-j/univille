package com.g1;

import java.util.ArrayList;
import java.util.List;

public class Lista {
	private List<Noticia> noticias = new ArrayList<Noticia>();

	public Lista(List<Noticia> noticias) {
		super();
		this.noticias = noticias;
	}

	public Lista() {

	}

	public List<Noticia> buscar(String texto) {
		List<Noticia> noticiasFiltradas = new ArrayList<Noticia>();

		for (int i = 0; i < this.getNoticias().size(); i++) {
			Noticia noticia = this.getNoticias().get(i);
			if (noticia.getTitulo().toLowerCase().contains(texto)
					|| noticia.getSubTitulo().toLowerCase().contains(texto)
					|| noticia.getConteudo().toLowerCase().contains(texto)
					|| noticia.getCategoria().getNome().toLowerCase().contains(texto))
				noticiasFiltradas.add(noticia);
		}

		return noticiasFiltradas;
	}

	public void adicionarNoticia(Noticia noticia) {
		List<Noticia> novaLista = this.getNoticias();

		novaLista.add(noticia);

		this.setNoticias(novaLista);
	}

	public void removerNoticia(Noticia noticia) {
		List<Noticia> novaLista = this.getNoticias();

		for (int i = 0; i < this.getNoticias().size(); i++) {
			Noticia n = this.getNoticias().get(i);
			if (n.equals(noticia)) {
				novaLista.remove(i);
			}
		}

		this.setNoticias(novaLista);
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
}
