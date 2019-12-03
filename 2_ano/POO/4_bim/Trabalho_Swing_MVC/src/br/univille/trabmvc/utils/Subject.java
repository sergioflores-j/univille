package br.univille.trabmvc.utils;

public interface Subject {

	void attach(Observer o);

	void detach(Observer o);

	void notifyObservers();

}
