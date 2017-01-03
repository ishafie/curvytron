package fr.umlv.curvy;

import java.util.Objects;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.KeyboardKey;

public class Menu {

	private ApplicationContext context;
	private boolean multiplayer;
	private Window window;
	
	public Menu(ApplicationContext context, Window window)
	{
		Objects.requireNonNull(context);
		Objects.requireNonNull(window);
		this.context = context;	
		multiplayer = false;
		this.window = window;
	}
	
	public boolean getMultiplayer()
	{
		return multiplayer;
	}
	
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
