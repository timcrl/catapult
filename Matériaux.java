import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Matériaux extends Object { //incorporer les résistances dans les matériaux etc...
	
	public static String[] refTextures= getTextures();
	protected double resistance ;
	protected String texture ;
	protected Image img ;
	protected double x;
	protected double y;
	protected double centreX;
	protected double centreY;
	protected boolean stable = false ;
	
	public Matériaux (double x1, double y1, double resist, int refTexture) {
		super();
		this.x = x1 ;
		this.y = y1;
		this.resistance = resist ;
		
		APoint p = this.barycenter();
		this.centreX = p.x;
		this.centreY = p.y;
		
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
	
	public void dessiner ( Graphics g ) {
		
	}
	
	public void action () {
		
	}
	
	//méthodes ajoutées par héritance à voir plus tard si utiles ou non
	@Override
	public APoint barycenter() {
		APoint p = new APoint(this.x+25.0,this.y+25.0);
		return p;
	}

	@Override
	public double[] force() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public double getDistance (double x1, double y1) {
		double xDist = x1-this.x;
		double yDist = y1-this.y;
		
		return Math.sqrt((Math.pow(xDist, 2)+Math.pow(yDist, 2)));
		
	}
	public double getDistanceY (double y1) {
		
		double yDist = y1 - this.y;
		
		return yDist;
		
	}
	
	//début de gravité==================pas au point !!!!!!!
	public void gravityAction(){
		
		
		if(!this.stable) {
			if (this.y + 50.0 < 670.0 ) {
				this.y += this.GRAVITY ;
			} 
			else if(this.getDistanceY(this.y + this.GRAVITY) >= (670.0 - (this.y + 50.0))){
				this.y = 620.0 ;
				this.stable = true ;
				Terrain.listStable.add(this);
			}
			for (Matériaux m : Terrain.getListStable()) {
				System.out.println(this + " it's me");
				if(this != m) {
					//System.out.println(this + " it's me");
					if(this.y + 50.0 < m.y) {
						this.y += this.GRAVITY;
					}
					if(this.getDistance(m.x,m.y) <= 50.0 ){
						this.y = m.y-50.0;
						this.stable = true;
						Terrain.listStable.add(this);

					}
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
