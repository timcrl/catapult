
import java.awt.Color;
import java.awt.Graphics;

public class Cercle{

	// Les attributs
	public APoint centre;
	public int rayon;
	public Color maCouleur;
	public double [] velocity;
	
	


	/**
	 * Le constructeur
	 * @param le centre, le rayon et la couleur
	 */ 
	public Cercle(APoint c, int r,Color maCouleur){
		centre = new APoint(c.x,c.y);
		rayon = r;
		this.maCouleur = maCouleur;
	}
	
	
	/**
	 * Pour dessiner la figure courante
	 * @param l'objet graphique où dessiner
	 */ 
	public void dessine(Graphics g){
        // Appel à la méthode de l'ancêtre
        g.setColor(maCouleur);
        // Pour dessiner un cercle
        g.fillOval((int)(centre.x)-rayon,(int)(centre.y)-rayon,2*rayon,2*rayon);
	}
	

}

