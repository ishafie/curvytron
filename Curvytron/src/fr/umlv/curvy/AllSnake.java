package fr.umlv.curvy;

public interface AllSnake
{
	/*
	 * TODO : Implementer les differents snake ici puis les mettre dans les linked list
	 * Le but etant de pouvoir ajouter n'importe quel type de snake et en creer plusieurs genre
	 * pour plusieurs style de gameplay differents.
	 * */
	public double getPosx();
	public double getPosy();
	public double getDirx();
	public double getDiry();
	public double getRotate();
	public Bonus getBonus();
	public double getAngle();
	public int getId();
	public void moveForward();
	public void move(int direction);
	public void moveUporDown(int direction);
	public boolean checkCrash(Map map, Window w, int nb_player);
	public boolean outOfBound(Window w);
	public int checkBonus(Map map);
	public void addHead(Map map);
}
