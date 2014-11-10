package mt;

import java.awt.EventQueue;

public class Driver 
{
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					AdminControlP window = new AdminControlP();
					window.frame.setVisible(true);
					window.frame.setTitle("Mini Twitter");
					
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
	}
}
