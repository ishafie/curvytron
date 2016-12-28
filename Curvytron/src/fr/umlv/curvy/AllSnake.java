package fr.umlv.curvy;

import java.awt.Color;

public interface AllSnake
{
	/*
	 * TODO : Implementer les differents snake ici puis les mettre dans les linked list
	 * Le but etant de pouvoir ajouter n'importe quel type de snake et en creer plusieurs genre
	 * pour plusieurs style de gameplay differents.
	 * */
	public Color getColor();
	public int getSizex();
	public int getSizey();
	public double getPosx();
	public double getPosy();
	public double getDirx();
	public double getDiry();
	public void moveForward();
	public void move(int direction);
	public void moveUporDown(int direction);
	public boolean checkCrash(Map map, Window w);
	public boolean outOfBound(Window w);
	public double getRotate();
}
