package br.edu.univille.displays;

import br.edu.univille.factories.FormatterFactory;
import br.edu.univille.models.EstacaoRadio;
import br.edu.unville.formatters.RadioFormatter;

public class RadioDisplay extends Display<RadioFormatter> {
	private String estacaoFormatada;

	public RadioDisplay() {
	}

	public void create(EstacaoRadio estacao) {
		this.setEstacaoFormatada(estacao);
	}

	@Override
	public void show() {
		System.out.println("Rádio: " + this.getEstacaoFormatada());
	}

	public String getEstacaoFormatada() {
		return estacaoFormatada;
	}

	public void setEstacaoFormatada(EstacaoRadio estacao) {
		RadioFormatter radioFormatter = (RadioFormatter) FormatterFactory.getFormatter("RADIO");
		this.estacaoFormatada = radioFormatter.formatter(estacao);
	}
}