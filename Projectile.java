import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


public class Projectile {
	
	protected double x;
	protected double y;
	protected double dx ;
	protected double dy ; 
	protected Color couleur;
	protected double a ;
	protected final double GRAVITY = 9.8 ;
	protected long t;
	private int rayon = 15 ;
	
	
	
	public Projectile (APoint p ,double dX, double dY, double angle ,Color c, long temps) {
		
		this.x= p.x; //position initiale en x
		this.y= p.y; //position initiale en y
		this.dx= dX; //vitesse initiale en x
		this.dy= dY; //vitesse initiale en y
		this.a= angle;
		this.couleur = c;
		this.t = temps;
	

		
	}
	
	public void dessiner ( Graphics g) {
		
        g.setColor(this.couleur);
        // Pour dessiner un cercle
        g.fillOval((int)(this.x),(int)(this.y),2*rayon,2*rayon);
		
	}
	
	//équations horaires du déplacement du projectile
	public void action () {
		
		this.x = (double)((this.dx)*(Math.cos(a)*t)) ;
		this.y += (double)((-(GRAVITY/2)*(Math.pow(t, 2)))+(this.dx)*(Math.sin(a)*t));
		System.out.println(t + "s");
	}
	
	//méthode pour essayer de travailler avec la collision sans équations horaires
	public void deplaceX (Fenêtre fenêtre) {
		int deltaX = 10;
		boolean backX = false;
		
    	if (backX) {
    		deltaX = -deltaX;
    	}
    	System.out.println(deltaX);
  
    	if(this.x > fenêtre.getWidth()) {
			this.x = this.x+ deltaX ;
			backX = true;
 		}else if (this.x+deltaX <= 50 ){
 			backX = false;
 			this.x = this.x + deltaX ;
 		}else {
 			this.x = this.x + deltaX ;
 		}
    	System.out.println("cercle deplace");
	}

}
