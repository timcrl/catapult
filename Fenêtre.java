import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Fenêtre extends JFrame implements MouseListener, Runnable {


    /*double interpolation = 0;
    final int TICKS_PER_SECOND = 25;
    final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    final int MAX_FRAMESKIP = 5;*/
    final int FRAMERATE = 60;
 	private int sleepDuration = 17; // originally 17 (it's 1/60 = 17 ms )
 	private int temps;
	private int width = 1000;
	private int height = 1000;
	Thread thread ;

	private static int scoreNb ;
	private JLabel score ;
	private Panneau world ;

	public Fenêtre () {
		// Definition of the windows properties
		super("Catapult's World") ;
		this.setSize(this.width, this.height);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
		
	    world = new Panneau();
		world.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
	    
		// Score Display
		score =  new JLabel() ;
		score.setText("SCORE : ");
		score.setFont(new Font("Serif", Font.BOLD, 20));
		score.setBounds(50, 20 , 250 , 80);
		world.add(score);

		// Use of thread instead of Timer , with Runnable interface to run only one instance (one loop) for the whole game
		thread = new Thread(this); // we use it so as to do several operations at the same time 
		thread.start(); //indicates that our loop is ready to be launched 
		temps=0; //Initialization of time

		// Addition of the panel "world" to fenêtre
		this.setContentPane(world);
		this.setVisible(true);

		addMouseListener(this);
	}

	public int getWidth(){
		return this.width;
	}

	public int getHeight(){
		return this.height;
	}

	public Panneau getPanel () {
		return this.world ;
	}
	public static int getScore() {
		return scoreNb;
	}

	// Display position of the mouse when clicking (future use to throw the projectile)
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

	// Main loop
	@Override
	public void run() {

            while(true) {
            	
        		System.out.println(world.getBounds(null));

            	//world.getProj().deplaceX(this);
            	//world.getProj().deplaceY(this);
              world.getProj().bounce(world); // Detects edges of terrain
              world.getProj().move();// Moves the projectile

						//	world.getProj().setPosition(100, 100);// Test to see drawing
            	world.getProj().bounce(world); // Detects edges of terrain
				world.getProj().move();// Moves the projectile

				//	world.getProj().setPosition(100, 100);// Test to see drawing
				
				
				//Update label score
				scoreNb = Terrain.score ;
            	score.setText("SCORE : " + scoreNb); 

            	repaint(); // Redraw elements
            	
            	//Stop the code when there is no more ennemy and will display a window of victory
            	if(Terrain.victory()) {
            		//break;
            	}

				//Avoid Slow down using the game loop
            	try {
            		Thread.sleep(sleepDuration);
            	} catch (InterruptedException e) {
            		e.printStackTrace();
            	}
            }



    }



}
