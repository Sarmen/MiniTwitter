package mt;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminControlP{

	JFrame frame;
	/**
	 * Create the application.
	 */
	public AdminControlP() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 338);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		Panel panel = new Panel();
		panel.setBackground(new Color(175, 238, 238));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTree treeView = new JTree();
		treeView.setBounds(0, 0, 180, 292);
		panel.add(treeView);
		
		JTextArea userId = new JTextArea();
		userId.setBounds(200, 8, 144, 48);
		panel.add(userId);
		
		JTextArea groupId = new JTextArea();
		groupId.setBounds(200, 67, 144, 48);
		panel.add(groupId);
		
		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setBounds(364, 8, 144, 48);
		panel.add(btnAddUser);
		
		JButton btnAddGroup = new JButton("Add Group");
		btnAddGroup.setBounds(364, 67, 144, 48);
		panel.add(btnAddGroup);
		
		JButton btnOpenUserView = new JButton("Open User View");
		btnOpenUserView.setBounds(200, 126, 308, 37);
		panel.add(btnOpenUserView);
		
		JButton btnShowUserTotal = new JButton("Show User Total");
		btnShowUserTotal.setBounds(190, 217, 154, 33);
		panel.add(btnShowUserTotal);
		
		JButton btnShowGroupTotal = new JButton("Show Group Total");
		btnShowGroupTotal.setBounds(364, 217, 154, 33);
		panel.add(btnShowGroupTotal);
		
		JButton btnShowMessagetotal = new JButton("Show MessageTotal");
		btnShowMessagetotal.setBounds(190, 259, 154, 33);
		panel.add(btnShowMessagetotal);
		
		JButton btnShowPositivePercentage = new JButton("Show Positive Percentage");
		btnShowPositivePercentage.setBounds(364, 261, 154, 33);
		panel.add(btnShowPositivePercentage);
	}
}