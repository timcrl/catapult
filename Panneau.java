import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Panneau extends JPanel implements ActionListener {
   
	private Terrain ter = new Terrain();
	private final double GRAVITY = 9.8 ;
	
	Timer monChrono = new Timer(200,this);
	
	private Projectile proj;
	private APoint p = new APoint (50,600);
	
	public Panneau(){
		monChrono.start();
		proj = new Projectile(p,10.0, 10.0, 30.0 ,Color.black, monChrono);
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
	
	//affichage des matériaux et leurs textures
	for(int i=0; i<ter.itemCoords.length; i++){
		for(int j=0; j<ter.itemCoords[0].length; j++){
				Image img1 = Toolkit.getDefaultToolkit().getImage(Matériaux.refTextures[ter.itemCoords[i][j]]);
				g.drawImage(img1, i*25, j*25, this);
		}
	} 

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
	
	repaint();
  }
  
  //méthode à compléter pour la détection de collision
  
  public boolean touch (boolean facing){  // facing left : true, facing right : false
	  
		int column = (int)((proj.x+35)/50)%20;
		int line = (int)((proj.y+35)/50)%20;
		double d = (proj.x+35)/50.0;
		
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
		return false;
  }
	
}