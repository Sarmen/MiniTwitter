package mt;

public class LastUserUpdatedVisitor implements Visitor
{
	private User lastUpdated;
	
	public LastUserUpdatedVisitor() 
	{
		lastUpdated = null;
	}
	public User getLastUser()
	{
		return lastUpdated;
	}
	public void visitUser(User user) 
	{
		if(lastUpdated == null || lastUpdated.getLastUpdatedTime() < user.getLastUpdatedTime() )
		{
			lastUpdated = user;
		}
		
	}

	public void visitGroup(Group group) 
	{
		// TODO Auto-generated method stub
		
	}
	
	public User getLastedUpdated()
	{
		return lastUpdated;
	}

}
