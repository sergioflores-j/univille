package br.edu.univille.formatters;

import br.edu.univille.models.Calendario;

public class CalendarioFormatter implements Formatter<Calendario> {

	@Override
	public String formatter(Calendario calendario) {
		String str = "\nDia   Mês   Ano \n";
		
		str += calendario.getDia() + "    " + calendario.getMes() + "    " + calendario.getAno();
		
		return str;
	}

}
