package br.edu.univille.factories;

import br.edu.univille.displays.CalendarioDisplay;
import br.edu.univille.displays.Display;
import br.edu.univille.displays.RadioDisplay;
import br.edu.univille.displays.RadioRelogioDisplay;
import br.edu.univille.displays.TemperaturaDisplay;

public class DisplayFactory {
	public static Display<?> getDisplay(String display) {
		if (display == null) {
			return null;
		}
		
		if (display.equalsIgnoreCase("RADIO_RELOGIO")) {
			return new RadioRelogioDisplay();
		} else if (display.equalsIgnoreCase("RADIO")) {
			return new RadioDisplay();
		} else if (display.equalsIgnoreCase("TEMPERATURA")) {
			return new TemperaturaDisplay();
		} else if (display.equalsIgnoreCase("CALENDARIO")) {
			return new CalendarioDisplay();
		}
		
		return null;
	}
}
