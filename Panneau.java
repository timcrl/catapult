import java.awt.event.*;
import java.util.Iterator;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.html.parser.Element;

public class Panneau extends JPanel implements ActionListener, MouseMotionListener {

	private Terrain ter = new Terrain();
	private final double GRAVITY = 2.0 ;
	private static Projectile proj;
	private Cercle c1;
	private APoint p = new APoint (50,50);

	private static double limite_sol=0.2;
	private double dist ;
	private double dist2 ;
	private double angle = 30.0;
	private long temps;


	public Panneau(){

		proj = new Projectile(p,5.0, 5.0, 30.0 ,Color.black );
		proj.setPosition(100, 400);
		proj.setSpeed(10, 45);
		c1 = new Cercle(new APoint(600,600),15.0,Color.red);

		this.setLayout(null);
		addMouseMotionListener(this);
	}

	public static Projectile getProj() {
		return proj;
	}
	public static double getGround() {
		return limite_sol;
	}


	public void paintComponent(Graphics g){

		Image fond = Toolkit.getDefaultToolkit().getImage("./images/image_fond_nuage.png");
					g.drawImage(fond, 0, 0, this.getWidth(), this.getHeight(), this);
		//Image bottom = Toolkit.getDefaultToolkit().getImage("./images/terre2.png");
		//g.drawImage(bottom, 0, 750, this.getWidth(),this.getHeight(), this);

		g.setColor(Color.green);
		g.fillRect(0,(int)((1-limite_sol)*this.getHeight()),this.getWidth(),(int)((limite_sol)*this.getHeight()));

		/*===================== Affichage objets*/

		proj.dessiner(g);
		c1.dessine(g);

		for (Ennemy perso1 : ter.listEnnemies) {
			g.drawImage(perso1.img, (int)perso1.x, (int)perso1.y,this); //affichage alien
			perso1.gravityAction(17);

		}

		//=================================
		//affichage des matériaux et leurs textures en parcourant la liste

		for (Matériaux element : ter.listMateriaux) {
			g.drawImage(element.img, (int)element.x,(int)element.y, this);


			//=============gravity
			element.gravityAction(17);
			System.out.println(element.y + " my position ");
			System.out.println((double)(this.getHeight()*(1-limite_sol)));

		}

		//============CALCUL COLLISION===========
		this.collisionDetect();

		//===============
		Toolkit.getDefaultToolkit().sync();

		}



	//============CALCUL COLLISION=========== (juste changement de couleur pour l'instant et disparition case)
	public void collisionDetect() {

		dist = proj.getDistance(c1.centre.x, c1.centre.y);
		System.out.println(dist + " la distance entre les 2 cercles ");

		//juste pour checker et s'amuser avec le drag
		if(dist <= c1.rayon + proj.getRayon()) {
			proj.couleur = c1.maCouleur ;
		}

		//parcourt toute la liste de matériaux et les fait disparaître à la rencontre du projectile
		//for loop with i to modify the list
		for (int i = 0; i < ter.listMateriaux.size(); i++) {
			
			dist2 = proj.getDistance(ter.listMateriaux.get(i).centreX, ter.listMateriaux.get(i).centreY);

			if(dist2 <= 25.0 + proj.getRayon()) {
				ter.listMateriaux.get(i).stable = false;
				Terrain.listStable.remove(ter.listMateriaux.get(i));
				ter.listMateriaux.remove(ter.listMateriaux.get(i));
				
				proj.couleur = Color.green ;
				System.out.println(dist2 + " la distance entre le projectile et l'objet ");
				//repaint(); No need to be repaint it is in the paint method 
			}
		}



		//========Limite de la fenêtre
		if(proj.x - proj.getRayon() <= 0 || proj.x + proj.getRayon() >= this.getWidth() ) {
			proj.dx = - proj.dx ;
		}
		if(proj.y - proj.getRayon() <= 0 || proj.y + proj.getRayon() >= (this.getHeight()-Panneau.limite_sol*this.getHeight()) ) {
			proj.dy = - proj.dy ;
		}


	}

	public void actionPerformed(ActionEvent e){

	}

	//==========================
	//méthode pour bouger le cercle rouge
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		c1 = new Cercle(new APoint(e.getX(),e.getY()),15,Color.red);

	}

	//méthode détectant le contact projectile avec la souris et changeant la couleur
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(proj.getDistance(e.getX(), e.getY()) <= 15.0) {
			System.out.println("The mouse has collided");
			proj.couleur = new Color(50, 50, 50);
		}

	}


	}
