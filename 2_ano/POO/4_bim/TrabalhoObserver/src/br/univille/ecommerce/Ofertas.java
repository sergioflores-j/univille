package br.univille.ecommerce;

import java.util.ArrayList;
import java.util.List;

import br.univille.interfaces.Observer;
import br.univille.interfaces.Subject;

public class Ofertas implements Subject {
	private List<Observer> observers;
	private String oferta;
	
	public Ofertas() {
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
	
	public void novaOferta(String desProd, double valProd) {
		oferta = "Produto: " + desProd + ", valor: R$" + valProd;
		
		// Após a modificacao, avisa os observadores
		notifyObservers();
	}

}
