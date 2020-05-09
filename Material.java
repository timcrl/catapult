import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
/**
 * Creation of the blocks in this class, with their texture and conditions on their destruction
 * As well as future method for force computations
 * @author sebastien
 *
 */
public class Material extends Object {
	
	public static String[] refTextures= getTextures();
	protected APoint p ;
	
	/**
	 * Constructor getting the position of the blocks,  as well their mass, resistance and texture
	 * @param x1
	 * @param y1
	 * @param resistance
	 * @param refTexture
	 * @param mass1
	 */
	public Material (double x1, double y1, int  resistance, int refTexture, double mass1) {
		super();
		this.x = x1 ;
		this.y = y1;
		this.life = resistance ;
		this.mass = mass1;
		this.scoreValor = this.life*50;  //Attribute ScoreValor to credit the score when the block is destroyed

		this.centreX = this.barycenter().x;
		this.centreY = this.barycenter().y;
			
		//Find corresponding texture
		for (int i = 0; i < refTextures.length; i++) {
			if(i == refTexture) {
				this.texture = refTextures[i];
			}
		}
		this.img = Toolkit.getDefaultToolkit().getImage(this.texture); // direct integration of the image to the material

	}
	
	/**
	 *  Give a texture to each value in an array
	 *  Just to know  textures are 50 by 50 pixels
	 *  @return refTextures
	*/
	private  static String[] getTextures(){
		refTextures= new String[8];
		
		refTextures[1]="./images/Blocks/bois.png";
		refTextures[2]="./images/Blocks/bois2.png";
		
		refTextures[3]="./images/Blocks/brique.png";
		refTextures[4]="./images/Blocks/pierre.png";
		
		return refTextures;
	}
	
	@Override
	public APoint barycenter() {
		APoint p = new APoint(this.x+25.0,this.y+25.0); //our blocks are 50x50 pixels	
		return p;
	}
	  /**
	   * Future method to compute the force it acquires when hit by a projectile
	   * @return lateral force
	   */
	  public double lateralForce () {
		  double f ;
		  f = this.mass *this.dx ; // F = m*a
		  return f;
	  }
	
	  /**
	   * Computation of the collision between blocks and projectile
	   * To deduce whether or not it is destroyed and so remove it from listMaterials
	   */
	public void destruction() {
		double dist ;
		 
		dist = GamePanel.getProj().getDistance(this.barycenter().x, this.barycenter().y);

		if(dist <= 25.0 + GamePanel.getProj().getRadius()) {
			Terrain.listMaterials.remove(this);
			
			Terrain.computeScore(this);
			System.out.println(dist + " la distance entre le projectile et l'objet ");
		
		}
	}
		
	

}
