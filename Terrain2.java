import java.awt.Toolkit;

public class Terrain2  extends Terrain{

	public Terrain2() {
		super();
		
		this.GRAVITY = 20.0 ;
		this.level = 2;
		
		this.picGround = Toolkit.getDefaultToolkit().getImage("./images/GroundWorld/ground_moon.png");
		this.arrayOriginalMaterial = new Matériaux [8];
		this.arrayOriginalEnemies = new Enemy [4];
		
		//To remove all blocks from before
		listEnemies.clear();
		listMaterials.clear();
		
		//Creation of the blocks with coordinates and parameters (x , y , resistance, textures, mass)

		arrayOriginalMaterial[0] = new Matériaux(750.0,650.0,1,1, 1);
		arrayOriginalMaterial[1] = new Matériaux(750.0,600.0,1,1, 1);
		arrayOriginalMaterial[2]= new Matériaux(700.0,500.0,2,3 ,2);
		arrayOriginalMaterial[3] = new Matériaux(700.0,550.0,2,3 , 2);
		arrayOriginalMaterial[4] = new Matériaux(700.0,600.0,3,3 , 2);
		arrayOriginalMaterial[5] = new Matériaux(700.0,650.0,1,3, 2);
		arrayOriginalMaterial[6] = new Matériaux(800.0,650.0,2,4, 2);
		arrayOriginalMaterial[7]= new Matériaux(900.0,650.0,2,4 , 2);
		
		//Fill the list use to display the blocks
		for(int i=0 ; i <8 ; ++i) {
			listMaterials.add(arrayOriginalMaterial[i]);
		}
		
		// Creation of the enemies with (x, y, life, texture) 
		
		arrayOriginalEnemies[0] = new Enemy (850.0,500.0,1,1);
		arrayOriginalEnemies[1] = new Enemy (950.0,500.0,1,1);
		arrayOriginalEnemies[2] = new Enemy (750.0,500.0,1,5);
		arrayOriginalEnemies[3] = new Enemy (900.0,500.0,1,5);
		
		//Fill the list use to display the enemies
		for(int j=0 ; j <4 ; ++j) {
			listEnemies.add(arrayOriginalEnemies[j]);
		}
	}

}
