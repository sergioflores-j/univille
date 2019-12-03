package br.univille.trabmvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.univille.trabmvc.controller.TaskController;
import br.univille.trabmvc.model.Task;
import br.univille.trabmvc.utils.Observer;
import br.univille.trabmvc.utils.Subject;

public class TaskView extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	private Task model;
	private TaskController control;

	private JTextField idTextField;
	private JTextField titleTextField;
	private JCheckBox completedRadioButton;

	private JButton salvarButton;
	private JButton novoButton;
	private JButton deletarButton;
	private JLabel statusLabel;

	public TaskView() {
		setSize(400, 280);
		setTitle("Cadastro de Tarefa");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildLayout();
	}

	public void setModel(Task model) {
		this.model = model;
	}

	public void setControl(TaskController control) {
		this.control = control;
	}

	private void buildLayout() {
		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20),
				BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Detalhes da Tarefa"),
						BorderFactory.createEmptyBorder(10, 10, 10, 10))));

		this.idTextField = new JTextField(20);
		this.idTextField.setEnabled(false);
		this.titleTextField = new JTextField(20);
		this.completedRadioButton = new JCheckBox("Sim");
		
		this.salvarButton = new JButton("Salvar");
		this.salvarButton.setToolTipText("Salvar as alteraçoes");
		this.salvarButton.addActionListener(e -> salvar());

		this.novoButton = new JButton("Novo");
		this.novoButton.setToolTipText("Criar nova Tarefa");
		this.novoButton.addActionListener(e -> novo());
		this.deletarButton = new JButton("Deletar");
		this.deletarButton.setToolTipText("Excluir Tarefa");
		this.deletarButton.setEnabled(true);
		this.deletarButton.addActionListener(e -> deletar());

		JLabel l = new JLabel("Código", JLabel.RIGHT);
		l.setPreferredSize(new Dimension(60, 16));
		panel.add(l);
		panel.add(idTextField);

		l = new JLabel("Tarefa", JLabel.RIGHT);
		l.setPreferredSize(new Dimension(60, 16));
		panel.add(l);
		panel.add(this.titleTextField);
		
		l = new JLabel("Finalizada?", JLabel.RIGHT);
		l.setPreferredSize(new Dimension(90, 16));
		panel.add(l);
		panel.add(this.completedRadioButton);
		
		l = new JLabel();
		l.setPreferredSize(new Dimension(110, 16));
		panel.add(l);
		
		panel.add(this.novoButton);
		panel.add(this.salvarButton);
		panel.add(this.deletarButton);

		JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statusPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
		this.statusLabel = new JLabel("Cadastre uma Tarefa");
		statusPanel.add(this.statusLabel);

		root.add(statusPanel, BorderLayout.SOUTH);
		root.add(panel, BorderLayout.CENTER);

		add(root);
	}

	private void exibirDados() {
		this.idTextField.setText(String.valueOf(this.model.getId()));
		this.titleTextField.setText(this.model.getTitle());
	}

	private void salvar() {
		this.control.salvar();
	}

	private void deletar() {
		this.control.deletar();
	}

	private void novo() {
		this.control.novo();
	}

	public JButton getBotaoDeletar() {
		return this.deletarButton;
	}

	public void setMensagemStatusBar(String text) {
		this.statusLabel.setText(text);
	}

	@Override
	public void update(Subject s, Object o) {
		this.model = (Task) o;
		exibirDados();
	}

	public String getId() {
		return this.idTextField.getText();
	}

	public String getTitle() {
		return this.titleTextField.getText();
	}

	public Boolean getCompleted() {
		return this.completedRadioButton.isSelected();
	}

}
