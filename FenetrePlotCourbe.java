/**
 * La fenêtre pour faire des dessins
 * 
 */

// Chargement des bibliothèques Swing et AWT
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList; 

public class FenetrePlotCourbe extends JFrame implements ActionListener{
	
	// Les Widgets à déclarer en dehors du constructeur
	private LinkedList<Cercle> mesCercle;
    private Timer monChrono;
    private int temps;
    private static int DELTA_T = 9;
    public double dt = 0.09;
    public double limite_sol=0.80;
	
	/**
	 * Le constructeur qui rend la fenêtre non visible à sa création
	 */	
	public FenetrePlotCourbe(LinkedList<Cercle> mesCercle){
		this.mesCercle = mesCercle;
		this.setTitle("IHM Courbe - Graphisme ");
		this.setLayout(null);
		this.setSize(1400,800);
		this.setLocation(700,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Pour empêcher le redimensionnement de la fenêtre
		this.setResizable(true);
		// Pour cacher la fenêtre à sa création
		this.setVisible(true);
        
        // Création du chronomètre
        monChrono = new Timer(DELTA_T,this);
        // Initialisation de la variable temps
        temps = 0;
        
		
	}

	/**
	 * Pour faire des dessins simples
	 * @param l'objet graphics
	 */ 
	public void paint(Graphics g){
		//On remplit le background
		g.setColor(Color.blue);
		g.fillRect(0,0,this.getWidth(),(int)(limite_sol*this.getHeight()));
		g.setColor(Color.cyan);
		g.fillRect(0,(int)(limite_sol*this.getHeight()),this.getWidth(),(int)((1-limite_sol)*this.getHeight()));

		if (!mesCercle.isEmpty())
			for (int i = 0;i<mesCercle.size();i++){
				g.setColor(mesCercle.get(i).maCouleur);
				mesCercle.get(i).dessine(g);
			}
	}
	
	
	/**
	 * Méthode exécutée à chaque réveil du Timer
	 */
	public void actionPerformed(ActionEvent e){
        temps+=DELTA_T;

		this.setTitle("IHM Courbe - Graphisme / temps : "+temps);
        if (mesCercle!=null)
			for (int i = 0;i<mesCercle.size();i++){
				if(limite_sol*this.getHeight()-mesCercle.get(i).centre.y-mesCercle.get(i).rayon>=0 ){
				mesCercle.get(i).centre.y+=dt*mesCercle.get(i).velocity[1];
				mesCercle.get(i).velocity[1]+=dt*10;
				mesCercle.get(i).centre.x+=dt*mesCercle.get(i).velocity[0];
				}
				else {
					mesCercle.get(i).centre.y-=0.1;
					mesCercle.get(i).velocity[1]=-mesCercle.get(i).velocity[1];
					
				}	
			}
		repaint();
	}
    
    /**
     * Méthode exécutée lorsque l'utilisateur a appuyé sur le bouton "Afficher"
     * Elle lance simplement le Timer et donc la méthode actionPerformed
     */ 
    public void lancement(){
        monChrono.start();
    }
	
	
}
