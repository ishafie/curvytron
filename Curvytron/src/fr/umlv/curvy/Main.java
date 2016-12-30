package fr.umlv.curvy;
import java.awt.Color;

import fr.umlv.zen5.*;

public class Main
{
	
	public static void main(String[] args)
	{
		double ROTATION = 0.1;
		long start_timestamp = System.currentTimeMillis();
		
		Application.run(Color.BLACK, context ->
		{
			int ret = 0;
			Draw drawer = new Draw();
			Window window = new Window(context);
			Map map = new Map((int)window.getWidth(), (int)window.getHeight(), window);
			AllSnake snake = new Snake(window.getWidth()/2, window.getHeight()/2, 1, 0, 0, ROTATION);
			EventManager eventManager = new EventManager(context);
			BonusGenerator bg = new BonusGenerator(map);
			window.setWindow(context);
		    while (true)
		    {
		    	map.setCase((int)snake.getPosx(), (int)snake.getPosy(), 1);
		    	if ((System.currentTimeMillis() - start_timestamp) % 10000 < 50)
		    		bg.genBonus(context, drawer);
		    	if ((ret = eventManager.manageEvent(snake)) == 0)
					break ;
		    	else if (ret == 2)
					snake = Bonus.changeSnake(snake);
		    	drawer.draw(context, snake);
		    	/*System.out.println(snake);*/
		    	if (snake.checkCrash(map, window) == true)
		    	{
		    		System.out.println("CRASH");
		    		break ;
		    	}
		    	ret = snake.checkBonus(map);
		    	if (ret != 0 && ret != 1)
		    		Bonus.activeAndDelete(context, drawer, map, ret, snake);
		    	System.out.println("Check bonus = " + ret);
		    }
		});
		System.out.println("LA FIN");
		System.exit(1);
}}
