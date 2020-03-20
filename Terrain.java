import java.util.LinkedList;

public class Terrain {
	
	
	LinkedList <Matériaux> listMateriaux= new LinkedList<Matériaux>();
	
	public Terrain() {
		
		//remplissage des coordonnées des items, à droite la valeur correspond à la texture
		
		Matériaux m1 = new Matériaux(500.0,500.0,1,1);
		Matériaux m2 = new Matériaux(500.0,550.0,1,2);
		Matériaux m3 = new Matériaux(500.0,600.0,2,3);
		Matériaux m4 = new Matériaux(500.0,650.0,3,4);
		
		listMateriaux.add(m1);
		listMateriaux.add(m2);
		listMateriaux.add(m3);
		listMateriaux.add(m4);

		
	}

}
