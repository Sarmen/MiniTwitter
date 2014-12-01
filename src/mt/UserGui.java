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
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserGui window = new UserGui();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public UserGui() {
//		initialize();
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	UserGui(User u, Group g) 
	{
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
		frame.getContentPane().add(taUserId);
		
		taTweetMessage = new JTextArea();
		taTweetMessage.setText("Tweet Message");
		taTweetMessage.setBounds(14, 213, 175, 38);
		frame.getContentPane().add(taTweetMessage);
		
		listCurrentFollowers = new JList((ListModel) user.getCurrentlyFollowingListModel());
		listCurrentFollowers.setBounds(14, 60, 390, 140);
		frame.getContentPane().add(listCurrentFollowers);
		
		listNewsFeed = new JList();
		listNewsFeed.setBounds(14, 262, 391, 140);
		frame.getContentPane().add(listNewsFeed);
		
		
		JButton btnFollowUser = new JButton("Follow User");
		btnFollowUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserVisitor v = new UserVisitor(taUserId.getText());
				root.accept(v);
				if(v.hasUser())
				{
					user.follow(v.getUser());
					listCurrentFollowers.updateUI();
				}
			}
		});
		btnFollowUser.setBounds(199, 11, 205, 38);
		frame.getContentPane().add(btnFollowUser);
		
		
		JButton btnPostTweet = new JButton("Post Tweet");
		user.tweet(taTweetMessage.getText());
		btnPostTweet.setBounds(199, 213, 205, 38);
		frame.getContentPane().add(btnPostTweet);
		
		
		JLabel lblCreatedText = new JLabel("Created Time:");
		lblCreatedText.setBounds(14, 423, 93, 21);
		frame.getContentPane().add(lblCreatedText);
		
		JLabel lblCreationTime = new JLabel(((Long)user.getCreatedTime()).toString());
		lblCreationTime.setBounds(137, 425, 230, 16);
		frame.getContentPane().add(lblCreationTime);
		
		JLabel lblLastUpdatedTimeTxt = new JLabel("Last Updated Time:");
		lblLastUpdatedTimeTxt.setBounds(14, 467, 93, 14);
		frame.getContentPane().add(lblLastUpdatedTimeTxt);
		
		lblLastUpdatedTime = new JLabel(((Long)user.getLastUpdatedTime()).toString());
		lblLastUpdatedTime.setBounds(137, 466, 230, 16);
		frame.getContentPane().add(lblLastUpdatedTime);
	}

	public void update(Observable arg0, Object arg1) 
	{
		lblLastUpdatedTime.setText(((Long)user.getLastUpdatedTime()).toString());
		lblLastUpdatedTime.updateUI();
		listNewsFeed.updateUI();
	}
}
