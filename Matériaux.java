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
			
		//trouve la texture correspondante
		for (int i = 0; i < refTextures.length; i++) {
			if(i == refTexture) {
				this.texture = refTextures[i];
			}
		}
		this.img = Toolkit.getDefaultToolkit().getImage(this.texture); //intégration directe de l'image dans le matériaux plus simple
		
	}
	
	/* méthode attribuant une texture à une valeur
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
	
	//méthodes ajoutées par héritance à voir plus tard si utiles ou non
	@Override
	public APoint barycenter() {
		APoint p = new APoint(this.x+25.0,this.y+25.0);	
		return p;
	}
	
	//début de gravité==================pas au point !!!!!!!
	//
	public void gravityAction(int deltaTime){
		
		this.time += deltaTime ;
		int realTime = (int)(time/60);
		
		this.dy += this.GRAVITY * realTime ;
		
		if(!this.stable) {
			if (this.y + 50.0 < 670.0 ) {
				this.y += this.dy*realTime ;
			} 
			else if(this.getDistanceY(this.y + (this.dy*realTime)) >= (670.0 - (this.y + 50.0))){
				this.y = 620.0 ;
				this.stable = true ;
				Terrain.listStable.add(this);
			}
			//change of iteration, using i because we can modify the list while iterating it
			
			for (int i = 0; i < Terrain.getListStable().size(); i++) {
				
				if(this != Terrain.getListStable().get(i)) {
					if(this.y + 50.0 < Terrain.getListStable().get(i).y) {
						this.y += this.dy*realTime;
					}
					if(this.getDistance(Terrain.getListStable().get(i).x,Terrain.getListStable().get(i).y) <= 50.0 ){
						this.y = Terrain.getListStable().get(i).y-50.0;
						this.stable = true;
						Terrain.listStable.add(this);

					}
				}
			}
		
			
		try {
				Thread.sleep(17);
			  } catch (InterruptedException e) {
				e.printStackTrace();
			  }
		
		}
	}
	
	//calcul collision projectile et blocs
	
	public void destruction() {
		double dist ;
		 
		dist = Panneau.getProj().getDistance(this.barycenter().x, this.barycenter().y);

		if(dist <= 25.0 + Panneau.getProj().getRayon()) {
			Terrain.listStable.remove(this);
			Terrain.listMateriaux.remove(this);
			
			Panneau.getProj().couleur = Color.green ;
			System.out.println(dist + " la distance entre le projectile et l'objet ");
		
		}
	}
		
	

}
