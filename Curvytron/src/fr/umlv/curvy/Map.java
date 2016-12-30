package fr.umlv.curvy;

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
	
	public Case getRandomAvailableCase(int maxLig, int maxCol, int rand)
	{
		int i = rand;
		int id = 0;
		int count = 0;
		
		
		while (count < rand)
		{
			id = 0;
			while (id < maxCol)
			{
				if (getCase(i, id) == 0)
					count++;
				if (count >= rand)
					return new Case(i, id);
				id++;
			}
			i++;
			if (i >= maxLig)
				i = 0;
		}
		return new Case(0, 0);
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
		ret = (ret / (lig * col)) * 100;
		return ret ;
	}
}

