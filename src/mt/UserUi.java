package mt;

import java.awt.*;
import java.swing.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserUi 
{
	private JFrame frame;

	/**
	 * Create the application.
	 */
	public UserUi() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 450, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea userId = new JTextArea();
		userId.setBounds(10, 11, 201, 41);
		frame.getContentPane().add(userId);
		
		JList currentFollowing = new JList();
		currentFollowing.setBounds(10, 63, 414, 117);
		frame.getContentPane().add(currentFollowing);
		
		JTextArea tweetMessage = new JTextArea();
		tweetMessage.setBounds(10, 191, 201, 41);
		frame.getContentPane().add(tweetMessage);
		
		JList newsFeed = new JList();
		newsFeed.setBounds(10, 243, 414, 117);
		frame.getContentPane().add(newsFeed);
		
		JList list = new JList();
		list.setBounds(159, 46, 1, 1);
		frame.getContentPane().add(list);
		
		JButton btnFollowUser = new JButton("Follow User");
		btnFollowUser.setBounds(221, 12, 203, 40);
		frame.getContentPane().add(btnFollowUser);
		
		JButton btnFollowGroup = new JButton("Follow Group");
		btnFollowGroup.setBounds(221, 192, 203, 40);
		frame.getContentPane().add(btnFollowGroup);
	}
}
