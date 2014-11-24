package mt;

/*
 * Sarmen Khodjasarian
 */
import java.util.ArrayList;
import java.util.List;

public class Group implements NodeComponet 
{
	private List<NodeComponet> user = new ArrayList<NodeComponet>(); 
	private String id;

	public Group(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void addUser(NodeComponet u) {
		user.add(u);
	}

	public List<NodeComponet> getUser() {
		return user;
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
		visitor.visit(this);
		for (NodeComponet visit : user) 
		{
			visit.accept(visitor);
		}
	}

}
