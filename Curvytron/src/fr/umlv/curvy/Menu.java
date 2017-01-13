package fr.umlv.curvy;

import java.util.Objects;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.KeyboardKey;

public class Menu {

	private ApplicationContext context;
	private boolean multiplayer;
	private Window window;
	
	/**
	 * Constructeur de la classe Menu. A l'initialisation, le multiplayer est defini false.
	 * @param context context de l'application.
	 * @param window la fenetre de l'application.
	 */
	public Menu(ApplicationContext context, Window window)
	{
		Objects.requireNonNull(context);
		Objects.requireNonNull(window);
		this.context = context;	
		multiplayer = false;
		this.window = window;
	}
	
	/**
	 * Retourne l'etat du mode multijoueur
	 * @return true si le mutlijoueur est actif, false sinon.
	 */
	public boolean getMultiplayer()
	{
		return multiplayer;
	}
	
	/**
	 * Cree le menu, l'interface et affiche les differents elements de la fenetre au demarage.
	 */
	public void createMenu()
	{
		Draw.drawBackground(context, (int)window.getWidth(), (int)window.getHeight());
		Draw.drawMenuText(context, (int)window.getWidth(), (int)window.getHeight());
		Event event = context.pollOrWaitEvent(100000);
		
		if (event.getKey() == KeyboardKey.Y)
			multiplayer = true;
		Draw.drawBackground(context, (int)window.getWidth(), (int)window.getHeight() );
		
	}
}
