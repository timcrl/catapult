import java.awt.Color;
import java.awt.Graphics;

public class Matériaux { //incorporer les résistances dans les matériaux etc...
	
	public static String[] refTextures= getTextures();
	protected double resistance ;
	protected Color maCouleur ;
	
	public Matériaux (double resist) {
		resistance = resist ;
		
	}
	
	// méthode attribuant une texture à une valeur
	private  static String[] getTextures(){
		refTextures= new String[8];
		
		refTextures[1]="./images/bois.png";
		refTextures[2]="./images/bois2.jpg";
		
		refTextures[3]="./images/brique.png";
		refTextures[4]="./images/pierre.png";
		
		return refTextures;
	}
	
	public void dessiner ( Graphics g ) {
		
	}
	
	public void action () {
		
	}
	

}
