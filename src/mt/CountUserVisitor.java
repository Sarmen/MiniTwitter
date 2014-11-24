package mt;

/*
 * Sarmen Khodjasarian
 * 
 * visitor pattern for user counter
 */

public class CountUserVisitor implements Visitor
{
	protected int counter = 0;

	public void visit(User user) 
	{
		counter ++;
	}

	public int getCounter() {
		return counter;
	}

	public void visit(Group group) {
		// TODO Auto-generated method stub
	}

}
