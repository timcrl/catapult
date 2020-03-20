import java.awt.Color;
import java.awt.Graphics;

public abstract class Object {
  
  protected final double GRAVITY = 9.8 ;
  

  public Object(){
  
  
  }
  
  public abstract void dessiner ( Graphics g);
  
  public abstract APoint barycenter ();
  
  public abstract double [] force ();
	
		
		
		
}
