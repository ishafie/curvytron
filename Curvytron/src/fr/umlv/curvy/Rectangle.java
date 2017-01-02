package fr.umlv.curvy;

import java.awt.geom.Rectangle2D;

public class Rectangle implements Shape {

	Rectangle2D.Float rect;
	
	public Rectangle(int x, int y, int w, int h)
	{
		rect = new Rectangle2D.Float(x, y, w, h);
	}
	
	public Shape createShape(int x, int y, int w, int h)
	{
		return new Rectangle(x, y, w, h);
	}
	
	public Rectangle2D.Float getShape()
	{
		return rect;
	}

}
