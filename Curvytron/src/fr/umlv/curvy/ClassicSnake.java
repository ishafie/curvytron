package fr.umlv.curvy;

public class ClassicSnake extends Snake implements AllSnake
{

	private int direction;
	
	public ClassicSnake(double posx, double posy, double dirx, double diry, double angle, double rotate)
	{
		super(posx, posy, dirx, diry, angle, rotate);
		direction = (int)dirx;
	}
	
	public void move(int direction)
	{
		if (this.direction == direction || this.direction == -direction)
			return ;
		this.direction = direction;
		dirx = direction;
		diry = 0;
	}
	
	public void moveUporDown(int direction)
	{
		if (this.direction == direction || this.direction == -direction)
			return ;
		this.direction = direction;
		dirx = 0;
		diry = 0;
		if (direction == 1 || direction == -1)
			dirx = direction;
		else
			diry = direction / 2;
	}
}
