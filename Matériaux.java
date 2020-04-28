import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Matériaux extends Object { //incorporer les résistances dans les matériaux etc...
	
	public static String[] refTextures= getTextures();
	protected APoint p ;
	protected int mass ;
	
	public Matériaux (double x1, double y1, int  resistance, int refTexture, int mass1) {
		super();
		this.x = x1 ;
		this.y = y1;
		this.life = resistance ;
		this.mass = mass1;
		this.scoreValor = this.life*50;  //Attribute ScoreValor

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
	
	/* Give a texture to each value
	Just to know  textures are 50 by 50 pixels
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
		APoint p = new APoint(this.x+25.0,this.y+25.0);	
		return p;
	}
	
	  public double weightForce () {
		  double f ;
		  f = this.mass *this.dy ; // F = m*a
		  return f;
	  }
	  
	  public double lateralForce () {
		  double f ;
		  f = this.mass *this.dx ; // F = m*a
		  return f;
	  }
	
	//Computation of the collision projectile-blocks
	public void destruction() {
		double dist ;
		 
		dist = Panneau.getProj().getDistance(this.barycenter().x, this.barycenter().y);

		if(dist <= 25.0 + Panneau.getProj().getRayon()) {
			Terrain.listMaterials.remove(this);
			
			Terrain.computeScore(this);
			Panneau.getProj().couleur = Color.orange ;
			System.out.println(dist + " la distance entre le projectile et l'objet ");
		
		}
	}
		
	

}
