package mt;

/*
 * Sarmen Khodjasarian
 */
import java.util.ArrayList;
import java.util.List;

public class Group implements NodeComponet 
{
	private ArrayList<NodeComponet> users;
	private long createdTime;
	private String id;
	

	public Group(String id) 
	{
		users = new ArrayList<NodeComponet>();
		createdTime = System.currentTimeMillis();
		this.id = id;
		
	}

	public String toString() 
	{
		return id;
	}

	public void add(NodeComponet u) 
	{
		users.add(u);
	}
	
	public Group getGroup(String group)
	{
		if(id.equals(group))
		{
			return this;
		}
		else
		{
			return null;
		}
	}
	
	public void accept(Visitor visitor) 
	{
		visitor.visitGroup(this);
		for (NodeComponet visit : users) 
		{
			visit.accept(visitor);
		}
	}
	public long getCreatedTime() 
	{
		return createdTime;
	}
}
