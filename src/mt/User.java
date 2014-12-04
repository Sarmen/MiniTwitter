package mt;
/*
 * Sarmen Khodjasarian
 */
import java.util.*;


public class User extends Observable implements Observer, NodeComponet
{
	private String user;
	private List<User> followers;
	private List<User> following;
	private List<String> newsFeed;
	private int tweetCounter;
	private String msg;
	private long createdTime;
	private long lastUpdateTime;

	public User(String user)
	{
		this.user = user;
		createdTime = System.currentTimeMillis();
		lastUpdateTime = createdTime;
	}
	public User(String id, String msg)
	{
		this.user = id;
		this.msg = msg;
	}

	/*
	 * gets the tweeted message
	 */
	public String getTweet()
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
	public void tweet(String msg) 
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
		lastUpdateTime = System.currentTimeMillis();
	}	

	public List<User> FollowingListModel()
	{
		return following;
	}
	
	// to string returns user
	public String toString()
	{
		return getUser();
	}
	
	// getter for created time
	public long getCreatedTime()
	{
		return createdTime;
	}
	
	//getter for last updated time
	public long getLastUpdatedTime()
	{
		return lastUpdateTime;
	}
	
	
	public void accept(Visitor visitor) 
	{
		visitor.visitUser(this);
	}

}