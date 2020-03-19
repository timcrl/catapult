

public class Terrain {
	
	//taille du tableau de coordonnées à revoir 
	
	public static int[][] itemCoords = new int[50][50];
	
	public Terrain() {
		
		//remplissage des coordonnées des items, à droite la valeur correspond à la texture
		
		for(int i=0; i<itemCoords.length; i++){
			this.itemCoords[26][22]=1;
			this.itemCoords[26][24]=4;
			this.itemCoords[30][26]=3;
			this.itemCoords[26][26]=4;
			
		}
	}

}
