import java.awt.Toolkit;

public class Terrain3  extends Terrain{
	
	public Terrain3() {
		super();
		
		this.GRAVITY = (double)(this.GRAVITY*0.38) ;
		this.level = 3;
		
		this.picGround = Toolkit.getDefaultToolkit().getImage("./images/GroundWorld/ground_mars.png");
		this.arrayOriginalMaterial = new Material [14];
		this.arrayOriginalEnemies = new Enemy [6];
		
		//To remove all blocks from before
		listEnemies.clear();
		listMaterials.clear();
		
		//Creation of the blocks with coordinates and parameters (x , y , resistance, textures, mass)
		
		arrayOriginalMaterial[0] = new Material(640.0,400.0,1,3, 3);
		arrayOriginalMaterial[1] = new Material(650.0,300.0,1,3, 3);
		arrayOriginalMaterial[2] = new Material(760.0,400.0,1,3 , 3);
		arrayOriginalMaterial[3] = new Material(750.0,300.0,2,3 , 3);
		arrayOriginalMaterial[4] = new Material(700.0,600.0,3,3 , 3);
		arrayOriginalMaterial[5] = new Material(700.0,650.0,1,3, 3);
		
		arrayOriginalMaterial[6] = new Material(600.0,600.0,1,4, 4);
		arrayOriginalMaterial[7] = new Material(610.0,550.0,1,4 , 4);
		arrayOriginalMaterial[8] = new Material(620.0,500.0,2,4 , 4);
		arrayOriginalMaterial[9] = new Material(630.0,450.0,3,4 , 4);
		
		arrayOriginalMaterial[10]= new Material(770.0,450.0,1,4 , 4);
		arrayOriginalMaterial[11]= new Material(780.0,500.0,2,4 , 4);
		arrayOriginalMaterial[12]= new Material(790.0,550.0,3,4 , 4);
		arrayOriginalMaterial[13]= new Material(800.0,600.0,3,4 , 4);
		
		//Fill the list use to display the blocks
		for(int i=0 ; i <14 ; ++i) {
			listMaterials.add(arrayOriginalMaterial[i]);
		}
		
		// Creation of the enemies with (x, y, life, texture) 
		
		arrayOriginalEnemies[0] = new Enemy (650.0,300.0,1,4);
		arrayOriginalEnemies[1] = new Enemy (650.0,600.0,1,4);
		arrayOriginalEnemies[2] = new Enemy (750.0,600.0,1,4);
		arrayOriginalEnemies[3] = new Enemy (700.0,600.0,1,2);
		arrayOriginalEnemies[4] = new Enemy (750.0,300.0,1,2);
		arrayOriginalEnemies[5] = new Enemy (900.0,600.0,1,2);
		
		//Fill the list use to display the enemies
		for(int j=0 ; j <6 ; ++j) {
			listEnemies.add(arrayOriginalEnemies[j]);
		}
		
	}

}