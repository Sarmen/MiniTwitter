package mt;

import javax.swing.JFrame;

/*
 * Sarmen Khodjasarian
 */
public class Account 
{
	private static Account instance = null;
	private Group root;
	public JFrame frame;
	
	private Account()
	{
		root = new Group("Root");
		try 
		{
			frame = new AdminControlGui(root);
			frame.setVisible(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/*
	 * implemented the lazy Singletons Pattern
	 */
	public static Account getInstance() 
	{
		if (instance == null) 
		{
			instance = new Account();
		}
		return instance;
	}
	
	/*
	 * getting the root of the Account
	 */
	public NodeComponet getRoot()
	{
		return root;
	}
	
	public User getLastUpdated()
	{
		LastUserUpdatedVisitor luuv = new LastUserUpdatedVisitor();
		root.accept(luuv);
		return luuv.getLastUser();
		
	}
	/*
	 * Using the Visitor pattern to get the user count
	 */
	public int getUserCounter()
	{
		CountUserVisitor cuv = new CountUserVisitor();
		root.accept(cuv);
		return cuv.getCounter();
	}
	
	/*
	 * Using the Visitor pattern to get the group count
	 */
	public int getGroupCounter()
	{
		CountGroupVisitor cgv = new CountGroupVisitor();
		root.accept(cgv);
		return cgv.getCounter();
	}
	
	/*
	 * Using the Visitor pattern to get the message count
	 */
	public int getMessageCounter()
	{
		CountMessagesVisitor cmv = new CountMessagesVisitor ();
		root.accept(cmv);
		return cmv.getCounter();
	}
	
	/*
	 * Using the Visitor pattern to get the positive word percentage
	 */
	public int getPositiveWord()
	{
		CountGoodWordVisitor cgwv = new CountGoodWordVisitor();
		root.accept(cgwv);
		return cgwv.returnGoodWordPercent();
	}
}
