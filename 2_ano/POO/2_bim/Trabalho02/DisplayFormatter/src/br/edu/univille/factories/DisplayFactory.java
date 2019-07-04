package br.edu.univille.factories;

import br.edu.univille.displays.CalendarioDisplay;
import br.edu.univille.displays.Display;
import br.edu.univille.displays.RadioDisplay;
import br.edu.univille.displays.RadioRelogioDisplay;
import br.edu.univille.displays.TemperaturaDisplay;

public enum DisplayFactory {
	RADIO_RELOGIO {
		@Override
		public Display<?> getInstance() {
			return new RadioRelogioDisplay();
		}
	},
	RADIO {
		@Override
		public Display<?> getInstance() {
			return new RadioDisplay();
		}
	},
	TEMPERATURA {
		@Override
		public Display<?> getInstance() {
			return new TemperaturaDisplay();
		}
	},
	CALENDARIO {
		@Override
		public Display<?> getInstance() {
			return new CalendarioDisplay();
		}
	};

	public abstract Display<?> getInstance();
}
