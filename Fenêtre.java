import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Fenêtre extends JFrame implements MouseListener, ActionListener {

	//================SVVVPPPP pas bouger le timer j'ai tenté plein de trucs et c'est trop relou le plus simple
	//c'est qu'il reste là !!!!!!!!!!!!!!!!

	private long temps ; //variable temps à réutiliser dans toutes les classes pour avoir la même
	private int interval = 200; //vitesse à laquelle le temps s'écoule
	private Timer timer;


	private Panneau world = new Panneau(timer);

	public Fenêtre () {
		super("Catapult's World") ;
		this.setSize(1000, 1000);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(true);
		addMouseListener(this);


		temps=0;
		timer = new Timer(interval, this);
		timer.start();

		this.setContentPane(world);
		this.setVisible(true);
	}
	public long getTemps() {
		return temps;
	}


	@Override
	public void mouseClicked(MouseEvent e) {

		/*if(!timer.isRunning()) {
			timer.start();
		}*/
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
		/*String s = "| Position de la souris : " + e.getX() +" x et " + e.getY() + " y ";
		System.out.println(s);
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

	}

}
