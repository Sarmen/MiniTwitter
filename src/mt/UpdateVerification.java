package mt;

import java.util.ArrayList;

public class UpdateVerification implements Visitor 
{
	ArrayList<String> users;
	ArrayList<String> groups;
	private boolean valid;

	public UpdateVerification() 
	{
		users = new ArrayList<String>();
		groups = new ArrayList<String>();
		valid = true;
	}

	public boolean isValid() {
		return valid;
	}

	public void visitUser(User user) 
	{
		for(int i = 0; i < users.size(); i++)
		{
			if(user.toString().contains(" ") || users.get(i).toString().equals(user.toString()))
			{
				valid = false;
			}
			else
			{
				valid = true;
			}
			
		}
		users.add(user.toString());
	}

	public void visitGroup(Group group) 
	{
		for(int i = 0; i < groups.size(); i++)
		{
			if(group.toString().contains(" ") || groups.get(i).toString().equals(group.toString()))
			{
				valid = false;
			}
			else
			{
				valid = true;
			}
			
		}
		groups.add(group.toString());
	}

}
