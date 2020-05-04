import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Object {

  protected double x; // x and y position of the objects
  protected double y;
  protected double dx ; // x and y velocity of the objects
  protected double dy ;

  protected double centreX;
  protected double centreY;

  protected double mass ;
  protected int life ;
  
  protected Image img ;
  protected int scoreValor; // value to credit the score when the object is destroyed
  protected String texture ;


  public Object(){

	  this.img = Toolkit.getDefaultToolkit().getImage(this.texture); // direct integration of the image to the alien
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
	  f = this.mass *GameWindow.getGravityPlanet() ; // F = m*a
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
	
	public void gravityAction(){

		this.dy  +=(double)( GameWindow.getGravityPlanet());
		this.y += (double)(this.dy*(1.0/30.0)) ;  //so as to get the right number of image per second (should be *1/60)
				
			for (int i = 0;  i < Terrain.getlistMateriaux().size() ; ++i) {
					
					if(this != Terrain.getlistMateriaux().get(i) &&  this.x == Terrain.getlistMateriaux().get(i).x && this.getDistance(Terrain.getlistMateriaux().get(i).x,Terrain.getlistMateriaux().get(i).y) <= 50.0 ){
						this.y = Terrain.getlistMateriaux().get(i).y-50.0; // position the block above another block
						this.dy = 0;
						break;
					}
					if (this.y + 50.0 > GamePanel.getGround() ) {
						this.y = GamePanel.getGround() - 50.0; //position the block above the ground
						this.dy = 0;
						break;
					}
					//=========above only required code for gravity
					//=========down trying to deviate the block with respect to its x position (it should rotate but no idea for now of how to do so)
					
					if(this != Terrain.getlistMateriaux().get(i) &&  this.x != Terrain.getlistMateriaux().get(i).x &&  this.getDistance(Terrain.getlistMateriaux().get(i).x,Terrain.getlistMateriaux().get(i).y) <= 50.0 ){
							if ( this.centreX >  Terrain.getlistMateriaux().get(i).centreX +15.0) {
								this.x= Terrain.getlistMateriaux().get(i).x + 50.0 ;  // moves to the right the block if it is on the right edge
							}
							if (  this.centreX <  Terrain.getlistMateriaux().get(i).centreX -15.0) {
								this.x= Terrain.getlistMateriaux().get(i).x -  50.0 ;  //moves to the left the block if it is on the left edge
							}
							else {
								this.y = Terrain.getlistMateriaux().get(i).y-50.0;  //only fix the block above if its center of mass is stable
								this.dy = 0;
								break;
							}
					}
			
			}
				
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}



}
