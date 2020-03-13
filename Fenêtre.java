import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;

public class Fenêtre extends JFrame implements MouseListener, ActionListener {
	
	private JPanel pTerrain ;
	
	private long temps ;
	private int interval;
	private Timer timer;
	
	
	public Fenêtre (int interval) {
		super("Catapult's World") ;
		this.setSize(800, 800);
		
		this.interval=interval;
		timer = new Timer(interval, this);
		temps = 0;
		pTerrain = new Terrain () ;
		pTerrain.setLayout ( null ) ;
		
		
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
