package br.edu.univille.displays;

import br.edu.univille.factories.FormatterFactory;
import br.edu.univille.models.Temperatura;
import br.edu.unville.formatters.TemperaturaFormatter;

public class TemperaturaDisplay extends Display<TemperaturaFormatter> {
	private String temperaturaFormatada;

	public TemperaturaDisplay() {
	}

	public void create(Temperatura temperatura) {
		this.setTemperaturaFormatada(temperatura);
	}
	
	@Override
	public void show() {
		System.out.println("Temperatura: " + this.getTemperaturaFormatada());
	}

	public String getTemperaturaFormatada() {
		return temperaturaFormatada;
	}

	public void setTemperaturaFormatada(Temperatura temperatura) {
		TemperaturaFormatter temperaturaFormatter = (TemperaturaFormatter) FormatterFactory.getFormatter("TEMPERATURA");
		this.temperaturaFormatada = temperaturaFormatter.formatter(temperatura);
	}

}
