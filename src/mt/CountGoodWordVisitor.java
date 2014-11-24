package mt;
/*
 * Sarmen Khodjasarian
 */
import java.util.List;

/*
 * Visitor pattern for good word
 */
public class CountGoodWordVisitor implements Visitor 
{
	protected String [] goodWord = {"good", "great", "love"};
	protected int totalWordCounter = 0;
	protected int goodWordCounter = 0;
	
	
	public void visit(User user) 
	{
		List<String> tweetsTemp = user.getTweet();
		for(String s: tweetsTemp)
		{
			String [] words = s.split(" ");
			for(String w: words)
			{
				totalWordCounter++;
			
				for(String gw: goodWord)
				{
					if(s.equals(gw))
					{
						goodWordCounter++;
					}
				}
			}
		}

	}

	public void visit(Group group) {
		// TODO Auto-generated method stub

	}
	
	public int returnGoodWordPercent()
	{
		int result = goodWordCounter/totalWordCounter;
		return result;
	}

}
