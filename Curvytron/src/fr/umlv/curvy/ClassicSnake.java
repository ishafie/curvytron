package fr.umlv.curvy;

public class ClassicSnake extends Snake implements AllSnake
{

	private int direction;
	/**
	 * Constructeur de la classe ClassicSnake
	 * @param id id du snake.
	 * @param posx coordonnee en x de la tête.
	 * @param posy coordonnee en y de la tête.
	 * @param dirx direction en x du snake.
	 * @param diry direction en y du snake.
	 * @param angle angle de la direction
	 * @param rotate rotation
	 * @param bonus bonus du snake
	 */
	public ClassicSnake(int id, double posx, double posy, double dirx, double diry, double angle, double rotate, Bonus bonus)
	{
		super(id, posx, posy, dirx, diry, angle, rotate, bonus);
		direction = (int)dirx;
	}
	
	/**
	 * Deplace le snake
	 * @param direction la direction du snake.
	 */
	public void move(int direction)
	{
		if (this.direction == direction || this.direction == -direction)
			return ;
		this.direction = direction;
		dirx = direction;
		diry = 0;
	}
	/**
	 * Deplace le snake suivant la direction
	 * @param direction direction du snake
	 */
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
