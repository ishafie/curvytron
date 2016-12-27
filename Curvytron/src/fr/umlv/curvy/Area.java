package fr.umlv.curvy;

import java.awt.geom.Ellipse2D;

import fr.umlv.zen5.ApplicationContext;

public class Area
{
	static public void draw(ApplicationContext context, Snake snake)
	{
		Ellipse2D.Float ellipse = new Ellipse2D.Float((int)snake.getPosx() - (int)snake.getSizex(), 
				(int)snake.getPosy() - (int)snake.getSizey(), snake.getSizex(), snake.getSizey());
		context.renderFrame(graphics ->
		{
			graphics.setColor(snake.getColor());
			graphics.fill(ellipse);
		});
	}
}

