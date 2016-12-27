package fr.umlv.curvy;

public class ClassicSnake extends Snake 
{

	public ClassicSnake(double posx, double posy, double rotate)
	{
		super(posx, posy, rotate);
	}
	
	public void moveForward()
	{
		posx = posx + dirx;
		posy = posy + diry;
	}
	
	public void move(int direction)
	{
		dirx = 0;
		diry = 0;
		if (direction == 1 || direction == -1)
			dirx = direction;
		else
			diry = direction / 2;
		angle = 90;
	}
}
