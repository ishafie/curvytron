package fr.umlv.curvy;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

public class Bonus {

	private double speed;
	private int sizex;
	private int sizey;
	private Color color;
	private Shape shape;
	
	public Bonus(Color color, Shape shape)
	{
		Objects.requireNonNull(color);
		this.color = color;
		speed = 5;
		sizex = 10;
		sizey = 10;
		this.shape = shape;
	}

	public Color getColor()
	{
		return color;
	}
	
	public int getSizeX()
	{
		return sizex;
	}
	
	public int getSizeY()
	{
		return sizey;
	}
	
	public double getSpeed()
	{
		return speed;
	}
	
	public void changeShape()
	{
		if (shape instanceof Rectangle2D.Float)
			shape = new Ellipse2D.Float();
		else if (shape instanceof Ellipse2D.Float)
			shape = new Rectangle2D.Float();
	}
	
	public Shape createShape(int x, int y, int w, int h)
	{
		if (shape instanceof Rectangle2D.Float)
			return new Rectangle2D.Float(x, y, w, h);
		else if (shape instanceof Ellipse2D.Float)
			return new Ellipse2D.Float(x, y, w, h);
		return new Rectangle2D.Float(x, y, w, h);
	}
	
	public void increaseSize(double increasing)
	{
		double oldspeed = speed - sizex/2;
		
		System.out.println("oldspeed = " + oldspeed);
		sizex *= increasing;
		sizey *= increasing;
		if (speed < sizex/2)
			speed = oldspeed + sizex/2;
	}
	
	public void increaseSpeed(double increasing)
	{
		speed *= increasing;
	}
	
}
