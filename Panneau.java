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
	
	private double dist ; //for collision here but will be useless soon
	private double angle = 30.0;
	private long temps;


	public Panneau(){

		proj = new Projectile(p,5.0, 5.0, 30.0 ,Color.black );
		proj.setPosition(100, 300);
		proj.setSpeed(0, 45);

		c1 = new Cercle(new APoint(600,600),15.0,Color.red);

		this.setLayout(null);
		addMouseMotionListener(this);
	}

	public static Projectile getProj() {
		return proj;
	}
	public static double getGround() {
		return 660;
	}

	public void paintComponent(Graphics g){

		Image fond = Toolkit.getDefaultToolkit().getImage("./images/image_fond_nuage.png");
					g.drawImage(fond, 0, 0, this.getWidth(), this.getHeight(), this);
		//Image bottom = Toolkit.getDefaultToolkit().getImage("./images/terre2.png");
		//g.drawImage(bottom, 0, 750, this.getWidth(),this.getHeight(), this);

		g.setColor(Color.green);
		g.fillRect(0,(int)Panneau.getGround(),this.getWidth(),this.getHeight());

		/*===================== Objects Display*/

		proj.dessiner(g);
		c1.dessine(g);

		
		for (int i = 0; i < Terrain.listEnnemies.size(); i++) {
			Ennemy perso1 = Terrain.listEnnemies.get(i); //local variable to avoid to much code
			g.drawImage(perso1.img, (int)perso1.x, (int)perso1.y,this); //affichage alien
			perso1.gravityAction(17);
			perso1.death();

		}

		//=================================
		//affichage des matériaux et leurs textures en parcourant la liste
	
		//=============Material Blocks Display====================

		for (int i = 0; i < Terrain.listMateriaux.size(); i++) {

			g.drawImage(Terrain.listMateriaux.get(i).img, (int)Terrain.listMateriaux.get(i).x,(int)Terrain.listMateriaux.get(i).y, this);

			//=============gravity
			Terrain.listMateriaux.get(i).gravityAction2(17);
			//System.out.println(Terrain.listMateriaux.get(i).y + " my position ");
			//System.out.println((double)(this.getHeight()*(1-limite_sol)));
			Terrain.listMateriaux.get(i).destruction();
			//System.out.println("My position en y" + Terrain.listMateriaux.get(i).y + "Mon centre x et y " + Terrain.listMateriaux.get(i).centreX +"||"+ Terrain.listMateriaux.get(i).centreY);

		}

		//============CALCUL COLLISION===========
		//this.collisionDetect(); // Replaced by bounce in the projectile class
		
		//============ Collision Computation Call===========
		//this.collisionDetect();
		//===============
		Toolkit.getDefaultToolkit().sync();

		}



	//============CALCUL COLLISION=========== (juste changement de couleur pour l'instant et disparition case)
	 // Bouncer from Seb, Disabled by Tim (no offence xD)
	public void collisionDetect() {

		dist = proj.getDistance(c1.centre.x, c1.centre.y);
		//System.out.println(dist + " la distance entre les 2 cercles ");

		//juste pour checker et s'amuser avec le drag
		if(dist <= c1.rayon + proj.getRayon()) {
			proj.couleur = c1.maCouleur ;
		}

		//========Limite de la fenêtre
		if(proj.x - proj.getRayon() <= 0 || proj.x + proj.getRayon() >= this.getWidth() ) {
			proj.dx = - proj.dx ;
		}
		if(proj.y - proj.getRayon() <= 0 || proj.y + proj.getRayon() >= (this.getHeight()-this.getGround()*this.getHeight()) ) {
			proj.dy = - proj.dy ;
		}

	}

	public void actionPerformed(ActionEvent e){

	}

	//To drag the red cercle
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		c1 = new Cercle(new APoint(e.getX(),e.getY()),15,Color.red);

	}

	//Detect collision between the mouse and the projectile
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(proj.getDistance(e.getX(), e.getY()) <= 15.0) {
			System.out.println("The mouse has collided");
			proj.couleur = new Color(50, 50, 50);
		}

	}


	}
