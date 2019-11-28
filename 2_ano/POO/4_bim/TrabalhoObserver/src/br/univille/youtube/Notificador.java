package br.univille.youtube;

import java.util.ArrayList;
import java.util.List;

import br.univille.interfaces.Observer;
import br.univille.interfaces.Subject;

public class Notificador implements Subject {
	private List<Observer> observers;
	private String oferta;
	
	public Notificador() {
		observers = new ArrayList<Observer>();
	}
	
	@Override
	public void attach(Observer o) {
		observers.add(o);
	}

	@Override
	public void detach(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers) {
			o.update(this, oferta);
		}
	}
	
	public void videoNovo(String titulo, double duracao) {
		oferta = "Video: " + titulo + ", Duração:" + duracao + " min";
		
		// Após a modificacao, avisa os observadores
		notifyObservers();
	}

}

