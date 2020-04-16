import java.awt.Graphics;
import java.awt.Image;
//Don't know if all these imports will be useful
import java.awt.Toolkit;


public class Thrower{

  protected Projectile projectile;
  protected int x; // x pos of the "centre" of thrower (origin of projectile)
  protected int y; // Same for y
  protected String imagePath=""; // Path of the image to be used, to define
  protected double angle; // angle with ground with which projectile is thrown
  protected double force; // Force that the thrower applies projectile
  protected Image img ;

  public Thrower(Projectile proj, int posx, int posy){
    this.x = posx;
    this.y = posy;
    this.projectile = proj;

    String texture = "./images/slingshot2.png";
    this.img = Toolkit.getDefaultToolkit().getImage(texture);
  }

  public void launchProjectile(){
	  
    double speed = Math.sqrt( 2*this.force / this.projectile.getMass()); // Obtained With Ek = 1/2 * m * v²
    this.projectile.setSpeed(speed, this.angle);

  }
	public void dessiner ( Graphics g) {
		
		g.drawImage(this.img, this.x,this.y,null);
	}



}
