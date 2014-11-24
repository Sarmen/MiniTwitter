package mt;
/*
 * Sarmen Khodjasarian
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.AbstractListModel;

public class UserGui implements Observer{

	private JFrame frame;
	private JTextArea taUserId;
	private User user;
	private JList listNewsFeed;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGui window = new UserGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 415, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		taUserId = new JTextArea();
		taUserId.setBounds(14, 11, 175, 50);
		taUserId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				taUserId.setText("");
			}
		});
		frame.getContentPane().add(taUserId);
		
		final JList listCurrentFollowers = new JList();
		listCurrentFollowers.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listCurrentFollowers.setBounds(14, 72, 372, 95);
		frame.getContentPane().add(listCurrentFollowers);
		
		JButton btnFollowUser = new JButton("Follow User");
		btnFollowUser.setBounds(199, 11, 186, 50);
		btnFollowUser.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String userName = taUserId.getText();
				user.follow(new User(userName));
				listCurrentFollowers.setListData(user.getFollowing().toArray());
			}
			
		});
		frame.getContentPane().add(btnFollowUser);
		
		final JTextArea taTweetMessage = new JTextArea();
		taTweetMessage.setBounds(14, 175, 175, 50);
		taTweetMessage.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				taTweetMessage.setText("");
			}
		});
		frame.getContentPane().add(taTweetMessage);
		
		JButton btnPostTweet = new JButton("Post Tweet");
		btnPostTweet.setBounds(199, 175, 186, 50);
		btnPostTweet.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String tweet = taTweetMessage.getText();
				user.tweet(tweet);
			}
		});
		frame.getContentPane().add(btnPostTweet);
		
		listNewsFeed = new JList();
		listNewsFeed.setBounds(13, 231, 372, 95);
		frame.getContentPane().add(listNewsFeed);
	}

	public void update(Observable arg0, Object arg1) 
	{
		if(arg0 instanceof List){
			listNewsFeed.setListData(user.getNewsFeed().toArray());
		}
		
	}
}
