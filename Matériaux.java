import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Matériaux extends Object { //incorporer les résistances dans les matériaux etc...
	
	public static String[] refTextures= getTextures();
	protected double resistance ;
	protected String texture ;
	protected APoint p ;
	
	public Matériaux (double x1, double y1, double resist, int refTexture) {
		super();
		this.x = x1 ;
		this.y = y1;
		this.resistance = resist ;
		
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
	pour info les textures c'est du 50 par 50 pixels pour vous aider avec les coordonnées !!!
	*/
	private  static String[] getTextures(){
		refTextures= new String[8];
		
		refTextures[1]="./images/bois.png";
		refTextures[2]="./images/bois2.png";
		
		refTextures[3]="./images/brique.png";
		refTextures[4]="./images/pierre.png";
		
		return refTextures;
	}
	
	@Override
	public APoint barycenter() {
		APoint p = new APoint(this.x+25.0,this.y+25.0);	
		return p;
	}

	//start of gravity================== not finished !
	
	public void gravityAction2(int deltaTime) {
		
		this.time += deltaTime ;
		int realTime = (int)(time/60);
		
		this.dy  += this.GRAVITY * realTime ; //so as to get the right number of image per second	
		this.y += this.dy ;
				
			for (int i = 0;  i < Terrain.getlistMateriaux().size() ; ++i) {
					
					if(this != Terrain.getlistMateriaux().get(i) &&  this.x == Terrain.getlistMateriaux().get(i).x && this.getDistance(Terrain.getlistMateriaux().get(i).x,Terrain.getlistMateriaux().get(i).y) <= 50.0 ){
						this.y = Terrain.getlistMateriaux().get(i).y-50.0;
						this.dy = 0;
						break;
					}
					if (this.y + 50.0 > Panneau.getGround() ) {
						this.y = Panneau.getGround() - 50.0;
						this.dy = 0;
						break;
					}
					
			
			}
				
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
	}
	
	//Computation of the collision projectile-blocks
	
	public void destruction() {
		double dist ;
		 
		dist = Panneau.getProj().getDistance(this.barycenter().x, this.barycenter().y);

		if(dist <= 25.0 + Panneau.getProj().getRayon()) {
			Terrain.listMateriaux.remove(this);
			
			Panneau.getProj().couleur = Color.green ;
			System.out.println(dist + " la distance entre le projectile et l'objet ");
		
		}
	}
		
	

}
