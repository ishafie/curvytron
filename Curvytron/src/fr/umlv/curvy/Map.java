package fr.umlv.curvy;

public class Map
{
	private boolean tab[][];
	private Window window;
	
	/**
	 * 
	 * @param col nombre de colonnes
	 * @param lig nombre de lignes
	 * @param window la fenetre pour avoir ses dimensions
	 */
	public Map(int col, int lig, Window window)
	{
		tab = new boolean[col][lig];
		this.window = window;
	}
	
	public boolean getCase(int x, int y)
	{
		if (x >= window.getWidth() || y >= window.getHeight() || x <= 0 || y <= 0)
			return false;
		return (tab[x][y]);
	}
	
	public void setCase(int x, int y)
	{
		if (x >= window.getWidth() || y >= window.getHeight() || x <= 0 || y <= 0)
			return ;
		System.out.println("(" + x + ", " + y + ")");
		tab[x][y] = true;
	}
}

