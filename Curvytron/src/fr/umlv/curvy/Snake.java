package fr.umlv.curvy;
import java.awt.Color;

public class Snake
{
	protected double dirx;
	protected double diry;
	protected double posx;
	protected double posy;
	protected double angle;
	protected int speed;
	protected final double rotate;
	protected int sizex;
	protected int sizey;
	protected Color color;
	
	public Snake(double posx, double posy, double rotate)
	{
		this.posx = posx;
		this.posy = posy;
		this.rotate = rotate;
		dirx = 1;
		diry = 0;
		angle = 0;
		speed = 5;
		sizex = 10;
		sizey = 10;
		color = Color.GREEN;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public int getSizex()
	{
		return sizex;
	}
	
	public int getSizey()
	{
		return sizey;
	}
	
	public double getPosx()
	{
		return posx;
	}
	
	public double getPosy()
	{
		return posy;
	}
	
	public void moveForward()
	{
		posx = posx + dirx * speed;
		posy = posy + diry * speed;
	}
	
	public void move(int direction)
	{
		dirx = Math.cos(angle + rotate * direction);
		diry = Math.sin(angle + rotate * direction);
		angle = angle + rotate * direction;
	}
	
	public boolean checkCrash(LinkedLink<Snake> snakeList, Window w)
	{
		if (outOfBound(w) == true)
			return true;
		if (snakeList.search(this))
			return true;
		return false;
	}
	
	public boolean outOfBound(Window w)
	{
		if (posx >= w.getWidth() || posy >= w.getHeight() || posx < 0 || posy < 0)
			return true;
		return false;
	}
	
	@Override
	public String toString()
	{
		return ("(" + posx + ", " + posy + ")");
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof Snake)
		{
			Snake s = (Snake)o;
			if (((int)s.getPosx() >= (int)posx + 10 || (int)s.getPosx() <= (int)posx - 10) && ((int)s.getPosy() >= (int)posy + 10 || (int)s.getPosy() <= (int)posy - 10))
				return true;
		}
		return false;
	}
}
