package br.edu.univille.main;

import br.edu.univille.displays.CalendarioDisplay;
import br.edu.univille.displays.RadioDisplay;
import br.edu.univille.displays.RadioRelogioDisplay;
import br.edu.univille.displays.TemperaturaDisplay;
import br.edu.univille.factories.DisplayFactory;
import br.edu.univille.models.Calendario;
import br.edu.univille.models.EstacaoRadio;
import br.edu.univille.models.Horario;
import br.edu.univille.models.Temperatura;

public class Main {
	public static void main(String[] args) {
		// Rádio Relógio
		RadioRelogioDisplay radioRelogioDisplay = (RadioRelogioDisplay) DisplayFactory.RADIO_RELOGIO.getInstance();
		radioRelogioDisplay.create(new Horario(0, 5));
		radioRelogioDisplay.show();

		// Rádio
		RadioDisplay radioDisplay = (RadioDisplay) DisplayFactory.RADIO.getInstance();
		radioDisplay.create(new EstacaoRadio(105.7));
		radioDisplay.show();

		// Temperatura
		TemperaturaDisplay temperaturaDisplay = (TemperaturaDisplay) DisplayFactory.TEMPERATURA.getInstance();
		temperaturaDisplay.create(new Temperatura(31.1));
		temperaturaDisplay.show();

		// Calendario
		CalendarioDisplay calendarioDisplay = (CalendarioDisplay) DisplayFactory.CALENDARIO.getInstance();
		calendarioDisplay.create(new Calendario(31, 12, 2019));
		calendarioDisplay.show();
	}
}
