package fr.umlv.curvy;
import java.util.concurrent.ThreadLocalRandom;

import fr.umlv.zen5.ApplicationContext;

public class BonusGenerator {
	private Map map;
	private final int NB_BONUS;
	
	public BonusGenerator(Map map)
	{
		this.map = map;
		NB_BONUS = 2;
	}
	
	
	public void genBonus(ApplicationContext context, Draw drawer)
	{
		Case c;
		int randomBonus = ThreadLocalRandom.current().nextInt(3, NB_BONUS + 3);
		System.out.println("Bonus genere = " + randomBonus);
		
		c = map.getRandomAvailableCase(map.getCol(), map.getLig(), ThreadLocalRandom.current().nextInt(1, map.getLig()));
		if (randomBonus == 3)
			drawer.drawSpeedModeIcon(context, c.getX(), c.getY());
		else if (randomBonus == 4)
			drawer.drawClassicModeIcon(context, c.getX(), c.getY());
		map.setZone(c.getX(), c.getY(), 50, 50, randomBonus);
	}
}
