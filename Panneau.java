import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Panneau extends JPanel implements ActionListener, MouseMotionListener {

	private Terrain ter = new Terrain();
	private final double GRAVITY = 9.8 ;
	private Projectile proj;
	private Cercle c1;
	private APoint p = new APoint (50,600);
	private double limite_sol=0.2;
	private double dist ;
	private double dist2 ;
	private double angle = 30.0;

	//ce timer reprend exactement le même que dans fenêtre donc modif dans fenêtre si besoin
	private long temps;
	private int interval = 20;
	Timer monChrono ;


	public Panneau(Timer timer){

		monChrono=timer;
		proj = new Projectile(p,20.0, 20.0, 30.0 ,Color.black );
    proj.setPosition(10, 10);
		c1 = new Cercle(new APoint(600,600),15.0,Color.red);
		addMouseMotionListener(this);
	}

	public Projectile getProj() {
		return proj;
	}

	public void paintComponent(Graphics g){
		//remplissage ciel
		//g.setColor(Color.cyan);
		//g.fillRect(0,0,getWidth(),getHeight());

		Image fond = Toolkit.getDefaultToolkit().getImage("./images/image_fond_nuage.png");
					g.drawImage(fond, 0, 0, this.getWidth(), this.getHeight(), this);
		//Image bottom = Toolkit.getDefaultToolkit().getImage("./images/terre2.png");
		//g.drawImage(bottom, 0, 750, this.getWidth(),this.getHeight(), this);

		g.setColor(Color.green);
		g.fillRect(0,(int)((1-limite_sol)*this.getHeight()),this.getWidth(),(int)((limite_sol)*this.getHeight()));

		/*===================== Affichage objets*/

		proj.dessiner(g);
		c1.dessine(g);

		/*=================================*/
		//affichage des matériaux et leurs textures en parcourant la liste

		for (Matériaux element : ter.listMateriaux) {
			g.drawImage(element.img, (int)element.x,(int)element.y, this);

		}

		//============CALCUL COLLISION===========
		this.collisionDetect();

		//==========================

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

		for (Matériaux element : ter.listMateriaux) {
			dist2 = proj.getDistance(element.centreX, element.centreY);

			if(dist2 <= 25.0 + proj.getRayon()) {
				element.img = null;
				proj.couleur = Color.green ;
				System.out.println(dist2 + " la distance entre le projectile et l'objet ");
			}
		}



		//========Limite de la fenêtre
		if(proj.x - proj.getRayon() <= 0 || proj.x + proj.getRayon() >= this.getWidth() ) {
			proj.dx = - proj.dx ;
		}
		if(proj.y - proj.getRayon() <= 0 || proj.y + proj.getRayon() >= (this.getHeight()-this.limite_sol*this.getHeight()) ) {
			proj.dy = - proj.dy ;
		}


	}

	public void gravityAction(long time){
		this.temps = time;

		for (Matériaux element : ter.listMateriaux) {

			if(element.y + 40.0 <= (double)(this.getHeight()*(1-limite_sol))) {

				for (Matériaux m : ter.listMateriaux) {
					if(element != m && element.getDistance(m.x, m.y) > 100.0 && m.getDistance(element.x, element.y) > 100.0) {
						element.y += this.GRAVITY ;
						System.out.println(temps + "en s");
						repaint();
					}
				}

			}
		}

		  try {
			Thread.sleep(100);
		  } catch (InterruptedException e) {
			e.printStackTrace();
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
