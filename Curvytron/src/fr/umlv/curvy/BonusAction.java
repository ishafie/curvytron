package fr.umlv.curvy;

import fr.umlv.zen5.ApplicationContext;

public class BonusAction {
	
	static public void activeAndDelete(ApplicationContext context, Map map, int ret, AllSnake snake, int nb_player)
	{
		BonusAction.activeSimpleBonus(snake, ret, nb_player);
    	deleteBonus(context, map, ret, (int)snake.getPosx(), (int)snake.getPosy());
	}
	
	static public void activeSimpleBonus(AllSnake snake, int bonus, int nb_player)
	{
		if (bonus == nb_player + 1)
			snake.getBonus().increaseSpeed(1.2);
		if (bonus == nb_player + 3)
			snake.getBonus().increaseSize(1.2);
		if (bonus == nb_player + 4)
			snake.getBonus().changeShape();
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
			snake = new Snake(snake.getId(), snake.getPosx(), snake.getPosy(), snake.getDirx(), snake.getDiry(), angle, snake.getRotate(), snake.getBonus());
		}
		else
			snake = new ClassicSnake(snake.getId(), snake.getPosx(), snake.getPosy(), snake.getDirx(), snake.getDiry(), snake.getAngle(), snake.getRotate(), snake.getBonus());
		snake.moveForward();
		return snake;
	}
	
	static public void deleteBonus(ApplicationContext context, Map map, int bonus, int x, int y)
	{
		Case c = map.getTopLeftCase(x, y, bonus);
		
		map.setZone(c.getX(), c.getY(), 50, 50, 0);
		Draw.hideIcon(context, c.getX(), c.getY(), 50, 50);
	}
}
