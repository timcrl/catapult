import java.awt.event.*;
import java.util.Iterator;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.html.parser.Element;
/**
 * Main Panel calling every elements (SlingShot, Projectile, Aliens and Blocks)
 * Display them and compute the launch of the projectile
 * @author sebastien
 *
 */
public class GamePanel extends JPanel implements  MouseListener, MouseMotionListener {
	
	//Declaration of the attributes and components
	private Terrain ter ;
	private static Projectile proj;
	private Thrower slingshot;
	private final APoint projPosition = new APoint (100, 610);

	private double angle = 30.0;
	private long temps;

	/**
	 * Constructor of the panel with Mouse Listeners
	 * @param planete
	 */
	public GamePanel(Terrain planete){

		this.ter = planete;
		proj = new Projectile(projPosition,5.0, 5.0, 30.0 );
		proj.setSpeed(0,0);

		slingshot = new Thrower(proj, 100, 600); // set the thrower in the panel

		this.setLayout(null);
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	/**
	 * Getter of the Projectile
	 * @return proj
	 */
	public static Projectile getProj() {
		return proj;
	}
	/**
	 * Getter of the Thrower
	 * @return slingshot
	 */
	public Thrower getThrower(){
		return slingshot;
	}
	/**
	 * Getter of the ground value
	 * @return ground
	 */
	public static double getGround() {
		return 700;
	}
	
	/**
	 * Display all the elements background, objects, etc
	 */
	public void paintComponent(Graphics g){

	    Image background = ter.picGround ;
		g.drawImage(background, 0, 0, null);

		/*===================== Objects Display*/

		slingshot.dessiner(g);	//keep this order to have the slingshot behind the projectile
		proj.dessiner(g);

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
		Toolkit.getDefaultToolkit().sync();

		}

	/**
	 * To drag the projectile (when the mouse is kept pressed)
	 */
	public void mouseDragged(MouseEvent e) {
		/*
		// set an area of throwing of 100 px around the slingshot and the mouse must be at 30 px to grab it
		if(proj.getDistance(e.getX(), e.getY()) <= 30.0 && this.projPosition.getDistance(e.getX(), e.getY()) <= 100 ) {
			proj.setPosition(e.getX(), e.getY());
		}
		else {
			// if the condition is not respected and the mouse exits the area of throwing, the projectile is set to its initial position
			proj.setPosition(this.projPosition.x, this.projPosition.y);
		} */
		if (slingshot.isDragging()){
			proj.setPosition(e.getX(), e.getY());
			//System.out.println("new position set by dragg");
			slingshot.setMousePosition(e.getX(), e.getY());
		}
	}

	/**
	 * Detect collision between the mouse and the projectile
	 */
	public void mouseMoved(MouseEvent e) { // To remove, replaced by mouseDragged
		/*
		if(proj.getDistance(e.getX(), e.getY()) <= 15.0) {
			// System.out.println("The mouse has collided");
			proj.couleur = new Color(50, 50, 50);
		}

		if (slingshot.isDragging()){
			proj.setPosition(e.getX(), e.getY());
			System.out.println("new position set");
			slingshot.setMousePosition(e.getX(), e.getY());
		}
		*/

	}

 //========== Works only with MouseListener implemented
	/**
	 * Changes the values of the drag attributes when the mouse is pressed
	 */
	public void mousePressed(MouseEvent e) {
		//System.out.println("mouse pressed");
		slingshot.setDragging(true);
		proj.isDragged(true);

	}
	/**
	 * Changes the values of the drag attributes when the mouse is released
	 * and launch the projectile
	 */
	public void mouseReleased(MouseEvent e) {
	    //System.out.println("mouse released");
	    slingshot.setDragging(false);
	    proj.isDragged(false);
	    slingshot.launchProjectile();

	/*
			if(e.getX()<= (int)(proj.x+15) && e.getX()>= (int)(proj.x-15) ) {
				if(e.getY()<= (int)(proj.y+15) && e.getY()>=(int)(proj.y-15)) {
					proj.deplaceX(this);
				}
			}
			System.out.println(proj.x + "position en x  |"+ proj.dy + "position en y");
			repaint();
	*/

	}
	
		/**
		 * Give the position of the mouse when it is clicked
		 */
		public void mouseClicked(MouseEvent e) {
			String s = "| Position de la souris : " + e.getX() +" x et " + e.getY() + " y ";
			//System.out.println(s);
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
	
		}
	
		@Override
		public void mouseExited(MouseEvent e) {
	
		}


	}
