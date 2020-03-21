import java.util.LinkedList;

public class Terrain {
	
	
	LinkedList <Matériaux> listMateriaux= new LinkedList<Matériaux>();
	
	public Terrain() {
		
		//remplissage des coordonnées des items, tel que (x , y , resistance, textures)
		
		Matériaux m1 = new Matériaux(300.0,600.0,1,1);
		Matériaux m2 = new Matériaux(500.0,600.0,1,2);
		Matériaux m3 = new Matériaux(600.0,600.0,2,3);
		Matériaux m4 = new Matériaux(800.0,600.0,3,4);
		
		listMateriaux.add(m1);
		listMateriaux.add(m2);
		listMateriaux.add(m3);
		listMateriaux.add(m4);

		
	}

}
