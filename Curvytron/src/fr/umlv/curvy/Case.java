package fr.umlv.curvy;

import java.util.Objects;

public class Case {
	int x;
	int y;
	
	public Case (int x, int y)
	{
		Objects.requireNonNull(x);
		Objects.requireNonNull(y);
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
