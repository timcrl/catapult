import java.util.LinkedList;

public class Terrain {
	
	private final double GRAVITY = 9.8 ;
	LinkedList <Matériaux> listMateriaux = new LinkedList<Matériaux>();
	static LinkedList <Matériaux> listStable = new LinkedList<Matériaux>();
	
	
	public Terrain() {
		
		//remplissage des coordonnées des items, tel que (x , y , resistance, textures)
		
		Matériaux m1 = new Matériaux(800.0,100.0,1,1);
		Matériaux m2 = new Matériaux(800.0,300.0,1,2);
		Matériaux m3 = new Matériaux(800.0,500.0,2,3);
		Matériaux m4 = new Matériaux(800.0,600.0,3,4);
		
		listMateriaux.add(m1);
		listMateriaux.add(m2);
		listMateriaux.add(m3);
		listMateriaux.add(m4);
	}
	
	public static LinkedList<Matériaux> getListStable(){
		return listStable;
	}

}
