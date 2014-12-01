package mt;

/*
 * Sarmen Khodjasarian
 * visitor pattern
 */
public interface Visitor 
{
	public void visitUser(User user);
	public void visitGroup(Group group);
}
