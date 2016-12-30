package fr.umlv.curvy;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.KeyboardKey;

public class EventManager
{
	private ApplicationContext context;
	private Event eventOne;
	
	public EventManager(ApplicationContext context)
	{
		this.context = context;
		eventOne = null;
	}
	
	public int manageEvent(AllSnake playerOne, AllSnake playerTwo, boolean multijoueur)
	{
		int bonus = 1;
		long start_timestamp = System.currentTimeMillis();
		int LEFT = -1;
		int RIGHT = 1;
		int UP = -2;
		int DOWN = 2;
		Event.Action keypressed = Event.Action.KEY_PRESSED;
		if (multijoueur == true)
			eventOne = context.pollOrWaitEvent(80);
		else
			eventOne = context.pollOrWaitEvent(40);
		/*System.out.println(eventOne);*/
		/*waitTime(start_timestamp, 40);*/
		if (eventOne != null)
		{	
			if (multijoueur == true && eventOne.getAction() == keypressed && eventOne.getKey() == KeyboardKey.A)
				playerTwo.move(LEFT);
			else if (multijoueur == true && eventOne.getAction() == keypressed && eventOne.getKey() == KeyboardKey.D)
				playerTwo.move(RIGHT);
			else if (multijoueur == true && bonus == 1 && eventOne.getAction() == keypressed && eventOne.getKey() == KeyboardKey.W)
				playerTwo.moveUporDown(UP);
			else if (multijoueur == true && bonus == 1 && eventOne.getAction() == keypressed && eventOne.getKey() == KeyboardKey.S)
				playerTwo.moveUporDown(DOWN);
			if (eventOne.getAction() == keypressed && eventOne.getKey() == KeyboardKey.LEFT)
				playerOne.move(LEFT);
			else if (eventOne.getAction() == keypressed && eventOne.getKey() == KeyboardKey.RIGHT)
				playerOne.move(RIGHT);
			else if (eventOne.getAction() == keypressed && eventOne.getKey() == KeyboardKey.SPACE)
				return (0);
			else if (bonus == 1 && eventOne.getAction() == keypressed && eventOne.getKey() == KeyboardKey.UP)
				playerOne.moveUporDown(UP);
			else if (bonus == 1 && eventOne.getAction() == keypressed && eventOne.getKey() == KeyboardKey.DOWN)
				playerOne.moveUporDown(DOWN);
			/*else if (event.getAction() == keypressed && event.getKey() == KeyboardKey.A)
				bonus = 2;
			else if (event.getAction() == keypressed && event.getKey() == KeyboardKey.E)
				bonus = 3;*/
		}
		playerOne.moveForward();
		if (multijoueur == true)
		{
			playerTwo.moveForward();
			flushEvent(context);
			eventOne = null;
		}
		return (bonus);
	}
	
	/**
	 * wait timestamp milliseconds
	 * 
	 * long timestamp, defines time to wait in milliseconds
	 * long start, defines start time (timestamp)
	 */
	public void waitTime(long start, long timestamp)
	{
		while (System.currentTimeMillis() - start < timestamp)
			;
	}
	
	public void flushEvent(ApplicationContext context)
	{
		while (context.pollEvent() != null)
			;
	}
	
}
