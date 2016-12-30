package fr.umlv.curvy;

public class Case {
	int x;
	int y;
	
	public Case (int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
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
