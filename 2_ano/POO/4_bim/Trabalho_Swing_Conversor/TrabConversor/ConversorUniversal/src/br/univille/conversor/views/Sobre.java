package br.univille.conversor.views;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sobre extends JFrame {
	private static final long serialVersionUID = 1L;

	public Sobre() {
		// Titulo da Janela
		setTitle("Conversor Universal");
		// Tamanho da Janela
		setSize(600, 400);
		// Nao permite modificar o tamanho da Tela
		setResizable(false);
		// Finaliza o programa quando fechar a janela
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Configura a tela
		setLayout();
	}
	
	private void setLayout() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 150));

		JLabel label = new JLabel("<html>Esta é a página de sobre, ela conterá informações importantes. <br>Você pode fechá-la para voltar para página anterior</html>");
		
		panel.add(label);
		
		add(panel);
	}
}
