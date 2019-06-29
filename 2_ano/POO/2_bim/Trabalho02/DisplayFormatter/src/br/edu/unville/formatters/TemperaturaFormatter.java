package br.edu.unville.formatters;

import br.edu.univille.models.Temperatura;

public class TemperaturaFormatter implements Formatter<Temperatura> {

	@Override
	public String formatter(Temperatura temperatura) {
		return String.format("%.1f", temperatura.getValor()) + " °C";
	}

}
