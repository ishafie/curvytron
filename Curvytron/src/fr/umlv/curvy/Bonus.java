package fr.umlv.curvy;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

public class Bonus {

	private double speed;
	private int sizex;
	private int sizey;
	private Color color;
	private Shape shape;
	
	/**
	 * Constructeur de la classe Bonus.
	 * @param color couleur du bonus.
	 * @param shape Shape du bonus.
	 */
	public Bonus(Color color, Shape shape)
	{
		Objects.requireNonNull(color);
		this.color = color;
		speed = 5;
		sizex = 10;
		sizey = 10;
		this.shape = shape;
	}
	/**
	 * Renvoie la couleur du bonus.
	 * @return color, la couleur du bonus.
	 */
	public Color getColor()
	{
		return color;
	}
	/**
	 * Renvoie la taille en x du bonus.
	 * @return sizex, la taille en x du bonus.
	 */
	public int getSizeX()
	{
		return sizex;
	}
	
	/**
	 * Renvoie la taille en y du bonus.
	 * @return sizey, la taille en y du bonus.
	 */
	public int getSizeY()
	{
		return sizey;
	}
	
	/**
	 * Retourne la vitesse (speed) du bonus. Le speed permet le changement de vitesse
	 * @return speed, la vitesse.
	 */
	public double getSpeed()
	{
		return speed;
	}
	
	/**
	 * Change le shape (c-a-d la forme) du trace du snake.
	 * Peut avoir deux formes : Rectangle ou Ellipse. 
	 * L'appelle de cette fonction passe de l'une a l'autre.
	 */
	public void changeShape()
	{
		if (shape instanceof Rectangle2D.Float)
			shape = new Ellipse2D.Float();
		else if (shape instanceof Ellipse2D.Float)
			shape = new Rectangle2D.Float();
	}
	
	/**
	 * Renvoie le nouveau shape suivant le shape initialement prevu :
	 * Renvoie un Rectangle ou une ellipse.
	 * @param x coordonnees en x.
	 * @param y coordonnee en y.
	 * @param w width, largeur du shape.
	 * @param h height, hauteur du shape.
	 * @return Ellipse2D ou Rectangle2D suivant le shape.
	 */
	public Shape createShape(int x, int y, int w, int h)
	{
		if (shape instanceof Rectangle2D.Float)
			return new Rectangle2D.Float(x, y, w, h);
		else if (shape instanceof Ellipse2D.Float)
			return new Ellipse2D.Float(x, y, w, h);
		return new Rectangle2D.Float(x, y, w, h);
	}
	
	/**
	 * Augmente la valeur de la size du snake, en diminuant legerement sa vitesse
	 * pour compenser la taille augmentee.
	 * @param increasing valeur de l'incrementation.
	 */
	public void increaseSize(double increasing)
	{
		double oldspeed = speed - sizex/2;
		
		System.out.println("oldspeed = " + oldspeed);
		sizex *= increasing;
		sizey *= increasing;
		if (speed < sizex/2)
			speed = oldspeed + sizex/2;
	}
	
	/**
	 * Augmente la vitesse du snake.
	 * @param increasing coefficiant multiplicateur de la vitesse actuelle
	 */
	public void increaseSpeed(double increasing)
	{
		speed *= increasing;
	}
	
}
