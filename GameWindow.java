import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 * Main Window containing all the games
 * It contains GamePanel and the Game Loop
 * @author sebastien
 *
 */
public class GameWindow extends JFrame implements  Runnable {


    /*
    final int TICKS_PER_SECOND = 25;
    final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
    final int MAX_FRAMESKIP = 5;*/
    final int FRAMERATE = 60;
 	private int sleepDuration = 17; // originally (it's 1/60 so around 17 ms )
 	private int temps;
	Thread thread ; // Principal element of our Game Loop
 	
	//Declaration of Components and Attributes
	private final int WIDTH = 1000;
	private final int HEIGHT = 1000;

	private static int scoreNb ;
	private static Terrain planete ;
	private JLabel jScore ;
	private GamePanel world ;

	private TransitionWindow transi; // window of victory, called if conditions gathered

	/**
	 * Constructor setting the position of JLabel and GamePanel
	 * @param level1
	 */
	public GameWindow (Terrain  level1) {
		// Definition of the windows properties
		super("Catapult's World") ;
		this.setSize(this.WIDTH, this.HEIGHT);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);

	    planete = level1;
	    world = new GamePanel(planete);
		world.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));

		// Score Display
		jScore =  new JLabel() ;
		jScore.setText("SCORE : ");
		jScore.setFont(new Font("Serif", Font.BOLD, 20));
		jScore.setBounds(50, 20 , 250 , 80);
		world.add(jScore);

		// Use of thread instead of Timer , with Runnable interface to run only one instance (one loop) for the whole game
		thread = new Thread(this); // we use it so as to do several operations at the same time
		thread.start(); //indicates that our loop is ready to be launched
		temps=0; //Initialization of time

		// Addition of the panel "world" to fenêtre
		this.setContentPane(world);
		this.setVisible(true);
	}
	/**
	 * Getters of the world's gravity
	 * @return gravity
	 */
	public static double getGravityPlanet() {
		return planete.getGravity();
	}
	/**
	 * Getters of the world in which the game is played
	 * @return
	 */
	public Terrain getWorld () {
		return this.planete ;
	}
	/**
	 * Getter of the current Score
	 * @return scoreNb
	 */
	public static int getScore() {
		return scoreNb;
	}

	@Override
	/**
	 * Method containing our Game Loop and making the code run
	 * Implement the interpolation to avoid slow down
	 * Update Score and Display, and check winning conditions
	 */
	public void run() {

            while(true) {
	
	              world.getProj().bounce(world); // Detects edges of terrain
	              world.getProj().move();// Moves the projectile

				//Update label score
				scoreNb = Terrain.score ;
            	jScore.setText("SCORE : " + scoreNb);

            	repaint(); // Redraw elements

            	//Stops the game when the winning condition is fulfilled and closes the GameWindow to open the TransitionWindow
        		if(Terrain.victory() && scoreNb != 0 ) {

        			System.out.println("You have won !");
        			transi = new TransitionWindow(this); //open the victory window
        			Terrain.resetScore();
        			
        			//Stops the code and close the window
        			this.setVisible(false);
        			this.dispose();
        			break;
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
