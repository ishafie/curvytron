package fr.umlv.curvy;

import java.util.Objects;

public class Map
{
	private int tab[][];
	private Window window;
	private int col;
	private int lig;
	
	/**
	 * Constructeur de la classe Map, qui est un plateau (un tableau a deux dimensions)
	 * de la taille de la fenetre, et qui represente les cases occupees par le snake ou 
	 * les bonus.
	 * @param col nombre de colonnes
	 * @param lig nombre de lignes
	 * @param window la fenetre pour avoir ses dimensions
	 */
	public Map(int col, int lig, Window window)
	{
		if (col < 0 || lig < 0)
			throw new IllegalArgumentException("Mauvais arguments");
		Objects.requireNonNull(col);
		Objects.requireNonNull(lig);
		Objects.requireNonNull(window);
		tab = new int[col][lig];
		this.window = window;
		this.col = col;
		this.lig = lig;
	}
	
	/**
	 * Retourne la colonne de la map.
	 * @return col, la colonne de la map.
	 */
	public int getCol()
	{
		return col;
	}
	
	/**
	 * Retourne la ligne de la map.
	 * @return lig, la ligne de la map.
	 */
	public int getLig()
	{
		return lig;
	}
	
	/**
	 * Retourne l'etat de la case de coordonnee (x,y) de la map.
	 * @param x la coordonnee x de la case.
	 * @param y la coordonnee y de la case.
	 * @return la valeur de la case de la map.
	 */
	public int getCase(int x, int y)
	{
		if (x >= window.getWidth() || y >= window.getHeight() || x <= 0 || y <= 0)
			return 0;
		return (tab[x][y]);
	}
	
	/**
	 * Affecte la valeur val de la case de coordonnee (x,y) dans la map. 
	 * @param x la coordonnee x de la case.
	 * @param y la coordonnee y de la case.
	 * @param val, la valeur a ajouter.
	 */
	public void setCase(int x, int y, int val)
	{
		if (x >= window.getWidth() || y >= window.getHeight() || x <= 0 || y <= 0)
			return ;
		/*System.out.println("(" + x + ", " + y + ")");*/
		
		tab[x][y] = val;
	}
	
	/**
	 * Recupère la case qui se trouve au coin superieur gauche du bonus.
	 * @param x une coordonnee x dans le bonus.
	 * @param y une coordonnee y dans le bonus.
	 * @param bonus le bonus.
	 * @return la case du coin superieur gauche
	 */
	public Case getTopLeftCase(int x, int y, int bonus)
	{
		int i = x;
		int id = y;
		
		while (tab[i][id] == bonus)
			i--;
		i++;
		while (tab[i][id] == bonus)
			id--;
		id++;
		return new Case(i, id);
	}
	
	/**
	 * Affecte a une zone de valeurs la valeur val dans chaque case.
	 * @param x la coordonnee en x du coin superieur gauche.
	 * @param y la coordonnee en y du coin superieur gauche.
	 * @param maxCol la taille en x.
	 * @param maxLig la taille en y.
	 * @param val la valeur a inserer dans chaque case.
	 */
	public void setZone(int x, int y, int maxCol, int maxLig, int val)
	{
		int i = 0;
		int id = 0;
		
		while (i < maxLig)
		{
			while (id < maxCol)
			{
				setCase(x + i, y + id, val);
				id++;
			}
			id = 0;
			i++;
		}
	}
	
	/**
	 * Affecte a une zone de valeurs la valeur val dans chaque case.
	 * @param c la case du coin superieur gauche.
	 * @param maxCol la taille en x.
	 * @param maxLig la taille en y.
	 * @param val la valeur a inserer dans chaque case.
	 */
	public void setZone(Case c, int maxCol, int maxLig, int val)
	{
		int i = 0;
		int id = 0;
		
		while (i < maxLig)
		{
			while (id < maxCol)
			{
				setCase(c.getX() + i, c.getY() + id, val);
				id++;
			}
			id = 0;
			i++;
		}
	}
	
	/**
	 * Calcul de la surface d'une zone qui a pour valeur val.
	 * @param val la valeur qu'on cherche dans les cases de la zone.
	 * @return la surface de la zone.
	 */
	public double calcSurface(int val)
	{
		int i = 0;
		int id = 0;
		double ret = 0;
		
		while (i < col)
		{
			while (id < lig)
			{
				if (tab[i][id] == val)
					ret++;
				id++;
			}
			id = 0;
			i++;
		}
		if (lig * col == 0)
			throw new IllegalStateException("Division par 0");
		ret = (ret / (lig * col)) * 100;
		return ret ;
	}
	
	/**
	 * Renvoie l'etat de la fentre.
	 * @return window, la fenetre
	 */
	public Window getWindow()
	{
		return window;
	}
}

