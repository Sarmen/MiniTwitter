package mt;
/*
 * Sarmen Khodjasarian
 * 
 * visitor pattern for message counter
 */

public class CountMessagesVisitor implements Visitor 
{

	protected int tweetCounter = 0;
	
	public void visitUser(User user) 
	{
		tweetCounter += user.getTweetCount();
	}

	public void visitGroup(Group group) {
		// TODO Auto-generated method stub
	}
	
	public int getCounter()
	{
		return tweetCounter;
	}

}
