package br.edu.univille.formatters;

import br.edu.univille.models.Horario;

public class RadioRelogioFormatter implements Formatter<Horario> {
	@Override
	public String formatter(Horario horario) {
		return String.format("%02d", horario.getHora()) + ":" + String.format("%02d", horario.getMinuto());
	}
}
