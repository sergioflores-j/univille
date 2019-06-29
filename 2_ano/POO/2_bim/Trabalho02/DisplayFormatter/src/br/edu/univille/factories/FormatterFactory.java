package br.edu.univille.factories;

import br.edu.unville.formatters.CalendarioFormatter;
import br.edu.unville.formatters.Formatter;
import br.edu.unville.formatters.RadioFormatter;
import br.edu.unville.formatters.RadioRelogioFormatter;
import br.edu.unville.formatters.TemperaturaFormatter;

public class FormatterFactory {
	public static Formatter<?> getFormatter(String formatter) {
		if (formatter == null) {
			return null;
		}
		
		if (formatter.equalsIgnoreCase("RADIO_RELOGIO")) {
			return new RadioRelogioFormatter();
		} else if (formatter.equalsIgnoreCase("RADIO")) {
			return new RadioFormatter();
		} else if (formatter.equalsIgnoreCase("TEMPERATURA")) {
			return new TemperaturaFormatter();
		} else if (formatter.equalsIgnoreCase("CALENDARIO")) {
			return new CalendarioFormatter();
		}

		return null;
	}
}
