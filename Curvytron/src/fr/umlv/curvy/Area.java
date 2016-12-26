package fr.umlv.curvy;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

import fr.umlv.zen5.ApplicationContext;

public class Area
{
	/*private Ellipse2D.Float ellipse = new Ellipse2D.Float(0, 0, 0, 0);*/
	static public void draw(ApplicationContext context, float x, float y)
	{
		Ellipse2D.Float ellipse = new Ellipse2D.Float(x - 10, y - 10, 10, 10);
		context.renderFrame(graphics ->
		{
			// hide the previous rectangle
			/*
			graphics.setColor(Color.ORANGE);
			graphics.fill(ellipse);
			*/
			// show a new ellipse at the position of the pointer
			graphics.setColor(Color.MAGENTA);
			graphics.fill(ellipse);
		});
	}
}

