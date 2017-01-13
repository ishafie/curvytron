package fr.umlv.curvy;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.ScreenInfo;

public class Window {
	
	ApplicationContext context;
	ScreenInfo screenInfo;
	private double borderRight;
	private double borderBottom;
	private double borderLeft;
	private double borderTop;
	
	/**
	 * Constructeur de la classe Window
	 * Initialise les informations de la fenetre de l'application, ainsi que
	 * les bordures de la zone de jeu (la ou le serpent se deplace).
	 * @param context context de l'application.
	 */
	public Window(ApplicationContext context)
	{
		Objects.requireNonNull(context);
		this.context = context;
		screenInfo = context.getScreenInfo();
		borderRight = screenInfo.getWidth() * 0.0151;
		borderBottom = 0.224 * screenInfo.getHeight();
		borderLeft = screenInfo.getWidth() * 0.0131;
		borderTop = 0.055 * screenInfo.getHeight();
	}
	
	/**
	 * 
	 * Initialise l'affichage de la fenetre suivant ses dimensions height et 
	 * width, donne par le systeme.
	 * @param context le context de l'application.
	 */
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
	
	/**
	 * Retourne la valeur de la largeur (width) de l'affichage.
	 * @return width, la largeur de l'ecran.
	 */
	public double getWidth()
	{
		return screenInfo.getWidth();
	}
	
	/**
	 * Retourne la valeur de la hauteur (height) de l'affichage.
	 * @return height, hauteur de l'affichage.
	 */
	public double getHeight()
	{
		return screenInfo.getHeight();
	}
	
	/**
	 * Retourne la valeur de la distance du plateau de jeu par rapport au bord inferieur de l'affichage.
	 * 
	 * @return borderBottom, distance du plateau de jeu par rapport au bord inferieur du plateau de jeu.
	 */
	public double getborderBottom()
	{
		return borderBottom; 
	}
	
	/**
	 * Retourne la valeur de la distance du plateau par rapport au haut de l'ecran.
	 * @return borderTop, distance du plateau de jeu par rapport au bord superieur de l'ecran.
	 */
	public double getborderTop()
	{
		return borderTop; 
	}
	
	/**
	 * Retourne la valeur de la distance du plateau par rapport au bord gauche de l'affichage.
	 * @return borderLeft, distance du plateau de jeu par rapport au bord gauche de l'affichage.
	 */
	public double getborderLeft()
	{
		return borderLeft; 
	}
	
	/**
	 * Retourne la valeur de la distance du plateau de jeu par rapport au bord droit de l'affichage.
	 * 
	 * @return borderRight, distance du plateau de jeu par rapport au bord droit de l'affichage.
	 */
	public double getborderRight()
	{
		return borderRight; 
	}
}


