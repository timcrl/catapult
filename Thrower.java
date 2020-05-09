import java.awt.Graphics;
import java.awt.Image;
//Don't know if all these imports will be useful
import java.awt.Toolkit;

/**
 * Class of the slingshot containing its computation methods and display
 * @author Timothee 
 *
 */
public class Thrower{

<<<<<<< HEAD
  protected Projectile projectile;
  protected boolean dragging = false; // Default : false (true for testing)
  protected int x; // x pos of the "centre" of thrower (origin of projectile)
  protected int y; // Same for y
  protected double mouseX; // X coordinate of the pointer (used only when projectile launched)
  protected double mouseY; // Same for Y
  protected String imagePath=""; // Path of the image to be used, to define
  protected double forceCoefficient = 0.1; // Force that the thrower applies projectile per unit distance
  protected Image img ;

  public Thrower(Projectile proj, int posX, int posY){
    // initializing attributes
    this.x = posX;
    this.y = posY;
    this.projectile = proj;

    String texture = "./images/Thrower/slingshot2.png";
    this.img = Toolkit.getDefaultToolkit().getImage(texture);


  }

  public void setMousePosition(double x, double y){
      this.mouseX = x;
      this.mouseY = y;
  }

  public void setDragging(boolean d){ // Setter for dragging
    this.dragging = d;
  }
  public boolean isDragging(){ // Getter for dragging
    return this.dragging;
  }

  public void launchProjectile(){

    double speedCoefficient = Math.sqrt( 2*this.forceCoefficient / this.projectile.getMass()); // Obtained With Ek = 1/2 * m * v²
    double vx = (this.x-this.mouseX)*speedCoefficient;
    double vy = -(this.y-this.mouseY)*speedCoefficient;

    this.projectile.setSpeed(vx, vy); // Sets the speed
    System.out.println("projectile launched at speed vx=" + vx + " and vy =" + vy);

  }
	public void dessiner ( Graphics g) {

		g.drawImage(this.img, this.x,this.y,null);
	}
=======
		  //Declaration of the attributes
	
		  protected Projectile projectile;
		  protected boolean dragging = false; // Default : false (true for testing)
		  protected int x; // x pos of the "centre" of thrower (origin of projectile)
		  protected int y; // Same for y
		  protected double mouseX; // X coordinate of the pointer (used only when projectile launched)
		  protected double mouseY; // Same for Y
		  protected String imagePath=""; // Path of the image to be used, to define
		  protected double forceCoefficient = 0.1; // Force that the thrower applies projectile per unit distance
		  protected Image img ;
		  
		  /**
		   * Constructor setting the position and texture of the slingshot
		   * @param proj
		   * @param posX
		   * @param posY
		   */
		  public Thrower(Projectile proj, int posX, int posY){
			    // initializing attributes
			    this.x = posX;
			    this.y = posY;
			    this.projectile = proj;
			
			    String texture = "./images/Thrower/slingshot2.png";
			    this.img = Toolkit.getDefaultToolkit().getImage(texture);
		  }
		  
		  /**
		   * Set the position of the mouse
		   * Useful to work with the other methods
		   * @param x
		   * @param y
		   */
		  public void setMousePosition(double x, double y){
			      this.mouseX = x;
			      this.mouseY = y;
		  }
		  /**
		   * Setter for the boolean dragging
		   * @param d
		   */
		  public void setDragging(boolean d){ 
			    this.dragging = d;
		  }
		  /**
		   * Getter for the boolean dragging
		   * @return dragging
		   */
		  public boolean isDragging(){
			    return this.dragging;
		  }
		  /**
		   * Method giving a speed to the projectile when launched by the player
		   */
		  public void launchProjectile(){
		
			    double speedCoefficient = Math.sqrt( 2*this.forceCoefficient / this.projectile.getMass()); // Obtained With Ek = 1/2 * m * v²
			    this.projectile.setSpeed((this.x-this.mouseX)*speedCoefficient, (this.y-this.mouseY)*speedCoefficient); // Sets the speed
			    System.out.println("projectile launched");
		
		  }
		  /**
		   * Draw the slingshot in the GamePanel
		   * @param g
		   */
		  public void dessiner ( Graphics g) {
	
					g.drawImage(this.img, this.x,this.y,null);
			}
>>>>>>> 10b24d635878516b5638fc262976a2dcffa204e3



}
