package fr.umlv.curvy;
import java.awt.Color;

import fr.umlv.zen5.*;

public class Main
{
	
	public static void main(String[] args)
	{
		double ROTATION = 0.1;
		
		Application.run(Color.BLACK, context ->
		{
			int ret = 0;
			Window window = new Window(context);
			Map map = new Map((int)window.getWidth(), (int)window.getHeight(), window);
			AllSnake snake = new Snake(window.getWidth()/2, window.getHeight()/2, 1, 0, ROTATION);
			EventManager eventManager = new EventManager(context);
			window.setWindow(context);
		    while (true)
		    {
		    	map.setCase((int)snake.getPosx(), (int)snake.getPosy());
		    	ret = eventManager.manageEvent(snake);
				if (ret == 0)
					break ;
				if (ret == 2)
				{
					if (snake instanceof ClassicSnake)
						snake = new Snake(snake.getPosx(), snake.getPosy(), snake.getDirx(), snake.getDiry(), ROTATION);
					else
						snake = new ClassicSnake(snake.getPosx(), snake.getPosy(), snake.getDirx(), snake.getDiry(), ROTATION);
					snake.moveForward();
				}
		    	Draw.draw(context, snake);
		    	if (snake.checkCrash(map, window) == true)
		    	{
		    		System.out.println("CRASH");
		    		break ;
		    	}
		    }
		});
		System.out.println("LA FIN");
		System.exit(1);
}}
