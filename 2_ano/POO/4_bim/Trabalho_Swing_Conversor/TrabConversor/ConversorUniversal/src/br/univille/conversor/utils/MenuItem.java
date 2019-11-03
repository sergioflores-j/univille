package br.univille.conversor.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class MenuItem extends JMenuItem implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActionListener acao;

	public MenuItem(String text) {
		super(text);
	}
	
	public MenuItem(String text, ActionListener acao) {
		super(text);
		addActionListener(this);
		this.acao = acao;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Item clicked: " + e.getActionCommand());
		if (acao != null) {
			acao.onclick();
		}
	}

	public interface ActionListener {
		void onclick();
	}

}