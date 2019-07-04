package br.edu.univille.formatters;

import br.edu.univille.models.EstacaoRadio;

public class RadioFormatter implements Formatter<EstacaoRadio> {
	@Override
	public String formatter(EstacaoRadio estacao) {
		return "FM " + String.format("%.1f", estacao.getSintonia()) + " Mhz";
	}
}