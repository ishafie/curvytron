package fr.umlv.curvy;
import java.awt.Color;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

import fr.umlv.zen5.ApplicationContext;

public class Draw {

	
	public Draw()
	{
		
	}
	
	public void draw(ApplicationContext context, AllSnake snake)
	{
		Ellipse2D.Float ellipse = new Ellipse2D.Float((int)snake.getPosx() - (int)snake.getSizex(), 
				(int)snake.getPosy() - (int)snake.getSizey(), snake.getSizex(), snake.getSizey());
		context.renderFrame(graphics ->
		{
			graphics.setColor(snake.getColor());
			graphics.fill(ellipse);
		});
	}
	
	public void hideIcon(ApplicationContext context, int posx, int posy, int w, int h)
	{
		Rectangle2D.Float rect = new Rectangle2D.Float(posx, posy, w, h);
		context.renderFrame(graphics ->
		{
			graphics.setColor(Color.BLACK);
			graphics.fill(rect);
		});
	}
	
	public void drawSpeedModeIcon(ApplicationContext context, int posx, int posy)
	{
		Image img = new ImageIcon(this.getClass().getResource("/sonic.png")).getImage();
		context.renderFrame(graphics ->
		{
			graphics.drawImage(img, posx, posy, 50, 50, Color.BLACK, null);
		});
	}
}
