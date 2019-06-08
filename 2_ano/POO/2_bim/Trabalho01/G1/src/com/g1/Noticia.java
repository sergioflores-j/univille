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
}
