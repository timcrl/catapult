import java.awt.Graphics;
import java.awt.Image;

public class Object {

  protected final double GRAVITY = 0.005 ;
  protected double mass ;
  protected double x;
  protected double y;
  protected double dx ;
  protected double dy ;

  protected double centreX;
  protected double centreY;

  protected int time ;
  protected Image img ;
  protected boolean stable;

  public Object(){


  }

  public  void dessiner ( Graphics g) {

  }

  public void setPosition(double x, double y){
    this.x = x;
    this.y = y;
  }

  public void setSpeed(double speed, double angle){
    this.dx = speed * Math.cos(angle);
    this.dy = speed * Math.sin(angle);
  }

  public APoint barycenter () {
	  APoint p = new APoint (this.x+25.0, this.y+25.0);

	  return p;
  }

  public double force () {
	  double f = 0.0;
	  f = this.mass *this.GRAVITY ; // F = m*a
	  return f;
  }

	public double getDistance (double x1, double y1) {
		double xDist = x1-this.x;
		double yDist = y1-this.y;

		return Math.sqrt((Math.pow(xDist, 2)+Math.pow(yDist, 2)));

	}
	public double getDistanceY (double y1) {

		double yDist = y1 - this.y;

		return yDist;

	}
	public void gravityAction(int deltaTime){

		this.time += deltaTime ;
		int realTime = (int)(time/60);

		this.dy += this.GRAVITY * realTime ;

		/* IDEAS =========
		speed += acceleration * deltaTime;
		position += speed * deltaTime;
		or=====
		time += timestep;
		position += timestep * (velocity + timestep * acceleration / 2);
		oldAcceletation = acceleration; // Store it
		acceleration = force(time, position) / mass;
		velocity += timestep * (acceleration + oldAcceleration) / 2;
		*/
		if(!this.stable) {
			if (this.y + 50.0 < Panneau.getGround()+10.0 ) {
				this.y += this.dy*realTime ;
			}
			else if(this.getDistanceY(this.y + (this.dy*realTime)) >= ((Panneau.getGround()+10.0) - (this.y + 50.0))){
				this.y = 620.0 ;
				this.stable = true ;
			}
		}

		try {
			Thread.sleep(17);
		  } catch (InterruptedException e) {
			e.printStackTrace();
		  }

	}



}
