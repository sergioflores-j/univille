package br.univille.trabmvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import br.univille.trabmvc.controller.TaskListController;
import br.univille.trabmvc.model.Task;
import br.univille.trabmvc.utils.Observer;
import br.univille.trabmvc.utils.Subject;

public class TaskListView extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	private TaskListController control;
	private int editId;
	private List<Task> taskList = new ArrayList<Task>();

	private JPanel root;
	private JLabel statusLabel = new JLabel("Selecione uma Tarefa para editar");
	private List<JRadioButton> actionButtonList = new ArrayList<JRadioButton>();
	private JButton editButton;
	private JButton newButton;

	public TaskListView() {
		setSize(400, 280);
		setTitle("Listagem de Tarefas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initView() {
		System.out.println("INICIALIZA VIEW TASKLISt");
		setTaskList();
		this.setEditId(0);
		buildLayout();
	}

	public void setTaskList() {
		this.taskList = this.control.getList();
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void resetFrame() {
		try {
			getContentPane().removeAll();
			getContentPane().revalidate();
			getContentPane().repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buildLayout() {
		resetFrame();

		root = new JPanel();
		root.setLayout(new BoxLayout(root, BoxLayout.PAGE_AXIS));

		JPanel panel = new JPanel(new GridLayout(this.taskList.size() + 1, 3));

		actionButtonList.clear();

		if (this.taskList.size() == 0) {
			panel.setLayout(new BoxLayout(panel, panel.getY()));
			panel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
			
			panel.add(new JLabel("Nenhuma tarefa encontrada."));
		} else {
			panel.add(new JLabel("ID"));
			panel.add(new JLabel("Tarefa"));
			panel.add(new JLabel("Completa"));
			for (Task task : this.taskList) {
				JRadioButton rb = new JRadioButton();
				rb.setText(String.valueOf(task.getId()));
				rb.addActionListener(e -> setEditId(task.getId()));

				JLabel l = new JLabel(task.getTitle());

				actionButtonList.add(rb);
				String completed = "Não";
				if (task.isCompleted()) completed = "Sim";
				
				panel.add(rb);
				panel.add(l);
				panel.add(new JLabel(completed));
			}
		}

		JPanel actionsPanel = new JPanel(new BorderLayout());

		this.newButton = new JButton("Nova tarefa");
		this.newButton.setToolTipText("Criar uma tarefa");
		this.newButton.addActionListener(e -> novo());

		this.editButton = new JButton("Editar");
		this.editButton.setToolTipText("Editar a tarefa selecionada");
		this.editButton.addActionListener(e -> editar());

		actionsPanel.add(this.editButton, BorderLayout.LINE_START);
		actionsPanel.add(this.newButton, BorderLayout.LINE_END);

		JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statusPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10));
		statusPanel.add(this.statusLabel);

		JScrollPane scrollpane = new JScrollPane(panel);
//		scrollpane.setMinimumSize(new Dimension(400, 200));
		actionsPanel.setMaximumSize(new Dimension(400, 50));

		root.add(scrollpane);
		root.add(statusPanel);
		root.add(actionsPanel);

		add(root);
	}

	public void setEditId(int id) {
		this.editId = id;

		resetSelected();
	}

	public void resetSelected() {
		for (JRadioButton rb : this.actionButtonList) {
			if (!String.valueOf(this.editId).equals(rb.getText())) {
				rb.setSelected(false);
			}
		}
	}

	public void editar() {
		if (this.editId != 0) {
			this.control.edit(this.editId);
		} else {
			this.setMensagemStatusBar("Selecione uma tarefa para editar");
		}
	}

	public void novo() {
		this.control.newTask();
	}

	@Override
	public void update(Subject s, Object o) {
		System.out.println("UPDATE TASKLISTVIEW");
		initView();
	}

	public void setControl(TaskListController control) {
		this.control = control;
	}

	public void setMensagemStatusBar(String text) {
		this.statusLabel.setText(text);
	}
}
