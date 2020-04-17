import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Ennemy extends Object {

	public static String[] refAlien = getAlien();
	protected boolean dead = false;
	
	public Ennemy(double x1, double y1, int life, int textureAlien) {
		super();
		this.life = life;
		this.x = x1;
		this.y = y1 ;
		this.centreX = this.x+25.0; 
		this.centreY = this.y +25.0;
		
		//Attribute ScoreValor
		this.scoreValor = this.life*200;
		
		//Find corresponding texture for the alien
		for (int i = 0; i < refAlien.length; i++) {
			if(i == textureAlien) {
				this.texture = refAlien[i];
			}
		}
		this.img = Toolkit.getDefaultToolkit().getImage(this.texture); // direct integration of the image to the alien
		
	}
	//give a texture to each alien
	private  static String[] getAlien(){
		refAlien = new String[8];
		
		refAlien[1]="./images/Aliens/alien1.png";
		refAlien[2]="./images/Aliens/alien2.png";
		refAlien[3]="./images/Aliens/alien3.png";
		refAlien[4]="./images/Aliens/alien4.png";
		refAlien[5]="./images/Aliens/alien5.png";
		refAlien[6]="./images/Aliens/alien_boss.png";
		
		return refAlien;
	}
	// Distance computation to determine the death of the alien
	public void death() {
		
		double dist = Panneau.getProj().getDistance(this.barycenter().x, this.barycenter().y);
		
		if(dist <= 25.0 + Panneau.getProj().getRayon()) {

			Terrain.listEnnemies.remove(this);
			Terrain.computeScore(this);

			Panneau.getProj().couleur = Color.yellow ;
			System.out.println(dist + " la distance entre le projectile et l'objet ");
			
		}
	}


}
