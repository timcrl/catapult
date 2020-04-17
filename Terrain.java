import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.LinkedList;

public class Terrain {
	
	public static Image picGround = Toolkit.getDefaultToolkit().getImage("./images/GroundWorld/ground_earth.png");
	static LinkedList <Matériaux> listMateriaux = new LinkedList<Matériaux>();
	static LinkedList <Ennemy> listEnnemies = new LinkedList<Ennemy>();
	
	protected static int score ;
	
	public Terrain() {
		
		//Fill of the coordinates and parameters (x , y , resistance, textures)
		
		Matériaux m0 = new Matériaux(825.0,0.0,1,2, 1);
		Matériaux m1 = new Matériaux(800.0,300.0,1,1, 1);
		Matériaux m2 = new Matériaux(780.0,400.0,1,2 , 2);
		Matériaux m3 = new Matériaux(800.0,500.0,2,3 , 2);
		Matériaux m4 = new Matériaux(800.0,600.0,3,4 , 2);
		
		listMateriaux.add(m0);
		listMateriaux.add(m1);
		listMateriaux.add(m2);
		listMateriaux.add(m3);
		listMateriaux.add(m4);
		
		Ennemy perso1 = new Ennemy (750.0,50.0,1,3);
		Ennemy perso2 = new Ennemy (90.0,50.0,1,2);
		
		listEnnemies.add(perso1);
		listEnnemies.add(perso2);
	}
	
	public LinkedList <Ennemy> getListEnnemies(){
		return listEnnemies;
	}
	public static LinkedList<Matériaux>  getlistMateriaux() {
		return listMateriaux ;
	}
	
	public static boolean victory() {
		boolean vic = false ;
		
		if(listEnnemies.isEmpty()) {
			vic = true;
			System.out.println("You have won !");
		}
		return vic;
	}

	public static void computeScore (Object destroyed) {
		score += destroyed.scoreValor;
	}

}
