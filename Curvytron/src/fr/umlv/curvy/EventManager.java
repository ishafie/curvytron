package fr.umlv.curvy;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.KeyboardKey;

public class EventManager
{
	private ApplicationContext context;
	private Event event;
	
	public EventManager(ApplicationContext context)
	{
		this.context = context;
		event = null;
	}
	
	public int manageEvent(AllSnake snake)
	{
		int bonus = 1;
		long start_timestamp = System.currentTimeMillis();
		int LEFT = -1;
		int RIGHT = 1;
		int UP = -2;
		int DOWN = 2;
		Event.Action keypressed = Event.Action.KEY_PRESSED;
		event = context.pollEvent();
		if (event != null)
			System.out.println(event);
		waitTime(start_timestamp, 30);
		if (event != null)
		{
			if (event.getAction() == keypressed && event.getKey() == KeyboardKey.LEFT)
				snake.move(LEFT);
			else if (event.getAction() == keypressed && event.getKey() == KeyboardKey.RIGHT)
				snake.move(RIGHT);
			else if (event.getAction() == keypressed && event.getKey() == KeyboardKey.SPACE)
				return (0);
			else if (event.getAction() == keypressed && event.getKey() == KeyboardKey.A)
				bonus = 2;
			else if (bonus == 1 && event.getAction() == keypressed && event.getKey() == KeyboardKey.UP)
				snake.moveUporDown(UP);
			else if (bonus == 1 && event.getAction() == keypressed && event.getKey() == KeyboardKey.DOWN)
				snake.moveUporDown(DOWN);
		}
		snake.moveForward();
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
	
}
