import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Fenêtre extends JFrame implements MouseListener, Runnable {

<<<<<<< Upstream, based on branch 'master' of https://github.com/timwinner/catapult.git
	//================SVVVPPPP pas bouger le timer j'ai tenté plein de trucs et c'est trop relou le plus simple
	//c'est qu'il reste là !!!!!!!!!!!!!!!!

=======
	
    /*double interpolation = 0;
    final int TICKS_PER_SECOND = 25;
    final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    final int MAX_FRAMESKIP = 5;*/
    final int FRAMERATE = 60;
 	int sleepDuration = 17;
	Thread thread ;
	
>>>>>>> 81ac725 Mise à jour, boucle de jeu fonctionnel dans le void run,
	private long temps ; //variable temps à réutiliser dans toutes les classes pour avoir la même
<<<<<<< Upstream, based on branch 'master' of https://github.com/timwinner/catapult.git
	private int interval = 200; //vitesse à laquelle le temps s'écoule
	private Timer timer;


	private Panneau world = new Panneau(timer);

=======

	
	
	private Panneau world = new Panneau();
	
>>>>>>> 81ac725 Mise à jour, boucle de jeu fonctionnel dans le void run,
	public Fenêtre () {
		super("Catapult's World") ;
		this.setSize(1000, 1000);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(true);
		addMouseListener(this);

<<<<<<< Upstream, based on branch 'master' of https://github.com/timwinner/catapult.git

=======
		thread = new Thread(this);
		thread.start();
>>>>>>> 81ac725 Mise à jour, boucle de jeu fonctionnel dans le void run,
		temps=0;
<<<<<<< Upstream, based on branch 'master' of https://github.com/timwinner/catapult.git
		timer = new Timer(interval, this);
		timer.start();
=======

>>>>>>> 81ac725 Mise à jour, boucle de jeu fonctionnel dans le void run,

		this.setContentPane(world);
		this.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

		String s = "| Position de la souris : " + e.getX() +" x et " + e.getY() + " y ";
		System.out.println(s);
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
/*
		if(e.getX()<= (int)(world.getProj().x+15) && e.getX()>= (int)(world.getProj().x-15) ) {
			if(e.getY()<= (int)(world.getProj().y+15) && e.getY()>=(int)(world.getProj().y-15)) {
				world.getProj().deplaceX(this);
			}
		}
		System.out.println(world.getProj().x + "position en x  |"+ world.getProj().dy + "position en y");
		repaint();
*/
	}
	
	@Override
<<<<<<< Upstream, based on branch 'master' of https://github.com/timwinner/catapult.git
	public void actionPerformed(ActionEvent e) {

		this.temps += interval;
		this.setTitle("Catapult's World :" + temps / 1000);
		int realtime = (int) (temps/1000) ;

		//début de code pour essayer la collision

		//world.getProj().action(realtime); //à travailler pour équations horaires

		//méthode pour travailler avec collision
		//world.getProj().deplaceX(this);
		//world.getProj().deplaceY(this);
		world.getProj().move();
		//world.gravityAction(realtime);
		System.out.println(realtime + "s");

		try {
			Thread.sleep(1);
		  } catch (InterruptedException t) {
			t.printStackTrace();
		  }
			repaint();
=======
	public void run() {

            while(true) {
            	//world.getProj().deplaceX(this);
            	//world.getProj().deplaceY(this);
            	world.gravityAction(sleepDuration); 
            	world.collisionDetect();
                
            	repaint();
            
            	try {
            		Thread.sleep(sleepDuration);
            	} catch (InterruptedException e) {
            		e.printStackTrace();
            	}
            }
                
            
        
    }
>>>>>>> 81ac725 Mise à jour, boucle de jeu fonctionnel dans le void run,


}
