import java.awt.Graphics;
import java.awt.Image;

public class Object {
  
  protected final double GRAVITY = 9.8 ;
  protected double x;
  protected double y;
  protected Image img ;
  
  public Object(){
  
  
  }
  
  public  void dessiner ( Graphics g) {
	  
  }
  
  public APoint barycenter () {
	  APoint p = new APoint (50, 50);
	  
	  return p;
  }
  
  public double force () {
	  double f = 0.0;
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

  
}
