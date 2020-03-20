import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


public class Projectile extends Object{
	
	protected double x;
	protected double y;
	protected double dx ;
	protected double dy ; 
	protected Color couleur;
	protected double a ;
	protected final double GRAVITY = 9.8 ;
	protected long t;
	private double rayon = 15.0 ;
	
	
	
	public Projectile (APoint p ,double dX, double dY, double angle ,Color c, long temps) {
		super();
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
        g.fillOval((int)(this.x),(int)(this.y),(int)(2*rayon),(int)(2*rayon));
		
	}
	public double getRayon() {
		return this.rayon;
	}
	
	public double getDistance (double x1, double y1) {
		double xDist = x1-this.x;
		double yDist = y1-this.y;
		
		return Math.sqrt((Math.pow(xDist, 2)+Math.pow(yDist, 2)));
		
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
    	//System.out.println(deltaX);
  
    	if(this.x > fenêtre.getWidth()) {
			this.x = this.x+ deltaX ;
			backX = true;
 		}else if (this.x+deltaX <= 50 ){
 			backX = false;
 			this.x = this.x + deltaX ;
 		}else {
 			this.x = this.x + deltaX ;
 		}
    	//System.out.println("cercle deplace");
	}

	@Override
	public APoint barycenter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[] force() {
		// TODO Auto-generated method stub
		return null;
	}

}
