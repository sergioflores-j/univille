package br.edu.unville.formatters;

import br.edu.univille.utils.Horario;

public class RadioRelogioFormatter implements Formatter<Horario> {
	@Override
	public String formatter(Horario horario) {
		horario.getHora();
		horario.getMinuto();
	}
}
