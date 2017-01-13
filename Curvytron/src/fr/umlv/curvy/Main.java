package fr.umlv.curvy;
import java.awt.Color;
import java.awt.geom.Ellipse2D;


import fr.umlv.zen5.*;

public class Main
{
	
	public static void playGameMulti(ApplicationContext context, Window window, long startTimestamp)
	{
		double borderRight = window.getWidth() * 0.0151;
		double borderBottom = 0.224 * window.getHeight();
		double borderLeft = window.getWidth() * 0.0131;
		double borderTop = 0.055 * window.getHeight();
		double ROTATION = 0.1;
		int ret = 0;
		int nb_player = 2;
		long endTimestamp = 120000;
		
		Map map = new Map((int)window.getWidth(), (int)window.getHeight(), window);
		AllSnake playerOne = new Snake(1, borderLeft + 10, borderTop + 10, 1, 0, 0, ROTATION, new Bonus(Color.BLACK, new Ellipse2D.Float()));
		/*AllSnake playerTwo = new Snake(2, (int)window.getWidth() - 10, (int)window.getHeight() - 10, -1, 0, -3, ROTATION, new Bonus(Color.CYAN, new Rectangle2D.Float()));*/
		AllSnake playerTwo = new Snake(2, window.getWidth() - borderRight - 50, window.getHeight() - borderBottom - 50, -1, 0, -3, ROTATION, new Bonus(Color.CYAN, new Ellipse2D.Float()));
		EventManager eventManager = new EventManager(context);
		BonusGenerator bg = new BonusGenerator(map);
	    while ((System.currentTimeMillis() - startTimestamp) < endTimestamp)
	    {
	    	System.out.println((System.currentTimeMillis() - startTimestamp));
	    	if ((System.currentTimeMillis() - startTimestamp) % 5000 < 80)
	    		Draw.drawTime(context, (int)window.getWidth(), (int)window.getHeight(),(System.currentTimeMillis() - startTimestamp));
	    	playerOne.addHead(map);
    		playerTwo.addHead(map);
	    	if ((System.currentTimeMillis() - startTimestamp) % 10000 < 80)
	    		bg.genBonus(context, nb_player);
	    	if (eventManager.manageEvent(playerOne, playerOne.getId()) == 0)
	    		break ;
	    	if (eventManager.manageEvent(playerTwo, playerTwo.getId()) == 0)
	    		break ;
	    	Draw.draw(context, playerOne);
	    	Draw.draw(context, playerTwo);
	    	if (playerOne.checkCrash(map, window, nb_player) == true)
	    	{
	    		System.out.println("CRASH, PLAYER ONE DEFEATED, PLAYER TWO WINS");
	    		break ;
	    	}
	    	if (playerTwo.checkCrash(map, window, nb_player) == true)
	    	{
	    		System.out.println("CRASH, PLAYER TWO DEFEATED, PLAYER ONE WINS");
	    		break ;
	    	}
	    	ret = playerOne.checkBonus(map);
	    	if (ret == nb_player + 2)
	    		playerOne = BonusAction.changeSnake(playerOne);
	    	if (ret > nb_player)
	    		BonusAction.activeAndDelete(context, map, ret, playerOne, nb_player);
	    	ret = playerTwo.checkBonus(map);
	    	if (ret > nb_player)
	    		BonusAction.activeAndDelete(context, map, ret, playerTwo, nb_player);
	    }
	    if (map.calcSurface(playerOne.getId()) > map.calcSurface(playerTwo.getId()))
	    	System.out.println("Le joueur un a gagne, surface occupee = " + map.calcSurface(playerOne.getId()) + "%");
	    else
	    	System.out.println("Le joueur deux a gagne, surface occupee = " + map.calcSurface(playerTwo.getId()) + "%");
	}
	
	public static void playGameSolo(ApplicationContext context, Window window, long start_timestamp)
	{
		double borderRight = window.getWidth() * 0.0151;
		double borderBottom = 0.224 * window.getHeight();
		double borderLeft = window.getWidth() * 0.0131;
		double borderTop = 0.055 * window.getHeight();
		double ROTATION = 0.1;
		int ret = 0;
		int nb_player = 2;
		
		Map map = new Map((int)(window.getWidth() - borderRight), (int)(window.getHeight() - borderBottom), window);
		AllSnake playerOne = new Snake(1, borderLeft + 10, borderTop + 10, 1, 0, 0, ROTATION, new Bonus(Color.BLACK, new Ellipse2D.Float()));
		EventManager eventManager = new EventManager(context);
		BonusGenerator bg = new BonusGenerator(map);
	    while (true)
	    {
	    	playerOne.addHead(map);
	    	if ((System.currentTimeMillis() - start_timestamp) % 10000 < 40)
	    		bg.genBonus(context, nb_player);
	    	if (eventManager.manageEvent(playerOne, playerOne.getId()) == 0)
	    		break ;
	    	Draw.draw(context, playerOne);
	    	if (playerOne.checkCrash(map, window, nb_player) == true)
	    	{
	    		System.out.println("CRASH, PLAYER ONE DEFEATED, PLAYER TWO WINS");
	    		break ;
	    	}
	    	ret = playerOne.checkBonus(map);
	    	if (ret == nb_player + 2)
	    		playerOne = BonusAction.changeSnake(playerOne);
	    	if (ret > nb_player)
	    		BonusAction.activeAndDelete(context, map, ret, playerOne, nb_player);
	    }
	    System.out.println("Surface occupee = " + map.calcSurface(playerOne.getId()) + "%");
	}
	
	public static void main(String[] args)
	{
		long start_timestamp = System.currentTimeMillis();
		
		Application.run(Color.BLACK, context ->
		{
			Window window = new Window(context);
			Menu menu = new Menu(context, window);
			window.setWindow(context);
			menu.createMenu();
			if (menu.getMultiplayer() == true)
				Main.playGameMulti(context, window, start_timestamp);
			else
				Main.playGameSolo(context, window, start_timestamp);
		});	
		System.out.println("LA FIN");
		System.exit(1);
	}	
}
