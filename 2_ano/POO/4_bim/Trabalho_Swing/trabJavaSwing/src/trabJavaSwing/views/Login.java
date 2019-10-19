package trabJavaSwing.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Login() {
		// Titulo da Janela
		setTitle("Login");
		// Tamanho da Janela
		setSize(300, 300);
		// Nao permite modificar o tamanho da Tela
		setResizable(false);
		// Finaliza o programa quando fechar a janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Configura a tela
		setLayout();
	}

	// Configura a tela
	private void setLayout() {
		JPanel panel = new JPanel();
		// Retira o gerenciador de layout
		panel.setLayout(null);
		// Adiciona bordas
		panel.setBorder(BorderFactory.createCompoundBorder(
				// Margem
				BorderFactory.createEmptyBorder(20, 20, 20, 20)
				// Com titulo
				, BorderFactory.createTitledBorder("Login")));

		JLabel labelUser = new JLabel("Usuário");
		labelUser.setBounds(40, 40, 80, 30);

		JTextField user = new JTextField(10);
		user.setBounds(100, 40, 140, 30);

		JLabel labelPass = new JLabel("Senha");
		labelPass.setBounds(47, 80, 80, 30);

		JPasswordField password = new JPasswordField(10);
		password.setBounds(100, 80, 140, 30);

		JCheckBox check = new JCheckBox("Manter acessado");
		check.setSelected(true);
		check.setBounds(100, 150, 140, 30);
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Estou selecionado? " + check.isSelected());
			}
		});

		JButton button = new JButton("Acessar");
		button.setBounds(100, 120, 140, 30);
		button.setBackground(new Color(71, 82, 95));
		button.setForeground(Color.WHITE);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = user.getText();
				String senha = String.valueOf(password.getPassword());

				if (senha.equals("123")) {
					JOptionPane.showMessageDialog(null, "Olá " + usuario + "!");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos!");
				}
			}
		});

		JButton forgotPassButton = new JButton("Esqueci minha senha");
		forgotPassButton.setForeground(new Color(151, 109, 208));
		forgotPassButton.setOpaque(false);
		forgotPassButton.setContentAreaFilled(false);
		forgotPassButton.setBorderPainted(false);
		forgotPassButton.setBounds(80, 180, 180, 30);

		panel.add(labelUser);
		panel.add(user);
		panel.add(labelPass);
		panel.add(password);
		panel.add(check);
		panel.add(button);
		panel.add(forgotPassButton);

		// Adiciona o painel no frame
		add(panel);
	}

}
