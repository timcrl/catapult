import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Ennemy extends Object {

	protected int life ;
	protected boolean dead = false;
	
	
	public Ennemy(double x1, double y1, int life) {
		super();
		this.life = life;
		this.x = x1;
		this.y = y1 ;
		this.centreX = this.x+25.0; 
		this.centreY = this.y +25.0;
		
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
	
	public void death() {
		
	
			if( Panneau.getProj().getDistance(this.centreX, this.centreY) <= 25.0 + Panneau.getProj().getRayon()) {
				
				//Terrain.getListEnnemies().remove(this);

			}
		
	}


}
