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
	
	
	
	public Projectile (APoint p ,double dX, double dY, double angle ,Color c) {
		super();
		this.x= p.x; //position initiale en x
		this.y= p.y; //position initiale en y
		this.dx= dX; //vitesse initiale en x
		this.dy= dY; //vitesse initiale en y
		this.a= angle;
		this.couleur = c;

		
	}
	
	public void dessiner ( Graphics g) {
		
        g.setColor(this.couleur);
        // Pour dessiner un cercle
        g.fillOval((int)(this.x),(int)(this.y),(int)(2*rayon),(int)(2*rayon));
		
	}
	
	public double getRayon() {
		return this.rayon;
	}
	
	//Pythagorean method to compute the distance and collision
	
	public double getDistance (double x1, double y1) {
		double xDist = x1-this.x;
		double yDist = y1-this.y;
		
		return Math.sqrt((Math.pow(xDist, 2)+Math.pow(yDist, 2)));
		
	}
	
	//équations horaires du déplacement du projectile
	public void action (long temps) {
		this.t = temps;

		this.x = (double)((this.dx)*(Math.cos(a)*t)) ;
		/*this.y = (double)((-(this.GRAVITY/(2*(Math.pow(this.dy, 2))*(Math.pow(Math.cos(this.a),2))))
				*(Math.pow(this.dx, 2)*(Math.tan(this.a))*this.dx)));
		*/
		this.y = (double)((-(GRAVITY/2)*(Math.pow(t, 2)))+(this.dx)*((Math.sin(a))*t));
	
	}

	//==========================
	//méthodes pour essayer de travailler avec la collision sans équations horaires
	public void deplaceX (Fenêtre fenêtre) {
		
		boolean backX = false;
		
    	if (backX) {
    		dx = -dx;
    	}
    	//System.out.println(deltaX);
  
    	if(this.x > fenêtre.getWidth()) {
			this.x = this.x+ dx ;
			backX = true;
 		}else if (this.x+dx <= 50 ){
 			backX = false;
 			this.x = this.x + dx ;
 		}else {
 			this.x = this.x + dx ;
 		}
    	//System.out.println("cercle deplace");
	}
	public void deplaceY (Fenêtre fenêtre) {
		
		boolean backY = false;
		
    	if (backY) {
    		dy= -dy;
    	}
    	//System.out.println(deltaX);
  
    	if(this.y > fenêtre.getHeight()) {
			this.y = this.y+ dy ;
			backY = true;
 		}else if (this.y+dy <= 50 ){
 			backY = false;
 			this.y = this.y + dy ;
 		}else {
 			this.y = this.y+ dy ;
 		}
    	//System.out.println("cercle deplace");
	}
	//===========================

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
