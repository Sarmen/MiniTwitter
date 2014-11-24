package mt;
/*
 * Sarmen Khodjasarian
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;

import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

public class AdminControlGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8504114242947989148L;
	private JTree tree;
	private JTextArea addUserTA;
	private JTextArea addGroupTA;
	private String selected;
	private DefaultMutableTreeNode selectedNode;
	String newUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminControlGui window = new AdminControlGui();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminControlGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		Border border = new LineBorder(Color.BLACK, 1);
		getContentPane().setBackground(Color.CYAN);
		setBounds(100, 100, 584, 407);
		setTitle("Mini Twitter - Admin Control Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		tree = new JTree();
		tree.setBounds(6, 7, 244, 354);
		selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if(selectedNode == null)
			selectedNode = (DefaultMutableTreeNode) tree.getModel().getRoot();
		
		getContentPane().add(tree);

		
/////////////////////////// TextAreas for AdminControl //////////////////////////////////////////////////////
		addUserTA = new JTextArea();
		addUserTA.setBorder(border);
		addUserTA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addUserTA.setText("");
			}
		});
		addUserTA.setBounds(260, 4, 148, 42);
		getContentPane().add(addUserTA);

		addGroupTA = new JTextArea();
		addGroupTA.setBounds(260, 64, 148, 42);
		addGroupTA.setBorder(border);
		addGroupTA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addGroupTA.setText("");
			}
		});
		getContentPane().add(addGroupTA);
//////////////////////////////////////////////////////////////////////
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setBounds(418, 4, 140, 42);
		btnAddUser.setBorder(border);
		btnAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				selectedNode.add((MutableTreeNode) new User(addUserTA.getText()));
				tree.updateUI();
			}
		});
		getContentPane().add(btnAddUser);

		JButton btnAddGroup = new JButton("Add Group");
		btnAddGroup.setBounds(418, 64, 140, 42);
		btnAddGroup.setBorder(border);
		btnAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				selectedNode.add((MutableTreeNode) new Group(addGroupTA.getText()));
				tree.updateUI();
			}
		});
		getContentPane().add(btnAddGroup);

		JButton btnOpenUserView = new JButton("Open User View");
		btnOpenUserView.setBounds(268, 117, 290, 42);
		btnOpenUserView.setBorder(border);
		if(selectedNode instanceof User)
		{
		User us = (User) selectedNode;
			SwingUtilities.invokeLater(new Runnable() 
			{
				public void run() 
				{
					us.getUser().setVisibility(true);
				}
			}
		}
		getContentPane().add(btnOpenUserView);
// /////////////////////////// Buttons for the 4 counter/////////////////////////////////////////////////////

		JButton btnShowUserTotal = new JButton("Show User Total");
		btnShowUserTotal.setBounds(268, 248, 140, 42);
		btnShowUserTotal.setBorder(border);
		btnShowUserTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "The User Count is : "
						+ Account.getInstance().getUserCounter());
			}
		});
		getContentPane().add(btnShowUserTotal);

		JButton btnShowGroupTotal = new JButton("Show Group Total");
		btnShowGroupTotal.setBounds(418, 248, 140, 42);
		btnShowGroupTotal.setBorder(border);
		btnShowGroupTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "The Group count is : "
						+ Account.getInstance().getGroupCounter());
			}
		});
		getContentPane().add(btnShowGroupTotal);

		JButton btnShowMessagesTotal = new JButton("Show Messages Total");
		btnShowMessagesTotal.setBounds(267, 296, 141, 42);
		btnShowMessagesTotal.setBorder(border);
		btnShowMessagesTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "The Message count is : "
						+ Account.getInstance().getMessageCounter());
			}
		});
		getContentPane().add(btnShowMessagesTotal);

		JButton btnShowPositivePercentage = new JButton(
				"Show Possitive Percentage");
		btnShowPositivePercentage.setBounds(421, 296, 137, 42);
		btnShowPositivePercentage.setBorder(border);
		btnShowMessagesTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "% of Postive word is  : "
						+ Account.getInstance().getMessageCounter()+ "%");
			}
		});
		getContentPane().add(btnShowPositivePercentage);
		
	}
}
