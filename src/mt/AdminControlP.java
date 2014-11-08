package mt;

import java.awt.*;
import javax.swing.*;

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
		frame.setBounds(100, 100, 500, 338);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		Panel panel = new Panel();
		panel.setBackground(new Color(175, 238, 238));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBounds(0, 0, 166, 292);
		panel.add(tree);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(176, 8, 144, 48);
		panel.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(176, 67, 144, 48);
		panel.add(textArea_1);
		
		Button button = new Button("Show User Total");
		button.setBackground(Color.WHITE);
		button.setBounds(172, 217, 144, 33);
		panel.add(button);
		
		Button button_1 = new Button("Show Group Total");
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(330, 217, 144, 33);
		panel.add(button_1);
		
		Button button_2 = new Button("Show Message Total");
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(172, 256, 144, 36);
		panel.add(button_2);
		
		Button button_3 = new Button("Show Positive Percentage");
		button_3.setForeground(Color.BLACK);
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(330, 256, 144, 36);
		panel.add(button_3);
		
		Button button_4 = new Button("Add User");
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(327, 12, 147, 44);
		panel.add(button_4);
		
		Button button_5 = new Button("Add Group");
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(330, 67, 144, 48);
		panel.add(button_5);
		
		Button button_6 = new Button("Open User View");
		button_6.setBackground(Color.WHITE);
		button_6.setBounds(176, 121, 298, 35);
		panel.add(button_6);
	}
}
