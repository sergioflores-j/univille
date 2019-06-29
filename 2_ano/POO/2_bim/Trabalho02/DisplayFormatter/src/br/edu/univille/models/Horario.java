package br.edu.univille.models;

public class Horario {
	private int hora;
	private int minuto;

	public Horario() {}
	
	public Horario(int hora, int minuto) {
		try {
			this.setHora(hora);
			this.setMinuto(minuto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) throws Exception {
		if (hora < 0 || hora > 23) throw new Exception("Hora inválida! Informe valores de 0 a 23.");
		
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) throws Exception {
		if (minuto < 0 || minuto > 59) throw new Exception("Minuto inválido! Informe valores de 0 a 59.");
		
		this.minuto = minuto;
	}
}
