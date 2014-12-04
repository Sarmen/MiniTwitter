package mt;

/*
 * Sarmen Khodjasarian
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class UserGui extends JFrame implements Observer
{

	private JFrame frame;
	private JTextArea taUserId;
	private User user;
	private Group root;
	private JTextArea taTweetMessage;
	private JList listCurrentFollowers;
	private JList listNewsFeed;
	private JLabel lblLastUpdatedTime;

	/**
	 * Initialize the contents of the frame.
	 */
	UserGui(User u, Group g) 
	{
		Border border = new LineBorder(Color.BLACK, 1);
		Border border2 = new LineBorder(Color.WHITE, 2);
		user = u;
		root = g;
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 430, 550);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		taUserId = new JTextArea();
		taUserId.setText("User ID");
		taUserId.setBounds(14, 11, 175, 38);
		taUserId.setBorder(border);
		frame.getContentPane().add(taUserId);
		
		taTweetMessage = new JTextArea();
		taTweetMessage.setText("Tweet Message");
		taTweetMessage.setBounds(14, 213, 175, 38);
		taTweetMessage.setBorder(border);
		frame.getContentPane().add(taTweetMessage);
		
		listCurrentFollowers = new JList<String>();
		listCurrentFollowers.setBounds(14, 60, 390, 140);
		listCurrentFollowers.setBorder(border);
		frame.getContentPane().add(listCurrentFollowers);
		
		listNewsFeed = new JList<String>();
		listNewsFeed.setBounds(14, 262, 391, 140);
		listNewsFeed.setBorder(border);
		frame.getContentPane().add(listNewsFeed);
		
		
		JButton btnFollowUser = new JButton("Follow User");
		btnFollowUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserVisitor v = new UserVisitor(taUserId.getText());
				root.accept(v);
				if(v.userExists())
				{
					user.follow(v.getUser());
					listCurrentFollowers.updateUI();
				}
			}
		});
		btnFollowUser.setBounds(199, 11, 205, 38);
		btnFollowUser.setBorder(border);
		frame.getContentPane().add(btnFollowUser);
		
		
		JButton btnPostTweet = new JButton("Post Tweet");
		btnPostTweet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.tweet(taTweetMessage.getText());
			}
		});
		btnPostTweet.setBounds(199, 213, 205, 38);
		btnPostTweet.setBorder(border);
		frame.getContentPane().add(btnPostTweet);
		
		
		JLabel lblCreatedText = new JLabel("     Created Time:");
		lblCreatedText.setBounds(14, 423, 138, 20);
		lblCreatedText.setBorder(border2);
		frame.getContentPane().add(lblCreatedText);
		
		JLabel lblCreationTime = new JLabel("   0");
		lblCreationTime.setBounds(162, 423, 205, 20);
		lblCreationTime.setBorder(border2);
		frame.getContentPane().add(lblCreationTime);
		
		JLabel lblLastUpdatedTimeTxt = new JLabel("   Last Updated Time:");
		lblLastUpdatedTimeTxt.setBounds(14, 455, 138, 20);
		lblLastUpdatedTimeTxt.setBorder(border2);
		frame.getContentPane().add(lblLastUpdatedTimeTxt);
		
		lblLastUpdatedTime = new JLabel("   0");
		lblLastUpdatedTime.setBounds(162, 457, 205, 20);
		lblLastUpdatedTime.setBorder(border2);
		frame.getContentPane().add(lblLastUpdatedTime);
	}

	public void update(Observable arg0, Object arg1) 
	{
		lblLastUpdatedTime.setText(((Long)user.getLastUpdatedTime()).toString());
		lblLastUpdatedTime.updateUI();
	}
}
