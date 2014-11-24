package mt;
/*
 * Sarmen Khodjasarian
 */
import java.util.*;


public class User extends Observable implements Observer
{
	private String user;
	private List<User> followers;
	private List<User> following;
	private List<String> newsFeed;
	private int tweetCounter;
	private List<String> msg;

	public User(String user)
	{
		this.user = user;
	}
	public User(String id, List<String> msg)
	{
		this.user = id;
		this.msg = msg;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public void setUser(String user)
	{
		this.user = user;
	}
	/*
	 * gets the tweeted message
	 */
	public List<String> getTweet()
	{
		return msg;
	}
	/*
	 * get the tweet count after 
	 */
	public int getTweetCount()
	{
		return tweetCounter;
	}
	/*
	 * gets the followers of the user
	 */
	public void addFollower(User u) 
	{
		followers.add(u);
		System.out.println("Following " + u.toString());
	}
	/*
	 *  gets the users followerings
	 */
	public List<User> getFollowing() 
	{
		return following;
	}
	/*
	 * gets the users newsfeed
	 */
	public List<String> getNewsFeed() 
	{
		return newsFeed;
	}
	/*
	 * gets the user
	 */
	public String getUser()
	{
		return user;
	}
	/*
	 * lets user follower type user
	 */
	public void follow(User u) 
	{
		following.add(u);
		System.out.println("Following " + u.toString());
	}
	/*
	 * lets the user tweet, sets the tweet and counts it, 
	 * uses the observer class methods to notify the observers
	 */
	public void tweet(List<String> msg) 
	{
		this.msg = msg;
		tweetCounter++;
		newsFeed.add(getUser() + ": " + msg);
		System.out.println(getUser() + ": " + msg);
		setChanged();
		notifyObservers(msg);
		clearChanged();
		setChanged();
		notifyObservers(getNewsFeed());
		clearChanged();
	}
	/*
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable arg0, Object arg1) 
	{
		if(arg1 instanceof String)
		{
			newsFeed.add(((User) arg0).getUser() + ": " + arg1);
		}
	}	
	/*
	 * Composite Pattern. Returns the User.
	 */
	public User getUser(String id) 
	{
		if (id.equals(id)) 
		{
			return this;
		} 
		else 
		{
			return null;
		}
	}
	
	public void accpet(Visitor visitor) 
	{
		visitor.visit(this);
	}
	
	public String toString()
	{
		return getUser();
	}

}