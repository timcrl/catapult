import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
/**
 * Creation of the aliens in this class, with their texture and conditions on their death
 * @author sebastien
 *
 */
public class Enemy extends Object {

	private static String[] refAlien = getAlien();
	/**
	 * Constructor of the class, using the first parameters for the position necessary to the display
	 * And texture parameter for the GUI, as well as life (would have been use to know how many hit it can bear)
	 * @param x1
	 * @param y1
	 * @param life
	 * @param textureAlien
	 */
	public Enemy(double x1, double y1, int life, int textureAlien) {
		super();
		this.life = life;
		this.x = x1;
		this.y = y1 ;
		this.centreX = this.x+25.0;  // to remember aliens images are 50x50 pixels
		this.centreY = this.y +25.0;
		
		//Attribute ScoreValor, to raise the score by this value when the enemy dies
		this.scoreValor = this.life*200;
		
		//Find corresponding texture for the alien
		for (int i = 0; i < refAlien.length; i++) {
			if(i == textureAlien) {
				this.texture = refAlien[i];
			}
		}
		this.img = Toolkit.getDefaultToolkit().getImage(this.texture); // direct integration of the image to the alien
		
	}
	/**
	 * Simple method creating an array of string containing every Alien textures
	 * @return refAlien
	 */
	private  static String[] getAlien(){
		refAlien = new String[8];
		//give a texture to each alien (50x50 pixels)
		refAlien[1]="./images/Aliens/alien1.png";
		refAlien[2]="./images/Aliens/alien2.png";
		refAlien[3]="./images/Aliens/alien3.png";
		refAlien[4]="./images/Aliens/alien4.png";
		refAlien[5]="./images/Aliens/alien5.png";
		refAlien[6]="./images/Aliens/alien_boss.png";
		
		return refAlien;
	}
	
	/**
	 * Distance computation to determine the death of the alien caused by the projectile
	 * And if it is, removes the alien from listEnemies
	 */
	public void death() {
		
		double dist = GamePanel.getProj().getDistance(this.barycenter().x, this.barycenter().y); // Pythagorean method to compute distance
		
		if(dist <= 25.0 + GamePanel.getProj().getRadius()) {

			Terrain.listEnemies.remove(this);  // the block is no more displayed
			Terrain.computeScore(this); // increments the score

			System.out.println(dist + " la distance entre le projectile et l'objet "); //monitoring of the code
			
		}
	}


}
