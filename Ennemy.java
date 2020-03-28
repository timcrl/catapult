import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Ennemy extends Object {

	protected int life ;
	protected boolean stable;
	protected boolean dead = false;
	
	
	public Ennemy(double x1, double y1, int life) {
		super();
		this.life = life;
		this.x = x1;
		this.y = y1 ;
		this.img = Toolkit.getDefaultToolkit().getImage("./images/alien1.png");
		
	}
	
	public void gravityAction(){
		
		
		if(!this.stable) {
			if (this.y + 50.0 < 670.0 ) {
				this.y += this.GRAVITY ;
			} 
			else if(this.getDistanceY(this.y + this.GRAVITY) >= (670.0 - (this.y + 50.0))){
				this.y = 620.0 ;
				this.stable = true ;
			}
		}
		
	}


}
