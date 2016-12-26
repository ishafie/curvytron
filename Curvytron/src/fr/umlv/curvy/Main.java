package fr.umlv.curvy;
import java.awt.Color;
/*import java.awt.geom.Ellipse2D;*/
/*import java.awt.geom.Point2D;*/
import java.awt.geom.Rectangle2D;

import fr.umlv.zen5.*;

public class Main
{
	
	public static void main(String[] args)
	{
		double ROTATION = 0.1;
			
		Application.run(Color.BLACK, context ->
		{
			Window window = new Window(context);
			Snake snake = new Snake(window.getWidth()/2, window.getHeight()/2, ROTATION);
			EventManager eventManager = new EventManager(context, snake);
			window.setWindow(context);
		    while (true)
		    {
				if (eventManager.manageEvent() == 0)
					context.exit(1);
		    	Area.draw(context, (int)snake.getPosx(), (int)snake.getPosy());
		    }
		});
}}
