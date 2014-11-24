package mt;

/*
 * Sarmen Khodjasarian
 * visitor pattern
 */
public interface Visitor 
{
	public void visit(User user);
	public void visit(Group group);
}
