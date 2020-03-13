import java.awt.Color;
import java.awt.Graphics;

public class Projectile {
	
	protected double x ;
	protected double y ;
	protected double dx ;
	protected double dy ; 
	protected Color couleur;
	protected double a ;
	protected final double GRAVITY = 9.8 ;
	protected long t;
	
	
	public Projectile (APoint p ,double dX, double dY, double angle ,Color c) {
		this.x= p.x;
		this.y= p.y;
		this.dx= dX;
		this.dy= dY;
		this.a= angle;
		this.couleur = c;

		
	}
	
	public void dessiner ( Graphics g , int w, int h ) {
		
	}
	
	public void action () {
		this.x = (double)((this.dx)*(Math.cos(a)*t)) ;
		this.y += (double)((-(GRAVITY/2)*(Math.pow(t, 2)))+(this.dx)*(Math.sin(a)*t)) ;
	}

}
