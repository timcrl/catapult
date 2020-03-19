import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Fenêtre extends JFrame implements MouseListener, ActionListener {

	private Panneau world = new Panneau();
	
	private long temps ; //variable temps à réutiliser dans toutes les classes pour avoir la même
	private int interval; //vitesse à laquelle le temps s'écoule
	private Timer timer;
	private Projectile proj;
	


	public Fenêtre (int interval) {
		super("Catapult's World") ;
		this.setSize(1000, 1000);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
		this.addMouseListener(this);	
/*
		this.interval=interval;
		this.timer = new Timer(interval, this);;
		temps = 0;
	
		*/


		this.setContentPane(world);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

		if(!timer.isRunning()) {
			timer.start();
		}else if(timer.isRunning()) {
			timer.stop();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		temps += interval;
	}

}
