package fr.umlv.curvy;

public class Snake
{
	private double dirx;
	private double diry;
	private double posx;
	private double posy;
	private double angle;
	private final double rotate;
	
	public Snake(double posx, double posy, double rotate)
	{
		this.posx = posx;
		this.posy = posy;
		this.rotate = rotate;
		dirx = 1;
		diry = 0;
		angle = 0;
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
		posx = posx + dirx;
		posy = posy + diry;
	}
	
	public void move(int direction)
	{
		dirx = Math.cos(angle + rotate * direction);
		diry = Math.sin(angle + rotate * direction);
		angle = angle + rotate * direction;
	}
}
