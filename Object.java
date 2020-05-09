import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
/**
 * Mother class of Materials, Aliens and Projectile
 * Most of attributes are declared here and contains the code for the gravityAction and Collision Detection
 * @author sebastien
 */
public class Object {

//Declaration of the attributes
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

/**
 * Constructor setting the image for each object
 */
  public Object(){

	  this.img = Toolkit.getDefaultToolkit().getImage(this.texture); // direct integration of the image to the alien
  }
  /**
   *
   * @param g
   */
  public  void dessiner ( Graphics g) {
  }
  /**
   * Set the position of the object
   * @param x
   * @param y
   */
  public void setPosition(double x, double y){
    this.x = x;
    this.y = y;
  }
  /**
   * Set the speed of the object
   * @param speed
   * @param angle
   */
  public void setSpeed(double speed, double angle){
    this.dx = speed * Math.cos(angle);
    this.dy = speed * Math.sin(angle);
  }
  /**
   * Set the barycenter of the object
   * @return APoint p
   */
  public APoint barycenter () {
	  APoint p = new APoint (this.x+25.0, this.y+25.0);

	  return p;
  }
  /**
   * Future method to compute the weight of a block
   * @return weight force
   */
  public double force () {
	  double f = 0.0;
	  f = this.mass *GameWindow.getGravityPlanet() ; // F = m*a
	  return f;
  }
  /**
   * Pythagorean Method (use of square triangle) to compute the distance between objects
   * Used for Collision Detection
   * @param x1
   * @param y1
   * @return distance
   */
	public double getDistance (double x1, double y1) {
		double xDist = x1-this.x;
		double yDist = y1-this.y;

		return Math.sqrt((Math.pow(xDist, 2)+Math.pow(yDist, 2)));
	}
	/**
	 * Simple method to compute the y distance
	 * Was used to position some blocks sometimes
	 * @param y1
	 * @return yDistance
	 */
	public double getDistanceY (double y1) {

		double yDist = y1 - this.y;
		return yDist;
	}
	/**
	 * Main method to implement gravity and stabilize blocks and aliens
	 */
	public void gravityAction(){

		this.dy  +=(double)( GameWindow.getGravityPlanet());
		this.y += (double)(this.dy);

			for (int i = 0;  i < Terrain.getlistMaterials().size() ; ++i) {

					if(this != Terrain.getlistMaterials().get(i) &&  this.x == Terrain.getlistMaterials().get(i).x && this.getDistance(Terrain.getlistMaterials().get(i).x,Terrain.getlistMaterials().get(i).y) <= 50.0 ){
						this.y = Terrain.getlistMaterials().get(i).y-50.0; // position the block above another block
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

					if(this != Terrain.getlistMaterials().get(i) &&  this.x != Terrain.getlistMaterials().get(i).x &&  this.getDistance(Terrain.getlistMaterials().get(i).x,Terrain.getlistMaterials().get(i).y) <= 50.0 ){
							if ( this.centreX >  Terrain.getlistMaterials().get(i).centreX +15.0) {
								this.x= Terrain.getlistMaterials().get(i).x + 50.0 ;  // moves to the right the block if it is on the right edge
							}
							if (  this.centreX <  Terrain.getlistMaterials().get(i).centreX -15.0) {
								this.x= Terrain.getlistMaterials().get(i).x -  50.0 ;  //moves to the left the block if it is on the left edge
							}
							else {
								this.y = Terrain.getlistMaterials().get(i).y-50.0;  //only fix the block above if its center of mass is stable
								this.dy = 0;
								break;
							}
					}

			}
			//to avoid slow down the display and the movements of the blocks
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}



}
