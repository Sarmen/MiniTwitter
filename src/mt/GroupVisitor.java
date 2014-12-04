package mt;
/*
 * Visitor pattern that starts off false, when it exists it sets it to true
 */
public class GroupVisitor implements Visitor 
{
	private String id;
	private Group group;
	private boolean groupExists;

	public GroupVisitor(String id) 
	{
		this.id = id;
		group = null;
		groupExists = false;
	}

	public Group getGroup() 
	{
		return group;
	}

	public boolean groupExists() 
	{
		return groupExists;
	}

	public void visitUser(User user) 
	{
	}

	public void visitGroup(Group group) 
	{
		if (group.toString().equals(id)) 
		{
			this.group = group;
			groupExists = true;
		}
	}

}
