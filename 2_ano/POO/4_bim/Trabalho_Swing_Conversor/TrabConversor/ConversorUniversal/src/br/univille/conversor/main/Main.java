package br.univille.conversor.main;

import javax.swing.SwingUtilities;

import br.univille.conversor.views.TelaPrincipal;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
			}
		});

	}
}