package fr.umlv.curvy;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import fr.umlv.zen5.ApplicationContext;

public class BonusGenerator {
	private Map map;
	private final int NB_BONUS;
	
	/**
	 * Constructeur de la classe BonusGenerator
	 * @param map la map
	 */
	public BonusGenerator(Map map)
	{
		Objects.requireNonNull(map);
		this.map = map;
		NB_BONUS = 4;
	}
	/**
	 * Generateur de bonus aleatoire
	 * 
	 * @param context, le contexte 
	 * @param nb_player le nombre de joueurs
	 */
	public void genBonus(ApplicationContext context, int nb_player)
	{
		int randomBonus = ThreadLocalRandom.current().nextInt(nb_player + 1, NB_BONUS + nb_player + 1);
		/*Case c = new Case(ThreadLocalRandom.current().nextInt(1, map.getCol() - 50), ThreadLocalRandom.current().nextInt(1, map.getLig() - 50));*/
		Case c = caseBonus();
		
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
	/**
	 * Activation d'un bonus aleatoire, cherche la position aleatoire pour placer le bonus
	 * @return case, la case où le bonus peut être place.
	 */
	private Case caseBonus(){
		
		int x = ThreadLocalRandom.current().nextInt((int)map.getWindow().getborderRight(), map.getCol() -50);
		int y = ThreadLocalRandom.current().nextInt((int)map.getWindow().getborderTop(), map.getLig() -50);
		
		while (caseChecker(x,y) != 1){
			x = ThreadLocalRandom.current().nextInt((int)map.getWindow().getborderRight(), map.getCol() -50);
			y = ThreadLocalRandom.current().nextInt((int)map.getWindow().getborderTop(), map.getLig() -50);
		}
			
		Case c = new Case (x,y);
		return c;
	}
	
	/**
	 * Verifie si le bonus peut être place a partir des coordonnes x et y donnees
	 * @param x la coordonnee x du point du bonus en haut a gauche
	 * @param y la coordonnee y du point du bonus en haut a gauche
	 * @return 1 si le bonus peut être place, 0 sinon.
	 */
	private int caseChecker(int x, int y){
		for (int i = x; i < x + 50; i++)
		{
			for (int j = y; j < y + 50; j++)
			{
				if (map.getCase(i, j) != 0)
					return 0;
			}
		}
		return 1;
		
		
	}
}
