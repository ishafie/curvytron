package fr.umlv.curvy;

import java.util.Objects;

public class Case {
	int x;
	int y;
	/**
	 * Constructeur de la classe Case. 
	 * @param x coordonnee en x de la Case.
	 * @param y coordonnee en y de la Case.
	 */
	public Case (int x, int y)
	{
		Objects.requireNonNull(x);
		Objects.requireNonNull(y);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Renvoie la coordonnee x de la Case.
	 * @return x, la coordonnee de la Case.
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * Renvoie la coordonnee y de la Case
	 * @return y, la coordonnee de la Case.
	 */
	public int getY()
	{
		return y;
	}
	
	@Override
	public String toString()
	{
		return ("(" + x + ", " + y + ")");
	}
}
