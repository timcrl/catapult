import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.LinkedList;

public class Terrain {
	
	public Image picGround = Toolkit.getDefaultToolkit().getImage("./images/GroundWorld/ground_earth.png");
	protected double GRAVITY ;
	
	static LinkedList <Matériaux> listMaterials = new LinkedList<Matériaux>();
	static LinkedList <Enemy> listEnemies = new LinkedList<Enemy>();
	
	//Arrays containing the basic elements so as to declare them and reduce the code
	protected Matériaux [] arrayOriginalMaterial ;
	protected Enemy [] arrayOriginalEnemies;
	
	protected static int score ;
	
	public Terrain() {
		
		this.GRAVITY = 9.8 ;
		this.arrayOriginalMaterial = new Matériaux [5];
		this.arrayOriginalEnemies = new Enemy [2];
		
		//Creation of the blocks with coordinates and parameters (x , y , resistance, textures, mass)
				
		arrayOriginalMaterial[0] = new Matériaux(830.0,400.0,1,1, 1);
		arrayOriginalMaterial[1] = new Matériaux(770.0,450.0,1,1 , 2);
		arrayOriginalMaterial[2]= new Matériaux(800.0,520.0,1,2, 1);
		arrayOriginalMaterial[3] = new Matériaux(800.0,575.0,2,2 , 2);
		arrayOriginalMaterial[4] = new Matériaux(800.0,600.0,3,2, 2);
		
		//Fill the list use to display the blocks
		for(int i=0 ; i <5 ; ++i) {
			listMaterials.add(arrayOriginalMaterial[i]);
			arrayOriginalMaterial[i] = null;
		}
		
		// Creation of the enemies with (x, y, life, texture) 
		
		arrayOriginalEnemies[0] = new Enemy (850.0,300.0,1,1);
		arrayOriginalEnemies[1] = new Enemy (800.0,300.0,1,3);
		
		//Fill the list use to display the enemies
		for(int j=0 ; j <2 ; ++j) {
			//listEnemies.add(arrayOriginalEnemies[j]);
			listEnemies.add(new Enemy(25.0,600.0,1,1));
			arrayOriginalEnemies[j] = null;

		}
	}

	
	public LinkedList <Enemy> getListEnnemies(){
		return listEnemies;
	}
	public static LinkedList<Matériaux>  getlistMateriaux() {
		return listMaterials ;
	}
	public double getGravity() {
		return this.GRAVITY;
	}
	
	public static boolean victory() {
		boolean vic = false ;
		
		if(listEnemies.isEmpty()) {
			vic = true;
			System.out.println("You have won !");
		}
		return vic;
	}

	public static void computeScore (Object destroyed) {
		score += destroyed.scoreValor;
	}

}
