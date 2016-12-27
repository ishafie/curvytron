package fr.umlv.curvy;
import java.awt.Color;

import fr.umlv.zen5.*;

public class Main
{
	
	public static void main(String[] args)
	{
		LinkedLink<Snake> snakeList = new LinkedLink<Snake>();
		double ROTATION = 0.1;
		
		Application.run(Color.BLACK, context ->
		{
			Window window = new Window(context);
			Snake snake = new Snake(window.getWidth()/2, window.getHeight()/2, ROTATION);
			EventManager eventManager = new EventManager(context, snake);
			window.setWindow(context);
		    while (true)
		    {
		    	snakeList.add(new Snake(snake.getPosx(), snake.getPosy(), ROTATION));
				if (eventManager.manageEvent() == 0)
					break;
		    	Area.draw(context, snake);
		    	if (snake.checkCrash(snakeList, window) == true)
		    		break ;
		    }
		});
		System.out.println(snakeList.toString());
		System.out.println("LA FIN");
		System.exit(1);
}}
