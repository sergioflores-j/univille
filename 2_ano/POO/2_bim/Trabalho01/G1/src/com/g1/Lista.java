package com.g1;

import java.util.List;

public class Lista {
	private List<Noticia> noticias;

	public Lista(List<Noticia> noticias) {
		super();
		this.noticias = noticias;
	}
	
	public Lista() {
		
	}

	public List<Noticia> buscar(String texto) {
		List<Noticia> noticiasFiltradas = null;
		
		for (Noticia noticia : this.getNoticias()) {
			if (
				noticia.getTitulo().contains(texto)
				|| noticia.getSubTitulo().contains(texto)
				|| noticia.getConteudo().contains(texto)
			) noticiasFiltradas.add(noticia);
		}
		
		return noticiasFiltradas;
	}
	
	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
}
