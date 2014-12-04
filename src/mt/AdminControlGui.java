package mt;

/*
 * Sarmen Khodjasarian
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTree;

import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;


@SuppressWarnings("serial")
public class AdminControlGui extends JFrame implements TreeSelectionListener {

	private JTree tree;
	private Group root;
	private JTextArea addUserTA;
	private JTextArea addGroupTA;
	private DefaultMutableTreeNode rootNode;
	private DefaultMutableTreeNode selectedNode;
	private JButton btnAddUser;
	private JButton btnAddGroup;

	/**
	 * Create the application.
	 */
	public AdminControlGui(Group g) 
	{
		root = g;
		
		Border border = new LineBorder(Color.BLACK, 1);
		
		getContentPane().setBackground(Color.CYAN);
		setBounds(100, 100, 584, 430);
		setTitle("Mini Twitter - Admin Control Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		rootNode = new DefaultMutableTreeNode(root, true);
		tree = new JTree(rootNode, true);
		tree.addTreeSelectionListener(this);
		tree.setBorder(border);
		tree.setBounds(6, 7, 244, 374);
		getContentPane().add(tree);

		addUserTA = new JTextArea();
		addUserTA.setText("");
		addUserTA.setBorder(border);
		addUserTA.setBounds(260, 4, 148, 42);
		getContentPane().add(addUserTA);

		addGroupTA = new JTextArea();
		addGroupTA.setText("");
		addGroupTA.setBounds(260, 64, 148, 42);
		addGroupTA.setBorder(border);
		getContentPane().add(addGroupTA);

		btnAddUser = new JButton("Add User");
		btnAddUser.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (selectedNode != null && selectedNode.getUserObject() instanceof Group) {
		
					UserVisitor uv = new UserVisitor(addUserTA.getText());
					root.accept(uv);
					if (!uv.userExists()) 
					{
						addUserNode((Group) selectedNode.getUserObject(), new User(addUserTA.getText()));
					} 
					else 
					{
						JOptionPane.showMessageDialog(null, "Enter user ID");
					}
				} 
				else 
				{
					JOptionPane.showMessageDialog(null, "Select a group to add user to");
				}
			}
		});
		btnAddUser.setBounds(418, 4, 140, 42);
		btnAddUser.setBorder(border);
		getContentPane().add(btnAddUser);

		btnAddGroup = new JButton("Add Group");
		btnAddGroup.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				if(selectedNode != null && selectedNode.getUserObject() instanceof Group) 
				{
					GroupVisitor gv = new GroupVisitor(addGroupTA.getText());
					root.accept(gv);
					if(!gv.groupExists()) 
					{
						addGroupNode((Group)selectedNode.getUserObject(), new Group(addGroupTA.getText()));
					} 
					else 
					{
						JOptionPane.showMessageDialog(null, "Enter group ID");
					}
				} 
				else 
				{
					JOptionPane.showMessageDialog(null, "Select a group to add group to");
				}
			}
		});
		btnAddGroup.setBounds(418, 64, 140, 42);
		btnAddGroup.setBorder(border);
		getContentPane().add(btnAddGroup);

		JButton btnOpenUserView = new JButton("Open User View");
		btnOpenUserView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if(selectedNode != null && selectedNode.getUserObject() instanceof User) 
				{
					try 
					{
						UserGui ugui = new UserGui((User) selectedNode.getUserObject(), root);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				} 
				else 
				{
					JOptionPane.showMessageDialog(null, "Select a user to open their view");
				}
			}
		});
		btnOpenUserView.setBounds(268, 117, 290, 42);
		btnOpenUserView.setBorder(border);
		getContentPane().add(btnOpenUserView);
// /////////////////////////// Buttons for the 4 counter/////////////////////////////////////////////////////

		JButton btnShowUserTotal = new JButton("Show User Total");
		btnShowUserTotal.setBounds(260, 286, 140, 42);
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
		btnShowGroupTotal.setBounds(418, 286, 140, 42);
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
		btnShowMessagesTotal.setBounds(260, 339, 141, 42);
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
		btnShowPositivePercentage.setBounds(421, 339, 137, 42);
		btnShowPositivePercentage.setBorder(border);
		btnShowPositivePercentage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "% of Postive word is  : "
						+ Account.getInstance().getMessageCounter()+ "%");
			}
		});
		getContentPane().add(btnShowPositivePercentage);
		
		JButton btnVerifiy = new JButton("User/Group ID Verification");
		btnVerifiy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				UpdateVerification uv = new UpdateVerification();
				root.accept(uv);
				if(uv.isValid())
					JOptionPane.showMessageDialog(null, "All User's/Groups are valid");
				else
					JOptionPane.showMessageDialog(null, "Not all User's/Groups are valid");
			}
			
		});
		btnVerifiy.setBounds(268, 170, 290, 33);
		btnVerifiy.setBorder(border);
		getContentPane().add(btnVerifiy);
		
		JButton btnFindLastUpdateUser = new JButton("Find Last Updated User");
		btnFindLastUpdateUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JOptionPane.showMessageDialog(null, "Last Updated user is: " + Account.getInstance().getLastUpdated());
			}
		});
		btnFindLastUpdateUser.setBounds(268, 214, 290, 33);
		btnFindLastUpdateUser.setBorder(border);
		getContentPane().add(btnFindLastUpdateUser);
		
	}
	
	/*
	 * add user noded to the DefaultMutabletree to be able to add to the tree ui
	 * and adds it to the group list
	 */
	private void addUserNode(Group group, User u) 
	{
		group.add(u);
		selectedNode.add(new DefaultMutableTreeNode(u, false));
		tree.updateUI();
		
	}
	/*
	 * add sub group noded to the DefaultMutabletree to be able to add to the tree ui
	 * and adds it to the super group list
	 */
	private void addGroupNode(Group superG, Group subG) 
	{
		superG.add(subG);
		selectedNode.add(new DefaultMutableTreeNode(subG, true));
		tree.updateUI();
	}
	public void valueChanged(TreeSelectionEvent arg0) 
	{
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		selectedNode = node;
		
	}
}
