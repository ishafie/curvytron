package fr.umlv.curvy;
import java.awt.Color;

public class Snake implements AllSnake
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
	
	public Snake(double posx, double posy, double dirx, double diry, double angle, double rotate, Color color)
	{
		this.posx = posx;
		this.posy = posy;
		this.rotate = rotate;
		System.out.println("Dirx = " + dirx);
		this.dirx = dirx;
		this.diry = diry;
		this.angle = angle;
		this.color = color;
		speed = 5;
		sizex = 10;
		sizey = 10;
	}
	
	public double getAngle()
	{
		return angle;
	}
	
	public double getRotate()
	{
		return rotate;
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
	
	public double getDirx()
	{
		return dirx;
	}
	
	public double getDiry()
	{
		return diry;
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
	
	public boolean checkCrash(Map map, Window w)
	{
		int i = 0;
		int id = 0;
		
		/*System.out.println("Check : " + this);*/
		if (outOfBound(w) == true)
			return true;
		while (i <= 2)
		{
			while (id <= 2)
			{
				if ((int)posy + id < w.getHeight() && (int)posx + id < w.getWidth() &&
						(int)posy + i < w.getHeight() && (int)posx + i < w.getWidth() &&
						(int)posy - id > 0 && (int)posy - i > 0 && (int)posx - id > 0 && (int)posx - i > 0
						&& (map.getCase((int)posx + i, (int)posy + id) == 1 || map.getCase((int)posx + i, (int)posy + id) == 2))
					return true;
				if (map.getCase((int)posx - i, (int)posy - id) == 1 || map.getCase((int)posx - i, (int)posy - id) == 2)
					return true;
				id++;
			}
			id = 0;
			i++;
		}
		return false;
	}
	
	public int checkBonus(Map map)
	{
		int i = 0;
		int id = 0;
		
		/*System.out.println("Check : " + this);*/
		while (i <= 2)
		{
			while (id <= 2)
			{
				if (map.getCase((int)posx + i, (int)posy + id) != 0 && map.getCase((int)posx + i, (int)posy + id) != 1)
					return map.getCase((int)posx + i, (int)posy + id);
				if (map.getCase((int)posx - i, (int)posy - id) != 0 && map.getCase((int)posx - i, (int)posy - id) != 1)
					return map.getCase((int)posx - i, (int)posy - id);
				id++;
			}
			id = 0;
			i++;
		}
		return 0;
	}
	
	public boolean outOfBound(Window w)
	{
		if (posx >= w.getWidth() || posy >= w.getHeight() || posx < 0 || posy < 0)
			return true;
		return false;
	}
	
	public void increaseSpeed(double increase)
	{
		speed *= increase;
	}
	
	/**
	 * pour interface seulement
	 */
	public void moveUporDown(int direction)
	{
		return ;
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
