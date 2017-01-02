package fr.umlv.curvy;

import java.util.Objects;

public class Map
{
	private int tab[][];
	private Window window;
	private int col;
	private int lig;
	
	/**
	 * 
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
	
	public int getCol()
	{
		return col;
	}
	
	public int getLig()
	{
		return lig;
	}
	
	public int getCase(int x, int y)
	{
		if (x >= window.getWidth() || y >= window.getHeight() || x <= 0 || y <= 0)
			return 0;
		return (tab[x][y]);
	}
	
	public void setCase(int x, int y, int val)
	{
		if (x >= window.getWidth() || y >= window.getHeight() || x <= 0 || y <= 0)
			return ;
		/*System.out.println("(" + x + ", " + y + ")");*/
		tab[x][y] = val;
	}
	
	
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

}

