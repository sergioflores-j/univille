package br.edu.univille.factories;

import br.edu.univille.formatters.CalendarioFormatter;
import br.edu.univille.formatters.Formatter;
import br.edu.univille.formatters.RadioFormatter;
import br.edu.univille.formatters.RadioRelogioFormatter;
import br.edu.univille.formatters.TemperaturaFormatter;

public enum FormatterFactory {
	RADIO_RELOGIO {
		@Override
		public Formatter<?> getInstance() {
			return new RadioRelogioFormatter();
		}
	},
	RADIO {
		@Override
		public Formatter<?> getInstance() {
			return new RadioFormatter();
		}
	},
	TEMPERATURA {
		@Override
		public Formatter<?> getInstance() {
			return new TemperaturaFormatter();
		}
	},
	CALENDARIO {
		@Override
		public Formatter<?> getInstance() {
			return new CalendarioFormatter();
		}
	};

	public abstract Formatter<?> getInstance();
}
