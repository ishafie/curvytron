package fr.umlv.curvy;

public class ClassicSnake extends Snake implements AllSnake
{

	private int direction;
	
	public ClassicSnake(double posx, double posy, double dirx, double diry, double rotate)
	{
		super(posx, posy, dirx, diry, rotate);
		direction = 0;
	}
	
	public void move(int direction)
	{
		if (this.direction == direction || this.direction == -direction)
			return ;
		this.direction = direction;
		dirx = direction;
		diry = 0;
	}
	
	public void moveForward()
	{
		posx = posx + dirx * speed;
		posy = posy + diry * speed;
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
