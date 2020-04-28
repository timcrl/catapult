import java.awt.event.*;
import java.util.Iterator;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.html.parser.Element;

public class Panneau extends JPanel implements ActionListener, MouseMotionListener {

	private Terrain ter ;
	private final double GRAVITY = 2.0 ;
	private static Projectile proj;
	private Thrower slingshot;
	private Cercle c1;
	private APoint p = new APoint (50,50);
	
	private double dist ; //for collision here but will be useless soon
	private double angle = 30.0;
	private long temps;


	public Panneau(Terrain planete){
		
		this.ter = planete; 
		proj = new Projectile(p,5.0, 5.0, 30.0 ,Color.black );
		proj.setPosition(100, 300);
		proj.setSpeed(0, 0);

		c1 = new Cercle(new APoint(600,600),15.0,Color.red);
		
		slingshot = new Thrower(proj, 100, 600);
		
		this.setLayout(null);
		addMouseMotionListener(this);
	}

	public static Projectile getProj() {
		return proj;
	}
	public static double getGround() {
		return 700;
	}

	public void paintComponent(Graphics g){

	    Image background = ter.picGround ;
		g.drawImage(background, 0, 0, null);
					
		/*===================== Objects Display*/

		proj.dessiner(g);
		slingshot.dessiner(g);
		//c1.dessine(g);

		//=============Aliens Display====================
		for (int i = 0; i < Terrain.listEnemies.size(); i++) {
			Enemy perso1 = Terrain.listEnemies.get(i); //local variable to avoid too much code
			g.drawImage(perso1.img, (int)perso1.x, (int)perso1.y,this); 
			perso1.gravityAction();
			perso1.death();
		}
		//=============Material Blocks Display====================

		for (int i = 0; i < Terrain.listMaterials.size(); i++) {

			g.drawImage(Terrain.listMaterials.get(i).img, (int)Terrain.listMaterials.get(i).x,(int)Terrain.listMaterials.get(i).y, this);

			Terrain.listMaterials.get(i).gravityAction();
			Terrain.listMaterials.get(i).destruction();
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
