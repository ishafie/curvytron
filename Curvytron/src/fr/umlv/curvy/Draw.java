package fr.umlv.curvy;
import java.awt.Color;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

import fr.umlv.zen5.ApplicationContext;

public class Draw {
	private final static Color transparence = new Color(0,0,0,0);
	static private Image bg = new ImageIcon(Draw.class.getResource("/background.png")).getImage();
	
	/**
	 * Constructeur de la classe Draw
	 * @param context le context de l'application.
	 * @param snake le snake actuel.
	 */
	static public void draw(ApplicationContext context, AllSnake snake)
	{
		context.renderFrame(graphics ->
		{
			graphics.setColor(snake.getBonus().getColor());
			graphics.fill(snake.getBonus().createShape((int)snake.getPosx(), 
				(int)snake.getPosy(), snake.getBonus().getSizeX(), snake.getBonus().getSizeY()));
			graphics.fill(snake.getBonus().createShape((int)snake.getPosx(), 
					(int)snake.getPosy() + 7, snake.getBonus().getSizeX(), snake.getBonus().getSizeY()));
		});
	}
	
	/**
	 * Affichage du temps suivant le temps timestamp
	 * @param context le contexte de l'application
	 * @param width la largeur
	 * @param height la hauteur
	 * @param timestamp temps
	 */
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
	
	/**
	 * Affichage du menu de lancement, des commandes et de l'activation de l'option multijoueur.
	 * @param context context de l'application
	 * @param width taille de la fenetre (largeur)
	 * @param height taille de la fenetre (hauteur)
	 */
	static public void drawMenuText(ApplicationContext context, int width, int height)
	{
		context.renderFrame(graphics -> 
		{
			graphics.setColor(Color.WHITE);
			graphics.drawString("Multiplayer ? \n Y / N", width / 2 - 50, height / 2 - 100);
			graphics.drawString("Commands : Up Arrow, Left Arrow, Down Arrow, Right Arrow or ZQSD", width / 2 - 200, height / 2 );			
		});
	}
	
	/**
	 * Efface la fenetre, et affiche un fond noir.
	 * @param context contexte de l'application.
	 * @param width taille de la fenetre (largeur).
	 * @param height taille de la fenetre (hauteur).
	 */
	static public void clearWindow(ApplicationContext context, int width, int height)
	{
		Rectangle2D.Float rect = new Rectangle2D.Float(0, 0, width, height);
		context.renderFrame(graphics ->
		{
			graphics.setColor(Color.BLACK);
			graphics.fill(rect);
		});
	}
	
	/**
	 * Efface l'image du bonus sur l'ecran.
	 * @param context context de l'application
	 * @param posx coordonee en x du bonus.
	 * @param posy coordonne en y du bonus.
	 * @param w taille du bonus (largeur).
	 * @param h taille du bonus (hauteur).
	 */
	static public void hideIcon(ApplicationContext context, int posx, int posy, int w, int h)
	{
		Rectangle2D.Float rect = new Rectangle2D.Float(posx, posy, w, h);
		context.renderFrame(graphics ->
		{
			graphics.setColor(new Color(110,129,1,255));
			graphics.fill(rect);
		});
	}
	
	/**
	 * Affiche le background sur l'ecran. 
	 * @param context context de l'application.
	 * @param w taille de la fenetre (largeur).
	 * @param h taille de la fenetre (hauteur).
	 */
	static public void drawBackground(ApplicationContext context, int w, int h)
	{
		context.renderFrame(graphics ->
		{
			graphics.drawImage(bg, 0, 0, w, h, Color.BLACK, null);
		});
	}
	
	/**
	 * Affiche le bonus ou l'icone dont le chemin est passe en parametre
	 * @param context context de l'application.
	 * @param posx la coordonee en x du point en haut a gauche.
	 * @param posy la coordonee en y du point en haut a gauche.
	 * @param path le path de l'image.
	 */
	static public void drawIcon(ApplicationContext context, int posx, int posy, String path)
	{
		Image img = new ImageIcon(Draw.class.getResource(path)).getImage();
		context.renderFrame(graphics ->
		{
			graphics.drawImage(img, posx, posy, 50, 50, transparence, null);
		});
	}
	
}
