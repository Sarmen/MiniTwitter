package mt;

public class GroupVisitor implements Visitor {
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

	public boolean hasGroup() 
	{
		return groupExists;
	}

	public void visitUser(User user) {
		// Checking for group not user - do nothing
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
