import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

//réelle classe projectile 

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
	private Timer timer;
	
	
	public Projectile (APoint p ,double dX, double dY, double angle ,Color c, Timer temps) {
		
		this.x= p.x; //position initiale en x
		this.y= p.y; //position initiale en y
		this.dx= dX; //vitesse initiale en x
		this.dy= dY; //vitesse initiale en y
		this.a= angle;
		this.couleur = c;
		this.timer = temps;
		t=0;

		
	}
	
	public void dessiner ( Graphics g) {
		
        g.setColor(this.couleur);
        // Pour dessiner un cercle
        g.fillOval((int)(this.x),(int)(this.y),2*rayon,2*rayon);
		
	}
	
	//équations horaires du déplacement du projectile
	public void action () {
		
		this.x = (double)((this.dx)*(Math.cos(a)*t)) ;
		this.y += (double)((-(GRAVITY/2)*(Math.pow(t, 2)))+(this.dx)*(Math.sin(a)*t)) ;
	}

}
