import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Ennemy extends Object {

	public static String[] refAlien = getAlien();
	protected String textureAlien ;
	
	protected int life ;
	protected boolean dead = false;
	
	
	public Ennemy(double x1, double y1, int life, int textureAlien) {
		super();
		this.life = life;
		this.x = x1;
		this.y = y1 ;
		this.centreX = this.x+25.0; 
		this.centreY = this.y +25.0;
		
		//find corresponding texture for the alien
		for (int i = 0; i < refAlien.length; i++) {
			if(i == textureAlien) {
				this.textureAlien = refAlien[i];
			}
		}
		this.img = Toolkit.getDefaultToolkit().getImage(this.textureAlien); // direct integration of the image to the alien
		
	}
	//give a texture to each alien
	private  static String[] getAlien(){
		refAlien = new String[8];
		
		refAlien[1]="./images/alien1.png";
		refAlien[2]="./images/alien2.png";
		refAlien[3]="./images/alien3.png";
		refAlien[4]="./images/alien4.png";
		refAlien[5]="./images/alien5.png";
		refAlien[6]="./images/alien_boss.png";
		
		return refAlien;
	}
	
	public void gravityAction(){
		
		
		if(!this.stable) {
			if (this.y + 50.0 < Panneau.getGround()+10.0 ) {
				this.y += this.GRAVITY ;
			} 
			else if(this.getDistanceY(this.y + this.GRAVITY) >= ((Panneau.getGround()+10.0) - (this.y + 50.0))){
				this.y = 620.0 ;
				this.stable = true ;
			}
		}

	}
	
	// Distance computation to determine the death of the alien
	public void death() {
		
		double dist ;
			 
		dist = Panneau.getProj().getDistance(this.barycenter().x, this.barycenter().y);
		
		if(dist <= 25.0 + Panneau.getProj().getRayon()) {

			Terrain.listEnnemies.remove(this);
				
			Panneau.getProj().couleur = Color.yellow ;
			System.out.println(dist + " la distance entre le projectile et l'objet ");
			
		}
	}


}
