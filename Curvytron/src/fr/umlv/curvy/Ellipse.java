package fr.umlv.curvy;

import java.awt.geom.Ellipse2D;

public class Ellipse implements Shape {

	Ellipse2D.Float ellipse;
	
	public Ellipse(int x, int y, int w, int h)
	{
		ellipse = new Ellipse2D.Float(x, y, w, h);
	}
	
	public Shape createShape(int x, int y, int w, int h)
	{
		return new Ellipse(x, y, w, h);
	}
	
	public Ellipse2D.Float getShape()
	{
		return ellipse;
	}
}
