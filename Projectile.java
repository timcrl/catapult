import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


public class Projectile extends Object{
	
	protected Color couleur;
	protected double a ;
	protected final double GRAVITY = 0.3; // original value 9.8
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

	public void setPosition(double x, double y){
		this.x = x;
		this.y = y;
	}

	public void setSpeed(double speed,double angle){
		this.dx = speed*Math.cos(angle);
		this.dy = speed*Math.sin(angle);

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
	public void move(){
		this.dy -= GRAVITY;
		this.x += dx;
		this.y -= dy;
	}

	// To stop the ball when it hits an edge and bounce on the bottom
	public void bounce(Panneau pan){
		
	
		int h = (int)Panneau.getGround() ;
		int w = 1000 ;

		
		if (this.y < h){ // Ground
			this.dy = -(this.dy*0.8); // bounce with 80% of initial speed
			System.out.println("collision of proj with GROUND with x="+this.x+" and y="+this.y);  //Debug print
			System.out.println(w +" x "+h);
			if(this.y > h + this.rayon) { //Avoid the projectile to go anywhere, ends its displacement
				this.y = 680;
				this.dx = 0.2* this.dx ;
			}
		}
		/*
		if (this.y - this.rayon < 0){ // Roof
			this.dy = 0;
			this.y = this.rayon;
			System.out.println("collision of proj with ROOF with x="+this.x+" and y="+this.y);
			System.out.println(pan.getWidth()+" x "+pan.getHeight());
		}
		if (this.x - this.rayon < 0){
				this.x = this.rayon;
				this.dx = 0;
				System.out.println("collision of proj with LEFT EDGE with x="+this.x+" and y="+this.y);
				System.out.println(pan.getWidth()+" x "+pan.getHeight());
		}
		if (this.x + this.rayon > pan.getWidth()) {
			this.x = pan.getHeight() - this.rayon;
			this.dx = 0;
			System.out.println("collision of proj with RIGHT EDGE with x="+this.x+" and y="+this.y);
			System.out.println(pan.getWidth()+" x "+pan.getHeight());
		}*/

		if (this.y - this.rayon < 0){ // Roof
			this.dy = 0;
			this.y = this.rayon;
			System.out.println("collision of proj with ROOF with x="+this.x+" and y="+this.y);
			System.out.println(w +" x "+h);
		}
		if (this.x - this.rayon < 0){

				this.x = this.rayon;
				this.dx = -this.dx*0.7;
				System.out.println("collision of proj with LEFT EDGE with x="+this.x+" and y="+this.y);
				System.out.println(w +" x "+h);
		}
		if (this.x + this.rayon > w) {
			this.x = pan.getHeight() - this.rayon;
			this.dx = -this.dx*0.7;
			System.out.println("collision of proj with RIGHT EDGE with x="+this.x+" and y="+this.y);
			System.out.println(w +" x "+h);
		}
		
	}
	//===========================

	@Override
	public APoint barycenter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double force() {
		// TODO Auto-generated method stub
		return (Double) null;
	}


}
