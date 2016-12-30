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
		int randomBonus = ThreadLocalRandom.current().nextInt(2, NB_BONUS + 2);
		System.out.println("Bonus généré = " + randomBonus);
		
		c = map.getRandomAvailableCase(map.getCol(), map.getLig(), ThreadLocalRandom.current().nextInt(1, map.getLig()));
		System.out.println("Case -> " + c);
		randomBonus = 3; //jusqu'a ajout du bonus classic mode
		if (randomBonus == 3)
			drawer.drawSpeedModeIcon(context, c.getX(), c.getY());
		map.setZone(c.getX(), c.getY(), 50, 50, randomBonus);
	}
}
