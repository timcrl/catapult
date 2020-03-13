import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;

public class Fenêtre extends JFrame implements MouseListener, ActionListener {

	private JPanel pTerrain ;

	
	private long temps ; //variable temps à réutiliser dans toutes les classes pour avoir la même
	private int interval; //vitesse à laquelle le temps s'écoule
	private Timer timer;
	private Projectile proj;
	private APoint p ;


	public Fenêtre (int interval, Timer t) {
		super("Catapult's World") ;
		this.setSize(800, 800);

		this.interval=interval;
		this.timer = t;
		temps = 0;
		pTerrain = new Terrain () ;
		pTerrain.setLayout ( null ) ;
		
		p = new APoint (50,50);
		proj = new Projectile(p ,10, 10, 30 ,Color.Black,timer);


		this.setContentPane(pTerrain);
		this.setVisible(true);
	}

	public long getTime() {

		return temps;
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
