import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * Method computing every characteristic of the projectile (Speed, Position, Display)
 * @author Timothee
 */
public class Projectile extends Object{

	//Declaration of the attributes
	protected double angle ;
	protected long t;
	private double radius = 15.0 ;
	protected boolean dragged = false; // Default : false (true for testing)

	/**
	 * Constructor for the Projectile, giving a position, speed, angle, texture
	 * @param p
	 * @param dX
	 * @param dY
	 * @param angle1
	 */
	public Projectile (APoint p ,double dX, double dY, double angle1) {
		super();
		this.x= p.x; // initial position in  x
		this.y= p.y; // initial position in  y
		this.dx= dX;  // initial speed  in  x
		this.dy= dY;  // initial speed  in  y
		this.angle = angle1;

		//integration of the texture to the image
		String texture = "./images/Thrower/projectile2.png";
		this.img = Toolkit.getDefaultToolkit().getImage(texture) ;

	}

	public void isDragged(boolean d){ // Setter for dragged

		this.dragged = d;
		System.out.println("Dragging set to " + this.dragged);
	}
	/**
	 * Draw the projectile in GamePanel
	 * @param Graphics g
	 */
	public void dessiner ( Graphics g) {
		g.drawImage(this.img, (int)(this.x),(int)(this.y),null);
	}
	/**
	 * Getter of its radius
	 * @return radius
	 */
	public double getRadius() {
		return this.radius;
	}
	/**
	 * Basic method to displace the projectile
	 */
	public void move(){
		if(!this.dragged){ // Does not attempt to move if dragged
			this.dy = this.dy - (double)(GameWindow.getGravityPlanet()/10); // coeff originally 1/10
			this.x += dx;
			this.y -= dy;
			System.out.println(this.dy);
		} else {
			this.dx = 0;
			this.dy = 0;
		}

	}

	/**
	 * To stop the ball when it hits an edge and bounce on the bottom
	 * @param pan
	 */
	public void bounce(GamePanel pan){

		int h = (int)GamePanel.getGround() ; //700
		int w = 1000 ;

		if (this.y > h){ // Ground
			this.dy = -(this.dy*0.8); // bounce with 80% of initial speed
			//System.out.println("collision of proj with GROUND with x="+this.x+" and y="+this.y);  //Debug print

			if(this.y > h + this.radius) { //Avoid the projectile to go anywhere, ends its displacement
				this.dy = -(this.dy*0.8); // bounce with 80% of initial speed
				this.dx = 0.5 * this.dx ;
			}
		}
		if (this.y - this.radius < 0){ // Roof
			this.dy = 0;
			this.y = this.radius;
			System.out.println("Hit the roof");
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




}
