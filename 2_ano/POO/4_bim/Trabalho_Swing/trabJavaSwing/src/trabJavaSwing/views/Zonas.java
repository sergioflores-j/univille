package trabJavaSwing.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Zonas extends JFrame {
	private static final long serialVersionUID = 1L;

	public Zonas() {
		// Titulo da Janela
		setTitle("Zonas");
		// Tamanho da Janela
		setSize(300, 300);
		// Nao permite modificar o tamanho da Tela
		setResizable(false);
		// Finaliza o programa quando fechar a janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Configura a tela
		setLayout();
	}

	// Cria um painel com a cor de fundo e um label
	private JPanel criarPanel(Color color, String texto) {
		JPanel panel = new JPanel();
		panel.setBackground(color);
		panel.add(new JLabel(texto));
		// Configura um tamanho padrao do painel
		return panel;
	}

	// Configura a tela
	private void setLayout() {
		JPanel mainPanel = new JPanel();
		// Adiciona o gerenciador GridLayout
		mainPanel.setLayout(new GridLayout(1, 2));

		JPanel panelChecks = new JPanel();
		// Retira o gerenciador de layout
		panelChecks.setLayout(null);
		panelChecks.setBackground(Color.WHITE);

		JCheckBox checkNorte = new JCheckBox("Norte");
		checkNorte.setSelected(true);
		checkNorte.setBounds(0, 50, 140, 30);

		JCheckBox checkSul = new JCheckBox("Sul");
		checkSul.setSelected(true);
		checkSul.setBounds(0, 80, 140, 30);

		JCheckBox checkLeste = new JCheckBox("Leste");
		checkLeste.setSelected(true);
		checkLeste.setBounds(0, 110, 140, 30);

		JCheckBox checkOeste = new JCheckBox("Oeste");
		checkOeste.setSelected(true);
		checkOeste.setBounds(0, 140, 140, 30);

		JCheckBox checkCentro = new JCheckBox("Centro");
		checkCentro.setSelected(true);
		checkCentro.setBounds(0, 170, 140, 30);

		panelChecks.add(checkNorte);
		panelChecks.add(checkSul);
		panelChecks.add(checkLeste);
		panelChecks.add(checkOeste);
		panelChecks.add(checkCentro);

		// ---- Panel Zonas ----
		JPanel panelZonas = new JPanel();
		// Adiciona o gerenciador BorderLayout
		panelZonas.setLayout(new BorderLayout());

		// Cria os paineis
		JPanel norte = criarPanel(new Color(60, 166, 255), "Norte");
		JPanel leste = criarPanel(new Color(184, 151, 125), "Leste");
		JPanel oeste = criarPanel(new Color(248, 143, 82), "Oeste");
		JPanel sul = criarPanel(new Color(247, 94, 98), "Sul");
		JPanel centro = criarPanel(Color.WHITE, "Centro");

		// Adiciona o painel no norte
		panelZonas.add(norte, BorderLayout.NORTH);
		removeComponentListener(checkNorte, norte);
		// Adiciona o painel no sul
		panelZonas.add(sul, BorderLayout.SOUTH);
		removeComponentListener(checkSul, sul);
		// Adiciona o painel no leste
		panelZonas.add(leste, BorderLayout.EAST);
		removeComponentListener(checkLeste, leste);
		// Adiciona o painel no oeste
		panelZonas.add(oeste, BorderLayout.WEST);
		removeComponentListener(checkOeste, oeste);
		// Adiciona o painel no centro
		panelZonas.add(centro, BorderLayout.CENTER);
		removeComponentListener(checkCentro, centro);

		// Adiciona os paineis no mainPanel
		mainPanel.add(panelChecks);
		mainPanel.add(panelZonas);

		add(mainPanel);
	}

	private void removeComponentListener(JCheckBox check, JPanel component) {
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "Estou selecionado? " + check.isSelected());
				component.setVisible(check.isSelected());
			}
		});
	}
}
