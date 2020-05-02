import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


public class Projectile extends Object{

	protected Color couleur;
	protected double angle ;
	protected long t;
	private double radius = 15.0 ;
	protected boolean dragged = true; // Default : false (true for testing)


	public Projectile (APoint p ,double dX, double dY, double angle1 ,Color c) {
		super();
		this.x= p.x; //position initiale en x
		this.y= p.y; //position initiale en y
		this.dx= dX; //vitesse initiale en x
		this.dy= dY; //vitesse initiale en y
		this.angle = angle1;
		this.couleur = c;

		//integration of the texture to the image
		String texture = "./images/projectile2.png";
		this.img = Toolkit.getDefaultToolkit().getImage(texture) ;

	}

	public void setPosition(double x, double y){
		this.x = x;
		this.y = y;
	}

	public void setSpeed(double speed,double angle){
		this.dx = speed*Math.cos(angle);
		this.dy = speed*Math.sin(angle);

	}

	public void isDragged(boolean d){ // Setter for dragged
		this.dragged = d;
	}

	public void dessiner ( Graphics g) {
		g.drawImage(this.img, (int)(this.x),(int)(this.y),null);
	}

	public double getRayon() {
		return this.radius;
	}

	public void move(){
		if(!this.dragged){ // Does not attempt to move if dragged
			this.dy -= (double)(Fenêtre.getGravityPlanet()*1/10);
			this.x += dx;
			this.y -= dy;
		}

	}

	// To stop the ball when it hits an edge and bounce on the bottom
	public void bounce(Panneau pan){

		int h = (int)Panneau.getGround() ; //700
		int w = 1000 ;

		if (this.y < h){ // Ground
			this.dy = -(this.dy*0.8); // bounce with 80% of initial speed
			//System.out.println("collision of proj with GROUND with x="+this.x+" and y="+this.y);  //Debug print

			if(this.y > h + this.radius) { //Avoid the projectile to go anywhere, ends its displacement
				this.dy = -(this.dy*0.8); // bounce with 80% of initial speed
				this.dx = 0.5 * this.dx ;
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
		}
		*/
		if (this.y - this.radius < 0){ // Roof
			this.dy = 0;
			this.y = this.radius;
			//System.out.println("collision of proj with ROOF with x="+this.x+" and y="+this.y);
			//System.out.println(w +" x "+h);
		}
		if (this.x - this.radius < 0){

				this.x = this.radius;
				this.dx = -this.dx*0.7;
				//System.out.println("collision of proj with LEFT EDGE with x="+this.x+" and y="+this.y);
				//System.out.println(w +" x "+h);
		}
		if (this.x + this.radius > w) {
			this.x = pan.getHeight() - this.radius;
			this.dx = -this.dx*0.7;
			//System.out.println("collision of proj with RIGHT EDGE with x="+this.x+" and y="+this.y);
			//System.out.println(w +" x "+h);
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

	public double getMass() {
		// TODO Auto-generated method stub
		return 1;
	}

	/*=================UNUSED CODE NOW

 	//Pythagorean method to compute the distance and collision
	//équations horaires du déplacement du projectile UNUSED

		public void action (long temps) {
			this.t = temps;

			this.x = (double)((this.dx)*(Math.cos(angle)*t)) ;
			//this.y = (double)((-(this.GRAVITY/(2*(Math.pow(this.dy, 2))*(Math.pow(Math.cos(this.a),2))))*(Math.pow(this.dx, 2)*(Math.tan(this.a))*this.dx)));
			this.y = (double)((-(Fenêtre.getGravityPlanet()/2)*(Math.pow(t, 2)))+(this.dx)*((Math.sin(angle))*t));

		}

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
		*/




}
