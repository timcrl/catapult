
import java.awt.Color;
import java.awt.Graphics;

public class Cercle {

	// Les attributs
	public APoint centre;
	public double rayon;
	public Color maCouleur;
	public double [] velocity;
	
	


	/**
	 * Le constructeur
	 * @param le centre, le rayon et la couleur
	 */ 
	public Cercle(APoint c, double r,Color maCouleur){
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
        g.fillOval((int)(centre.x)-(int)rayon,(int)(centre.y)-(int)rayon,(int)(2*rayon),(int)(2*rayon));
	}
	

}

