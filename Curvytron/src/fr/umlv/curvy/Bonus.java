package fr.umlv.curvy;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

public class Bonus {

	private double speed;
	private int sizex;
	private int sizey;
	private Color color;
	
	public Bonus(Color color)
	{
		Objects.requireNonNull(color);
		this.color = color;
		speed = 5;
		sizex = 10;
		sizey = 10;
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
