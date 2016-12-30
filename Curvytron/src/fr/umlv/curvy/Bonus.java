package fr.umlv.curvy;

import fr.umlv.zen5.ApplicationContext;

public class Bonus {

	static public void activeAndDelete(ApplicationContext context, Draw drawer, Map map, int ret, AllSnake snake)
	{
		Bonus.activeSimpleBonus(snake, ret);
    	Bonus.deleteBonus(context, drawer, map, ret, (int)snake.getPosx(), (int)snake.getPosy());
	}
	static public void activeSimpleBonus(AllSnake snake, int bonus)
	{
		if (bonus == 3)
			snake.increaseSpeed(1.2);
	}
	
	static public AllSnake changeSnake(AllSnake snake)
	{
		double angle = 0;
		
		if (snake instanceof ClassicSnake)
		{
			if (snake.getDirx() == 1)
				angle = 0;
			else if (snake.getDirx() == -1)
				angle = -3;
			snake = new Snake(snake.getPosx(), snake.getPosy(), snake.getDirx(), snake.getDiry(), angle, snake.getRotate());
		}
		else
			snake = new ClassicSnake(snake.getPosx(), snake.getPosy(), snake.getDirx(), snake.getDiry(), snake.getAngle(), snake.getRotate());
		snake.moveForward();
		return snake;
	}
	
	static public void deleteBonus(ApplicationContext context, Draw drawer, Map map, int bonus, int x, int y)
	{
		Case c = map.getTopLeftCase(x, y, bonus);
		
		map.setZone(c.getX(), c.getY(), 50, 50, 0);
		drawer.hideIcon(context, c.getX(), c.getY(), 50, 50);
	}
}
