package fr.umlv.curvy;
import java.awt.Color;

import fr.umlv.zen5.*;

public class Main
{
	
	public static void main(String[] args)
	{
		double ROTATION = 0.1;
		long start_timestamp = System.currentTimeMillis();
		boolean multijoueur = false;
		Application.run(Color.BLACK, context ->
		{
			int ret = 0;
			Draw drawer = new Draw();
			Window window = new Window(context);
			Map map = new Map((int)window.getWidth(), (int)window.getHeight(), window);
			AllSnake playerOne = new Snake(10, 10, 1, 0, 0, ROTATION, Color.GREEN);
			AllSnake playerTwo = new Snake((int)window.getWidth() - 10, (int)window.getHeight() - 10, -1, 0, -3, ROTATION, Color.CYAN);
			EventManager eventManager = new EventManager(context);
			BonusGenerator bg = new BonusGenerator(map);
			window.setWindow(context);
			/*playerOne = Bonus.changeSnake(playerOne);
			playerTwo = Bonus.changeSnake(playerTwo);*/
		    while (true)
		    {
		    	
		    	System.out.println("Tour de boucle entier = " + (System.currentTimeMillis() - start_timestamp));
		    	map.setCase((int)playerOne.getPosx(), (int)playerOne.getPosy(), 1);
		    	if (multijoueur == true)
		    		map.setCase((int)playerTwo.getPosx(), (int)playerTwo.getPosy(), 2);
		    	if ((System.currentTimeMillis() - start_timestamp) % 10000 < 50)
		    		bg.genBonus(context, drawer);
		    	if ((ret = eventManager.manageEvent(playerOne, playerTwo, multijoueur)) == 0)
					break ;
		    	drawer.draw(context, playerOne);
		    	if (multijoueur == true)
		    		drawer.draw(context, playerTwo);
		    	if (playerOne.checkCrash(map, window) == true)
		    	{
		    		System.out.println("CRASH, PLAYER ONE DEFEATED, PLAYER TWO WINS");
		    		break ;
		    	}
		    	if (multijoueur == true && playerTwo.checkCrash(map, window) == true)
		    	{
		    		System.out.println("CRASH, PLAYER TWO DEFEATED, PLAYER ONE WINS");
		    		break ;
		    	}
		    	ret = playerOne.checkBonus(map);
		    	if (ret == 4)
		    		playerOne = Bonus.changeSnake(playerOne);
		    	if (ret != 0 && ret != 1 && ret != 2)
		    		Bonus.activeAndDelete(context, drawer, map, ret, playerOne);
		    	if (multijoueur == true)
		    		ret = playerTwo.checkBonus(map);
		    	if (multijoueur == true && ret != 0 && ret != 1 && ret != 2)
		    		Bonus.activeAndDelete(context, drawer, map, ret, playerTwo);
		    }
		    System.out.println("Surface occupee = " + map.calcSurface(1) + "%");
		});
		
		System.out.println("LA FIN");
		System.exit(1);
}}
