package mt;

public class UserVisitor implements Visitor 
{

	private String id;
	private User user;
	private boolean userExists;

	public UserVisitor(String id) 
	{
		this.id = id;
		user = null;
		userExists = false;
	}

	public User getUser() 
	{
		return user;
	}

	public boolean userExists() 
	{
		return userExists;
	}

	public void visitUser(User user) 
	{
		if (user.toString().equals(id)) 
		{
			this.user = user;
			userExists = true;
		}
	}

	public void visitGroup(Group group) {
		// TODO Auto-generated method stub

	}

}
