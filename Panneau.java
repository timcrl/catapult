import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Panneau extends JPanel implements ActionListener, MouseMotionListener {
   
	private Terrain ter = new Terrain();
	private final double GRAVITY = 9.8 ;
	private Projectile proj;
	private Cercle c1;
	private APoint p = new APoint (50,600);
	private double limite_sol=0.15;
	private double dist ;
	private double dist2 ;
	
	//ce timer reprend exactement le même que dans fenêtre donc modif dans fenêtre si besoin
	private long temps;
	private int interval = 200;
	Timer monChrono ;
	
	
	public Panneau(Timer timer){
		
		temps = 0;
		monChrono=timer;
		proj = new Projectile(p,10.0, 10.0, 30.0 ,Color.black,temps );
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
					g.drawImage(fond, 0, 0, this);
		
		g.setColor(Color.green);
		g.fillRect(0,getHeight()-150,getWidth(),150);
		
	
		/*===================== Affichage objets*/
					
		proj.dessiner(g);
		c1.dessine(g);
		
		/*=================================*/
		//affichage des matériaux et leurs textures en parcourant la liste
		
		for (Matériaux element : ter.listMateriaux) {
			g.drawImage(element.img, (int)element.x,(int)element.y, this);

		}
		
		//============CALCUL COLLISION=========== (juste changement de couleur pour l'instant)
		dist = proj.getDistance(c1.centre.x, c1.centre.y);
		System.out.println(dist + " la distance entre les 2 cercles ");
		
		if(dist <= c1.rayon + proj.getRayon()) {
			proj.couleur = c1.maCouleur ;
		}
		
		dist2 = proj.getDistance(ter.listMateriaux.get(2).centreX, ter.listMateriaux.get(2).centreY);
		System.out.println(dist2 + " la distance entre le projectile et l'objet ");
		
		if(dist2 <= 25.0 + proj.getRayon()) {
			proj.couleur = Color.green ;
		}
		//==========================
	  }
  
	  public void gravityAction(){
	
		  try {
			Thread.sleep(1);
		  } catch (InterruptedException e) {
			e.printStackTrace();
		  }
			repaint();
	  }
	  
	  public void actionPerformed(ActionEvent e){
	
	  }
  
	  //méthode à compléter pour la détection de collision
	  //=================CODE OBSOLETE mais peut donner des idées pour la collision
	  
	  public boolean touch (boolean facing){  // facing left : true, facing right : false
		  
			int column = (int)((proj.x+35)/50)%20;
			int line = (int)((proj.y+35)/50)%20;
			double d = (proj.x+35)/50.0;
			/*
			//détection à gauche
			if(facing && d-(int)d<=0.50){
				 if(Terrain.itemCoords[column-1][line]!=0){
					 return true;
				 }
			}
			//détection à droite
			if(!facing && d-(int)d>=0.50){
				 if(Terrain.itemCoords[column+1][line]!=0){
					 return true;
				 }
			}	
			*/
			return false;
			
	  }
	//==========================

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		c1 = new Cercle(new APoint(e.getX(),e.getY()),15,Color.red);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
		
	}