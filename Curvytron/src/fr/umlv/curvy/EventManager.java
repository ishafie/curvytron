package fr.umlv.curvy;

import java.util.Objects;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.KeyboardKey;

public class EventManager
{
	private ApplicationContext context;
	private Event eventOne;
	
	/**
	 * Constructeur de la classe EventManager.
	 * @param context context de l'application.
	 */
	public EventManager(ApplicationContext context)
	{
		Objects.requireNonNull(context);
		this.context = context;
		eventOne = null;
	}
	
	/**
	 * Applique l'evenement a un snake, qui correspond ici au snake du joueur.
	 * @param player le snake du joueur.
	 * @param id id du joueur
	 * @return 1 en cas de reussite.
	 * @see EventManager#actionEvent(AllSnake player, int id)
	 */
	public int manageEvent(AllSnake player, int id)
	{
		int ret = 1;
		/*
		long startTime = System.currentTimeMillis();
		long currentTime = 0;
		*/
		eventOne = context.pollOrWaitEvent(25);
		/*currentTime = System.currentTimeMillis();
		if (currentTime - startTime < 40)
			waitTime(System.currentTimeMillis(), 40 - (currentTime - startTime));*/
		if (eventOne != null)
			ret = actionEvent(player, id);
		player.moveForward();
		return (ret);
	}
	
	/**
	 * Applique l'action ou l'evenement au joueur dont l'id est passe en paramtre.
	 * @param player le snake du joueur.
	 * @param id id du joueur.
	 * @return 1, en cas de reussite.
	 * @see EventManager#manageEvent(AllSnake player, int id)
	 */
	public int actionEvent(AllSnake player, int id)
	{
		int bonus = 1;
		if (id == 1)
			bonus = movesetPlayerOne(player);
		else if (id == 2)
			bonus = movesetPlayerTwo(player);
		if (id > 1)
		{
			flushEvent(context);
			eventOne = null;
		}
		return (bonus);
	}
	
	/**
	 * Deplacement du snake du player two. N'est utilise seulement dans le cas ou il y a 
	 * le mode multijoueur active.
	 * @param player le snake du joueur.
	 * @return 1, en cas de mouvement, 0 si la touche "space" est enfonce.
	 * @see EventManager#movesetPlayerOne(AllSnake player)
	 */
	public int movesetPlayerTwo(AllSnake player)
	{
		int LEFT = -1;
		int RIGHT = 1;
		int UP = -2;
		int DOWN = 2;
		Event.Action keypressed = Event.Action.KEY_PRESSED;
		Event.Action keyreleased = Event.Action.KEY_RELEASED;
		if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.Q)
			player.move(LEFT);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.D)
			player.move(RIGHT);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.SPACE)
			return (0);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.Z)
			player.moveUporDown(UP);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.S)
			player.moveUporDown(DOWN);
		return (1);
	}
	
	/**
	 * Deplacement du snake du joueur One. Suivant l'etat des touches de controle du snake, deplace le snake dans la direction
	 * dans laquelle il doit aller.
	 * @param player le snake du joueur.
	 * @return 1, en cas de mouvement, 0 si la touche "space" est enfonce.
	 */
	public int movesetPlayerOne(AllSnake player)
	{
		int LEFT = -1;
		int RIGHT = 1;
		int UP = -2;
		int DOWN = 2;
		Event.Action keypressed = Event.Action.KEY_PRESSED;
		Event.Action keyreleased = Event.Action.KEY_RELEASED;
		if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.LEFT)
			player.move(LEFT);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.RIGHT)
			player.move(RIGHT);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.SPACE)
			return (0);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.UP)
			player.moveUporDown(UP);
		else if ((eventOne.getAction() == keypressed || eventOne.getAction() == keyreleased) && eventOne.getKey() == KeyboardKey.DOWN)
			player.moveUporDown(DOWN);
		return (1);
	}

	/**
	 * Attends le temps d'une duree timestamp a partir du moment start.
	 * @param start debut du temps.
	 * @param timestamp durée
	 */
	public void waitTime(long start, long timestamp)
	{
		while (timestamp > 0 && System.currentTimeMillis() - start < timestamp)
		{
			;
		}
	}
	
	/**
	 * Envoie les evenements tant qu'ils sont presents.
	 * @param context context de l'application.
	 */
	public void flushEvent(ApplicationContext context)
	{
		while (context.pollEvent() != null)
			;
	}
	
}
