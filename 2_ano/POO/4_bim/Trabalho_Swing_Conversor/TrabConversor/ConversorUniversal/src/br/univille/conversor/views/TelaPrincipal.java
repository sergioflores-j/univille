package br.univille.conversor.views;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import br.univille.conversor.utils.CheckboxMenuItem;
import br.univille.conversor.utils.MenuItem;

public class TelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private List<JFormattedTextField> tfList = new ArrayList<JFormattedTextField>();

	public TelaPrincipal() {
		// Titulo da Janela
		setTitle("Conversor Universal");
		// Tamanho da Janela
		setSize(600, 300);
		// Nao permite modificar o tamanho da Tela
		setResizable(false);
		// Finaliza o programa quando fechar a janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Configura a tela
		setLayout();
	}

	// Configura a tela
	private void setLayout() {
		JTabbedPane panel = new JTabbedPane();
		addTab("Moeda", panel);
		addTab("Temperatura", panel);
		addTab("Comprimento", panel);

		setMenubar(panel);
		add(panel);
	}

	/**
	 * -------------- MENUBAR --------------
	 */

	private void setMenubar(JTabbedPane panel) {
		// Cria uma barra de menu para o JFrame
		JMenuBar menuBar = new JMenuBar();

		// Adiciona a barra de menu ao frame
		setJMenuBar(menuBar);

		// Define e adiciona dois menus drop down na barra de menus
		JMenu fileMenu = new JMenu("Arquivo");
		JMenu editMenu = new JMenu("Editar");
		JMenu helpMenu = new JMenu("Ajuda");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

		// Cria e adiciona um item simples para o menu
		MenuItem exitAction = new MenuItem("Sair", new MenuItem.ActionListener() {
			@Override
			public void onclick() {
				dispatchEvent(new WindowEvent(TelaPrincipal.this, WindowEvent.WINDOW_CLOSING));
			}
		});

		// Limpar todos os textfield
		MenuItem clearAction = new MenuItem("Limpar Campos", new MenuItem.ActionListener() {
			@Override
			public void onclick() {
				clearTextFields();
			}
		});
		// Mostrar nas abas
		CheckboxMenuItem showMoedaAction = new CheckboxMenuItem("Exibir Moedas", true, showHideTab(panel, "Moeda"));

		CheckboxMenuItem showTemperaturaAction = new CheckboxMenuItem("Exibir Temperaturas", true,
				showHideTab(panel, "Temperatura"));
		CheckboxMenuItem showComprimentosAction = new CheckboxMenuItem("Exibir Comprimentos", true,
				showHideTab(panel, "Comprimento"));

		MenuItem developersAction = new MenuItem("Desenvolvedores", new MenuItem.ActionListener() {
			@Override
			public void onclick() {
				Desktop desktop = Desktop.getDesktop();

				try {
					URI url = new URI("https://github.com/sergioflores-j");
					desktop.browse(url);
				} catch (URISyntaxException | IOException e) {
					e.printStackTrace();
				}
			}
		});

		MenuItem githubAction = new MenuItem("Repositório do Github", new MenuItem.ActionListener() {
			@Override
			public void onclick() {
				Desktop desktop = Desktop.getDesktop();

				try {
					URI url = new URI("https://github.com/sergioflores-j/univille");
					desktop.browse(url);
				} catch (URISyntaxException | IOException e) {
					e.printStackTrace();
				}
			}
		});
		MenuItem aboutAction = new MenuItem("Sobre", new MenuItem.ActionListener() {
			@Override
			public void onclick() {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});

		fileMenu.add(exitAction);
		editMenu.add(clearAction);
		editMenu.addSeparator();
		editMenu.add(showMoedaAction);
		editMenu.add(showTemperaturaAction);
		editMenu.add(showComprimentosAction);
		helpMenu.add(developersAction);
		helpMenu.add(githubAction);
		helpMenu.add(aboutAction);
	}

	private CheckboxMenuItem.ActionListener showHideTab(JTabbedPane panel, String title) {
		return new CheckboxMenuItem.ActionListener() {
			@Override
			public void onclick() {
				int i = panel.indexOfTab(title);
				if (i != -1) {
					panel.removeTabAt(i);
				} else {
					addTab(title, panel);
				}
			}
		};
	}

	/**
	 * -------------- TABS --------------
	 */

	private JPanel getMoedaPanel() {
		String[] itens = { "Real", "Dolar" };

		return panelModel(itens, new SubmitAction() {

			@Override
			public ActionListener action(JComboBox<String> combo1, JComboBox<String> combo2, JFormattedTextField field1,
					JFormattedTextField field2, JLabel labelError) {
				return new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String de = (String) combo1.getSelectedItem();
						String para = (String) combo2.getSelectedItem();

						if (de == null) {
							labelError.setText("Selecione a moeda 'de'.");
						} else if (para == null) {
							labelError.setText("Selecione a moeda 'para'.");
						} else if (de.equals(para)) {
							labelError.setText(
									"<html>Não é possível converter para a mesma moeda! <br> Selecione moedas diferentes.</html>");
						} else if (field1.getValue() == null) {
							labelError.setText("Informe o valor a ser convertido.");
						} else {
							labelError.setText("");
							double result = 0;
							try {
								result = convertMoeda(
										Double.parseDouble(field1.getText().replaceAll("\\.", "").replace(",", ".")),
										de, para);
							} catch (Exception e) {
								e.printStackTrace();
							}

							field2.setValue(result);
						}
					}
				};
			}
		});
	}

	private JPanel getTemperaturaPanel() {
		String[] itens = { "Celsius", "Kelvin" };
		return panelModel(itens, new SubmitAction() {

			@Override
			public ActionListener action(JComboBox<String> combo1, JComboBox<String> combo2, JFormattedTextField field1,
					JFormattedTextField field2, JLabel labelError) {
				return new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String de = (String) combo1.getSelectedItem();
						String para = (String) combo2.getSelectedItem();

						if (de == null) {
							labelError.setText("Selecione a grandeza 'de'.");
						} else if (para == null) {
							labelError.setText("Selecione a grandeza 'para'.");
						} else if (de.equals(para)) {
							labelError.setText(
									"<html>Não é possível converter para a mesma grandeza! <br> Selecione grandezas diferentes.</html>");
						} else if (field1.getValue() == null) {
							labelError.setText("Informe o valor a ser convertido.");
						} else {
							labelError.setText("");
							double result = 0;
							try {
								result = convertTemperatura(
										Double.parseDouble(field1.getText().replaceAll("\\.", "").replace(",", ".")),
										de, para);
							} catch (Exception e) {
								e.printStackTrace();
							}

							field2.setValue(result);
						}
					}
				};
			}
		});
	}

	private JPanel getComprimentoPanel() {
		String[] itens = { "Metro", "Milimetro" };
		return panelModel(itens, new SubmitAction() {

			@Override
			public ActionListener action(JComboBox<String> combo1, JComboBox<String> combo2, JFormattedTextField field1,
					JFormattedTextField field2, JLabel labelError) {
				return new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String de = (String) combo1.getSelectedItem();
						String para = (String) combo2.getSelectedItem();

						if (de == null) {
							labelError.setText("Selecione a grandeza 'de'.");
						} else if (para == null) {
							labelError.setText("Selecione a grandeza 'para'.");
						} else if (de.equals(para)) {
							labelError.setText(
									"<html>Não é possível converter para a mesma grandeza! <br> Selecione grandezas diferentes.</html>");
						} else if (field1.getValue() == null) {
							labelError.setText("Informe o valor a ser convertido.");
						} else {
							labelError.setText("");
							double result = 0;
							try {
								result = convertComprimento(
										Double.parseDouble(field1.getText().replaceAll("\\.", "").replace(",", ".")),
										de, para);
							} catch (Exception e) {
								e.printStackTrace();
							}

							field2.setValue(result);
						}
					}
				};
			}
		});
	}

	/**
	 * -------------- CALCULOS --------------
	 */

	private double convertMoeda(double value, String from, String to) {
		double convertedValue = 0;

		switch (from) {
		case "Dolar":
			if (to.equalsIgnoreCase("real")) {
				convertedValue = value * 4.20;
			}
			break;
		case "Real":
			if (to.equalsIgnoreCase("dolar")) {
				convertedValue = value / 4.20;
			}
			break;
		default:
			break;
		}

		return convertedValue;
	}

	private double convertTemperatura(double value, String from, String to) {
		double convertedValue = 0;

		switch (from) {
		case "Celsius":
			if (to.equalsIgnoreCase("kelvin")) {
				convertedValue = value + 273.15;
			}
			break;
		case "Kelvin":
			if (to.equalsIgnoreCase("celsius")) {
				convertedValue = value - 273.15;
			}
			break;
		default:
			break;
		}

		return convertedValue;
	}

	private double convertComprimento(double value, String from, String to) {
		double convertedValue = 0;

		switch (from) {
		case "Metro":
			if (to.equalsIgnoreCase("milimetro")) {
				convertedValue = value * 1000;
			}
			break;
		case "Milimetro":
			if (to.equalsIgnoreCase("metro")) {
				convertedValue = value / 1000;
			}
			break;
		default:
			break;
		}

		return convertedValue;
	}

	/**
	 * -------------- UTILS --------------
	 */

	// Cria uma interface para deixar os panels de conversão genéricos, recebendo
	// apenas a ação do submit
	private interface SubmitAction {
		ActionListener action(JComboBox<String> combo1, JComboBox<String> combo2, JFormattedTextField field1,
				JFormattedTextField field2, JLabel labelError);
	}

	// Cria um panel genérico que será utilizado por todas as tabs
	private JPanel panelModel(String[] itens, SubmitAction submitAction) {
		JPanel panel = new JPanel(null);
		JLabel labelError = new JLabel();
		labelError.setForeground(Color.RED);

		JLabel label1 = new JLabel("De:");
		NumberFormat fieldFormat = NumberFormat.getNumberInstance();
		fieldFormat.setMinimumFractionDigits(2);
		JFormattedTextField field1 = new JFormattedTextField(fieldFormat);
		tfList.add(field1);

		JComboBox<String> combo1 = new JComboBox<String>(itens);
		combo1.setSelectedIndex(-1);

		JLabel label2 = new JLabel("Para:");
		JFormattedTextField field2 = new JFormattedTextField(fieldFormat);
		field2.setEditable(false);
		tfList.add(field2);

		JComboBox<String> combo2 = new JComboBox<String>(itens);
		combo2.setSelectedIndex(-1);

		JButton submit = new JButton("Converter");
		submit.addActionListener(submitAction.action(combo1, combo2, field1, field2, labelError));

		label1.setBounds(20, 20, 50, 30);
		combo1.setBounds(80, 20, 140, 30);
		label2.setBounds(300, 20, 50, 30);
		combo2.setBounds(360, 20, 140, 30);
		field1.setBounds(80, 60, 140, 30);
		field2.setBounds(360, 60, 140, 30);
		submit.setBounds(380, 100, 120, 30);
		labelError.setBounds(80, 140, 400, 50);

		panel.add(label1);
		panel.add(combo1);
		panel.add(label2);
		panel.add(combo2);

		panel.add(field1);
		panel.add(field2);

		panel.add(submit);

		panel.add(labelError);

		return panel;
	}

	private void addTab(String title, JTabbedPane panel) {
		String[] tabs = { "Moeda", "Temperatura", "Comprimento" };
		JPanel[] panels = { getMoedaPanel(), getTemperaturaPanel(), getComprimentoPanel() };

		for (int i = 0; i < tabs.length; i++) {
			String tab = tabs[i];

			if (tab.equals(title)) {
				panel.addTab(tab, null, panels[i], "Conversor de " + tab);
			}
		}
	}

	private void clearTextFields() {
		for (JFormattedTextField tf : tfList) {
			tf.setText("");
		}
	}

}
