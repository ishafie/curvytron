package fr.umlv.curvy;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import fr.umlv.zen5.ApplicationContext;

public class BonusGenerator {
	private Map map;
	private final int NB_BONUS;
	
	public BonusGenerator(Map map)
	{
		Objects.requireNonNull(map);
		this.map = map;
		NB_BONUS = 4;
	}
	
	
	public void genBonus(ApplicationContext context, int nb_player)
	{
		int randomBonus = ThreadLocalRandom.current().nextInt(nb_player + 1, NB_BONUS + nb_player + 1);
		Case c = new Case(ThreadLocalRandom.current().nextInt(1, map.getCol() - 50), ThreadLocalRandom.current().nextInt(1, map.getLig() - 50));
		if (randomBonus == nb_player + 1)
			Draw.drawIcon(context, c.getX(), c.getY(), "/sonic.png");
		else if (randomBonus == nb_player + 2)
			Draw.drawIcon(context, c.getX(), c.getY(), "/snake.png");
		else if (randomBonus == nb_player + 3)
			Draw.drawIcon(context, c.getX(), c.getY(), "/size.png");
		else if(randomBonus == nb_player + 4)
			Draw.drawIcon(context, c.getX(), c.getY(), "/shape.png");
		map.setZone(c.getX(), c.getY(), 50, 50, randomBonus);
	}
}
