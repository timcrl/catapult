import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Fenêtre extends JFrame implements MouseListener, Runnable {

	
    /*double interpolation = 0;
    final int TICKS_PER_SECOND = 25;
    final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    final int MAX_FRAMESKIP = 5;*/
    final int FRAMERATE = 60;
 	private int sleepDuration = 17;
 	private int temps;
	Thread thread ;

	private int scoreNb ;
	private JLabel score ;
	private Panneau world = new Panneau();

	public Fenêtre () {
		super("Catapult's World") ;
		this.setSize(1000, 1000);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(true);
		
		score =  new JLabel() ;
		score.setText("SCORE : ");
		score.setFont(new Font("Serif", Font.BOLD, 20));
		score.setBounds(20, 750 , 150 , 80);
		world.add(score);

		thread = new Thread(this);
		thread.start();
		temps=0;
	
		this.setContentPane(world);
		this.setVisible(true);
		addMouseListener(this);
	}
	
	public Panneau getPanel () {
		return this.world ;
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
	public void run() {

            while(true) {
            	world.getProj().deplaceX(this);
            	world.getProj().deplaceY(this);
            	//world.gravityAction(sleepDuration);
            	
            	
            	score.setText("SCORE : " + scoreNb);
                
            	repaint();
            
            	try {
            		Thread.sleep(sleepDuration);
            	} catch (InterruptedException e) {
            		e.printStackTrace();
            	}
            }
                
            
        
    }



}
