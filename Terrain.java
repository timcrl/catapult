

public class Terrain {
	
	//taille du tableau de coordonnées à revoir 
	//faudrait calculer la position exacte des objets 
	
	public static int[][] itemCoords = new int[50][50];
	
	public Terrain() {
		
		//remplissage des coordonnées des items, à droite la valeur correspond à la texture
		
		for(int i=0; i<itemCoords.length; i++){
			this.itemCoords[26][22]=1; //mettez pas 50 ça ne marche pas, faudra qu'on règle des problèmes ici
			this.itemCoords[26][24]=4;
			this.itemCoords[30][26]=3;
			this.itemCoords[26][26]=4;
			
		}
	}

}
