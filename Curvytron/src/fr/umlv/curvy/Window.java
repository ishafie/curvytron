package fr.umlv.curvy;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.ScreenInfo;

public class Window {
	
	ApplicationContext context;
	ScreenInfo screenInfo;
	
	public Window(ApplicationContext context)
	{
		Objects.requireNonNull(context);
		this.context = context;
		screenInfo = context.getScreenInfo();
	}
	
	public void setWindow(ApplicationContext context)
	{
	      // get the size of the screen
	      float width = screenInfo.getWidth();
	      float height = screenInfo.getHeight();
	      System.out.println("size of the screen (" + width + " x " + height + ")");
	      context.renderFrame(graphics -> {
	        graphics.setColor(Color.BLACK);
	        graphics.fill(new  Rectangle2D.Float(0, 0, width, height));
	      });
	}
	
	public double getWidth()
	{
		return screenInfo.getWidth();
	}
	
	public double getHeight()
	{
		return screenInfo.getHeight();
	}
}

