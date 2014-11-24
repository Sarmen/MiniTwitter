package mt;

/*
 * Sarmen Khodjasarian
 
 * visitor pattern for group counter
 */
public class CountGroupVisitor implements Visitor 
{

	protected int counter = 0;
	
	public void visit(User user) {
		// TODO Auto-generated method stub
	}

	public void visit(Group group) 
	{
		counter++;
	}
	
	public int getCounter() 
	{
		return counter;
	}

}
