package br.edu.univille.displays;

import br.edu.univille.factories.FormatterFactory;
import br.edu.univille.models.Horario;
import br.edu.unville.formatters.RadioRelogioFormatter;

public class RadioRelogioDisplay extends Display<RadioRelogioFormatter> {
	private String horarioFormatado;

	public RadioRelogioDisplay() {
	}

	public void create(Horario horario) {
		this.setHorarioFormatado(horario);
	}

	@Override
	public void show() {
		System.out.println("Rádio Relógio: " + this.getHorarioFormatado());
	}

	public String getHorarioFormatado() {
		return horarioFormatado;
	}

	public void setHorarioFormatado(Horario horario) {
		RadioRelogioFormatter radioRelogioFormatter = (RadioRelogioFormatter) FormatterFactory.getFormatter("RADIO_RELOGIO");
		this.horarioFormatado = radioRelogioFormatter.formatter(horario);
	}
}
