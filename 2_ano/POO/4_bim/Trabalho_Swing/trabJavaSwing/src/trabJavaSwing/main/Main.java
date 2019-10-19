package trabJavaSwing.main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import trabJavaSwing.views.Login;
import trabJavaSwing.views.Zonas;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Instancia a Janela de Login
				Login login = new Login();
				login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				login.setVisible(true);
				
				login.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						// Quando fecha a janela de Login, abre a de zonas
						Zonas zonas = new Zonas();
						zonas.setVisible(true);
					}
				});
			}
		});

	}
}
