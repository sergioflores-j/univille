package br.edu.univille.models;

public class Calendario {
	private int dia;
	private int mes;
	private int ano;

	public Calendario() {

	}

	public Calendario(int dia, int mes, int ano) {
		try {
			this.setDia(dia);
			this.setMes(mes);
			this.setAno(ano);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) throws Exception {
		if (dia < 1 || dia > 31) throw new Exception("Dia inválido! Informe valores entre 1 e 31");
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) throws Exception {
		if (mes < 1 || mes > 12) throw new Exception("Mês inválido! Informe valores entre 1 e 12");
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) throws Exception {
		if (ano < 0) throw new Exception("Ano inválido! Informe valores maiores que 0");
		
		this.ano = ano;
	}

}
