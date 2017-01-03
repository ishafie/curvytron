package fr.umlv.curvy;
import java.awt.Color;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

import fr.umlv.zen5.ApplicationContext;

public class Draw {

	static private Image bg = new ImageIcon(Draw.class.getResource("/background.png")).getImage();
	
	static public void draw(ApplicationContext context, AllSnake snake)
	{
		context.renderFrame(graphics ->
		{
			graphics.setColor(snake.getBonus().getColor());
			graphics.fill(snake.getBonus().createShape((int)snake.getPosx(), 
				(int)snake.getPosy(), snake.getBonus().getSizeX(), snake.getBonus().getSizeY()));
		});
	}
	
	static public void drawTime(ApplicationContext context, int width, int height, long timestamp)
	{		
		Rectangle2D.Float rect = new Rectangle2D.Float(width / 2 - 50, height / 50 - 15, 90, 25);

		context.renderFrame(graphics -> 
		{
			graphics.setColor(Color.BLACK);
			graphics.fill(rect);
			graphics.setColor(Color.WHITE);
			graphics.drawString("Time left : " + (60 - (timestamp / 1000)) + "s", width / 2 - 50, height / 50);
		});
	}
	
	static public void drawMenuText(ApplicationContext context, int width, int height)
	{
		context.renderFrame(graphics -> 
		{
			graphics.setColor(Color.WHITE);
			graphics.drawString("Multiplayer ? \n Y / N", width / 2 - 50, height / 2 - 100);
			graphics.drawString("Commands : Up Arrow, Left Arrow, Down Arrow, Right Arrow or ZQSD", width / 2 - 200, height / 2 );			
		});
	}
	
	static public void clearWindow(ApplicationContext context, int width, int height)
	{
		Rectangle2D.Float rect = new Rectangle2D.Float(0, 0, width, height);
		context.renderFrame(graphics ->
		{
			graphics.setColor(Color.BLACK);
			graphics.fill(rect);
		});
	}
	
	static public void hideIcon(ApplicationContext context, int posx, int posy, int w, int h)
	{
		Rectangle2D.Float rect = new Rectangle2D.Float(posx, posy, w, h);
		context.renderFrame(graphics ->
		{
			graphics.setColor(Color.BLACK);
			graphics.fill(rect);
		});
	}
	
	static public void drawBackground(ApplicationContext context, int w, int h)
	{
		context.renderFrame(graphics ->
		{
			graphics.drawImage(bg, 0, 0, w, h, Color.BLACK, null);
		});
	}
	
	static public void drawIcon(ApplicationContext context, int posx, int posy, String path)
	{
		Image img = new ImageIcon(Draw.class.getResource(path)).getImage();
		context.renderFrame(graphics ->
		{
			graphics.drawImage(img, posx, posy, 50, 50, Color.BLACK, null);
		});
	}
	
}
