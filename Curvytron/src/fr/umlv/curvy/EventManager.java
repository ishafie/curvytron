package fr.umlv.curvy;

import java.util.Objects;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.KeyboardKey;

public class EventManager
{
	private ApplicationContext context;
	private Event eventOne;

	public EventManager(ApplicationContext context)
	{
		Objects.requireNonNull(context);
		this.context = context;
		eventOne = null;
	}
	
	public int manageEvent(AllSnake player, int id)
	{
		int ret = 1;
		long startTime = System.currentTimeMillis();
		long currentTime = 0;
		
		eventOne = context.pollOrWaitEvent(40);
		currentTime = System.currentTimeMillis();
		if (currentTime - startTime < 40)
			waitTime(System.currentTimeMillis(), 40 - (currentTime - startTime));
		if (eventOne != null)
			ret = actionEvent(player, id);
		player.moveForward();
		return (ret);
	}
	
	
	public int actionEvent(AllSnake player, int id)
	{
		int bonus = 1;
		if (id == 1)
			bonus = movesetPlayerOne(player);
		else if (id == 2)
			bonus = movesetPlayerTwo(player);
		if (id > 1)
		{
			flushEvent(context);
			eventOne = null;
		}
		return (bonus);
	}
	
	public int movesetPlayerTwo(AllSnake player)
	{
		int LEFT = -1;
		int RIGHT = 1;
		int UP = -2;
		int DOWN = 2;
		Event.Action keypressed = Event.Action.KEY_PRESSED;
		Event.Action keyreleased = Event.Action.KEY_RELEASED;
		if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.Q)
			player.move(LEFT);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.D)
			player.move(RIGHT);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.SPACE)
			return (0);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.Z)
			player.moveUporDown(UP);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.S)
			player.moveUporDown(DOWN);
		return (1);
	}
	
	public int movesetPlayerOne(AllSnake player)
	{
		int LEFT = -1;
		int RIGHT = 1;
		int UP = -2;
		int DOWN = 2;
		Event.Action keypressed = Event.Action.KEY_PRESSED;
		Event.Action keyreleased = Event.Action.KEY_RELEASED;
		if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.LEFT)
			player.move(LEFT);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.RIGHT)
			player.move(RIGHT);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.SPACE)
			return (0);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.UP)
			player.moveUporDown(UP);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.DOWN)
			player.moveUporDown(DOWN);
		return (1);
	}
	/**
	 * wait timestamp milliseconds
	 * 
	 * long timestamp, defines time to wait in milliseconds
	 * long start, defines start time (timestamp)
	 */
	public void waitTime(long start, long timestamp)
	{
		System.out.println(timestamp);
		while (timestamp > 0 && System.currentTimeMillis() - start < timestamp)
		{
			;
		}
	}
	
	public void flushEvent(ApplicationContext context)
	{
		while (context.pollEvent() != null)
			;
	}
	
}
