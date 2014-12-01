package mt;

/*
 * Sarmen Khodjasarian
 * 
 * visitor pattern for user counter
 */

public class CountUserVisitor implements Visitor
{
	protected int counter = 0;

	public void visitUser(User user) 
	{
		counter ++;
	}

	public int getCounter() {
		return counter;
	}

	public void visitGroup(Group group) {
		// TODO Auto-generated method stub
	}

}
