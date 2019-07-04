package br.edu.univille.displays;

import br.edu.univille.factories.FormatterFactory;
import br.edu.univille.formatters.CalendarioFormatter;
import br.edu.univille.models.Calendario;

public class CalendarioDisplay extends Display<CalendarioFormatter>	{
	private String calendarioFormatado;

	public CalendarioDisplay() {
	}

	public void create(Calendario calendario) {
		this.setCalendarioFormatado(calendario);
	}

	@Override
	public void show() {
		System.out.println("Calendário: " + this.getCalendarioFormatado() + "\n");
	}

	public String getCalendarioFormatado() {
		return calendarioFormatado;
	}

	public void setCalendarioFormatado(Calendario calendario) {
		CalendarioFormatter calendarioFormatter = (CalendarioFormatter) FormatterFactory.CALENDARIO.getInstance();
		this.calendarioFormatado = calendarioFormatter.formatter(calendario);
	}
}
