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
	
	/**
	 * Constructeur de la classe snake.
	 * @param snake le snake du joueur.
	 * @see Snake#Snake(int id, double posx, double posy, double dirx, double diry, double angle, double rotate, Bonus bonus)
	 */
	public Snake(AllSnake snake)
	{
		this(snake.getId(), snake.getPosx(), snake.getPosy(), snake.getDirx(), snake.getDiry(), snake.getAngle(), snake.getRotate(), snake.getBonus());
	}
	
	/**
	 * Constructeur de la classe snake.
	 * Initialise aussi la tête du snake dans une arrayList.
	 * @param id id du joueur.
	 * @param posx position initiale en x du snake.
	 * @param posy position initiale en y du snake.
	 * @param dirx direction initiale en x du snake.
	 * @param diry direction initiale en y du snake.
	 * @param angle angle de la direction du snake (en rad)
	 * @param rotate rotation de l'angle.
	 * @param bonus bonus du snake.
	 * 
	 */
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
	
	/**
	 * Retourne le bonus
	 * @return bonus, le bonus
	 */
	public Bonus getBonus()
	{
		return bonus;
	}
	
	/**
	 * Retourne la valeur de l'angle.
	 * @return angle, la valeur de l'angle.
	 */
	public double getAngle()
	{
		return angle;
	}
	
	/**
	 * Retourne la rotation.
	 * @return rotate, la rotation.
	 */
	public double getRotate()
	{
		return rotate;
	}
	
	/**
	 * Retourne la coordonee x de la position.
	 * @return posx, la coordonnee x de la position.
	 */
	public double getPosx()
	{
		return posx;
	}
	
	/**
	 * Retourne la coordonnee y de la position.
	 * @return posy, la coordonnee y de la position.
	 */
	public double getPosy()
	{
		return posy;
	}
	
	/**
	 * Retourne la coordonnee x de la direction.
	 * @return dirx, la coordonnee x de la direction.
	 */
	public double getDirx()
	{
		return dirx;
	}
	/**
	 * Retourne la coordonnee y de la direction
	 * @return diry, la coordonnee y de la direction.
	 */
	public double getDiry()
	{
		return diry;
	}
	
	/**
	 * Retourne l'id du snake 
	 * @return id, l'id du snake
	 */
	public int getId()
	{
		return id;
	}
	
	/**
	 * Deplace le serpent suivant les valeurs de direction qui lui
	 * sont propre.
	 */
	public void moveForward()
	{
		posx = posx + dirx * bonus.getSpeed();
		posy = posy + diry * bonus.getSpeed();
	}
	
	/**
	 * Deplace le serpent dans la direction donnee en parametre
	 * @param direction la direction dans laquelle le serpent doit aller.
	 */
	public void move(int direction)
	{
		dirx = Math.cos(angle + rotate * direction);
		diry = Math.sin(angle + rotate * direction);
		angle = angle + rotate * direction;
	}
	
	/**
	 * Verifie si un serpent est entre en collision avec un bord ou  un autre serpent.
	 * @param map la map.
	 * @param w la Window. 
	 * @param nb_player le nombre de joueurs.
	 * @return boolean true si le serpent est entre en collision, false sinon.
	 */
	public boolean checkCrash(Map map, Window w, int nb_player)
	{
		if (outOfBound(w) == true)
			return true;
		System.out.println(id);
		if (map.getCase((int)posx, (int)posy) <= nb_player && map.getCase((int)posx, (int)posy) != 0)	
			return true;
		return false;
	}

	/**
	 * Retourne un bonus si le snake passe dessus.
	 * @param map la map du jeu.
	 * @return le bonus, ou 0 si aucun bonus.
	 */
	public int checkBonus(Map map)
	{
		int i = 0;
		int id = 0;
		
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
	
	/**
	 * Verifie si la position du snake est encore dans la zone de jeu, ou si il 
	 * en est sorti.
	 * @param w fenetre d'affichage
	 * @return true si il est en dehors, false sinon.
	 */
	public boolean outOfBound(Window w)
	{
		if (posx >= (w.getWidth() - w.getWidth() * 0.021)
			|| posy >= (w.getHeight() - (0.25 * w.getHeight()))
			|| posx < w.getWidth() * 0.0101
			|| posy < 0.055 * w.getHeight())
			return true;
		return false;
	}
	
	/**
	 *  pour interface seulement
	 */
	public void moveUporDown(int direction)
	{
		return ;
	}
	
	/**
	 * Permet de d�finir la 3e case � partir de la tete du serpent comme �tant occup�e.
	 * Ajoute une case a head (ArrayList de 3 cases), si la liste fait 3 cases, on envoie la premiere et on la supprime
	 * de sorte � garder maximum 3 cases.
	 * @param map, le plateau de jeu 
	 */
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
