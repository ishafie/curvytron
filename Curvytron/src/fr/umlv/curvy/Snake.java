package fr.umlv.curvy;
import java.util.ArrayList;
import java.util.Objects;

public class Snake implements AllSnake
{
	protected double dirx;
	protected double diry;
	protected double posx;
	protected double posy;
	protected double angle;
	protected final double rotate;
	protected int id;
	protected ArrayList<Case> head;
	protected Bonus bonus;
	
	public Snake(AllSnake snake)
	{
		this(snake.getId(), snake.getPosx(), snake.getPosy(), snake.getDirx(), snake.getDiry(), snake.getAngle(), snake.getRotate(), snake.getBonus());
	}
	
	public Snake(int id, double posx, double posy, double dirx, double diry, double angle, double rotate, Bonus bonus)
	{
		Objects.requireNonNull(id);
		Objects.requireNonNull(posx);
		Objects.requireNonNull(posy);
		Objects.requireNonNull(dirx);
		Objects.requireNonNull(diry);
		Objects.requireNonNull(angle);
		Objects.requireNonNull(rotate);
		Objects.requireNonNull(bonus);
		if (id < 1 || posx < 0 || posy < 0)
			throw new IllegalArgumentException("Mauvais arguments.");
		this.id = id;
		this.posx = posx;
		this.posy = posy;
		this.rotate = rotate;
		this.dirx = dirx;
		this.diry = diry;
		this.angle = angle;
		this.bonus = bonus;
		head = new ArrayList<Case>();
	}
	
	public Bonus getBonus()
	{
		return bonus;
	}
	
	public double getAngle()
	{
		return angle;
	}
	
	public double getRotate()
	{
		return rotate;
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
		posx = posx + dirx * bonus.getSpeed();
		posy = posy + diry * bonus.getSpeed();
	}
	
	public int getId()
	{
		return id;
	}
	
	public void move(int direction)
	{
		dirx = Math.cos(angle + rotate * direction);
		diry = Math.sin(angle + rotate * direction);
		angle = angle + rotate * direction;
	}
	
	public boolean checkCrash(Map map, Window w, int nb_player)
	{
		/*System.out.println("Check : " + this);*/
		if (outOfBound(w) == true)
			return true;
		System.out.println(id);
		if (map.getCase((int)posx, (int)posy) <= nb_player && map.getCase((int)posx, (int)posy) != 0)	
			return true;
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
				if (map.getCase((int)posx + i, (int)posy + id) != 0 && map.getCase((int)posx + i, (int)posy + id) != 0)
					return map.getCase((int)posx + i, (int)posy + id);
				if (map.getCase((int)posx - i, (int)posy - id) != 0 && map.getCase((int)posx - i, (int)posy - id) != 0)
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
	
	/**
	 * pour interface seulement
	 */
	public void moveUporDown(int direction)
	{
		return ;
	}
	
	public void addHead(Map map)
	{
		Case c = new Case((int)posx, (int)posy);
		head.add(c);
		if (head.size() == 3)
		{
			map.setZone(head.get(0), bonus.getSizeX(), bonus.getSizeY(), id);
			head.remove(0);
		}
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
