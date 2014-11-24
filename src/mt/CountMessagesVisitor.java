package mt;

/*
 * Sarmen Khodjasarian
 * 
 * visitor pattern for message counter
 */

public class CountMessagesVisitor implements Visitor 
{

	protected int tweetCounter = 0;
	
	public void visit(User user) 
	{
		tweetCounter += user.getTweetCount();
	}

	public void visit(Group group) {
		// TODO Auto-generated method stub
	}
	
	public int getCounter()
	{
		return tweetCounter;
	}

}
