package com.g1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Noticia {
	private String titulo;
	private String subTitulo;
	private Date dataCriacao;
	public static final DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private String conteudo;
	private Autor autor;
	private Categoria categoria;

	public Noticia(String titulo, String subTitulo, Date dataCriacao, String conteudo, Autor autor,
			Categoria categoria) {
		super();
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.dataCriacao = dataCriacao;
		this.conteudo = conteudo;
		this.autor = autor;
		this.categoria = categoria;
	}

	public void visualizarNoticiaCompleta() {
		System.out.println("-------------------");
		System.out.println(this.getTitulo());
		System.out.println(this.getSubTitulo());
		System.out.println("Criado em:" + this.getDataCriacaoFormatada());
		System.out.println("Por:" + this.getAutor().obterInformacoes());
		System.out.println(this.getConteudo());
		System.out.println("-------------------");
	}

	public String getDataCriacaoFormatada() {
		return formatoData.format(this.getDataCriacao());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((subTitulo == null) ? 0 : subTitulo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Noticia other = (Noticia) obj;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (subTitulo == null) {
			if (other.subTitulo != null)
				return false;
		} else if (!subTitulo.equals(other.subTitulo))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
}
