import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.LinkedList;

public class Terrain {

	public Image picGround = Toolkit.getDefaultToolkit().getImage("./images/GroundWorld/ground_earth.png");
	protected double GRAVITY ;

	//Lists used for the display of the elements (often called, addition or destruction of blocks)
	static LinkedList <Material> listMaterials = new LinkedList<Material>();
	static LinkedList <Enemy> listEnemies = new LinkedList<Enemy>();

	//Arrays containing the basic elements so as to declare them easily  and reduce the code
	protected Material [] arrayOriginalMaterial ;
	protected Enemy [] arrayOriginalEnemies;

	protected static int score ;
	protected  int level ; // will tell the current level played for the other classes

	public Terrain() {

		this.GRAVITY = 9.8 ;
		this.level = 1 ;

		//To remove all blocks from before (if a game is replayed for instance) (like emptying the cache)
		listEnemies.clear();
		listMaterials.clear();

		this.arrayOriginalMaterial = new Material [5];
		this.arrayOriginalEnemies = new Enemy [2];

		//Creation of the blocks with coordinates and parameters (x , y , resistance, textures, mass)

		arrayOriginalMaterial[0] = new Material(830.0,400.0,1,1, 1.0);
		arrayOriginalMaterial[1] = new Material(770.0,450.0,1,1 , 2.0);
		arrayOriginalMaterial[2]= new Material(800.0,520.0,1,2, 1.0);
		arrayOriginalMaterial[3] = new Material(800.0,575.0,2,2 , 2.0);
		arrayOriginalMaterial[4] = new Material(800.0,600.0,3,2, 2.0);

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
			listEnemies.add(arrayOriginalEnemies[j]);
			arrayOriginalEnemies[j] = null;

		}
	}


	public LinkedList <Enemy> getListEnnemies(){
		return listEnemies;
	}
	public static LinkedList<Material>  getlistMateriaux() {
		return listMaterials ;
	}
	public double getGravity() {
		return this.GRAVITY;
	}
	public int getLevelNumber() {
		return this.level;
	}

	public static boolean victory() {
		boolean vic = false ;

		if(listEnemies.isEmpty()) {
			vic = true;
		}
		return vic;
	}

	public static void computeScore (Object destroyed) {
		score += destroyed.scoreValor;
	}
	public static void resetScore() {
		score = 0 ;
	}

}
