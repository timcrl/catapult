import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TransitionWindow extends JFrame implements ActionListener {

	private JPanel transition; 
	
	private JLabel lTitle ;
	private JLabel lScore ;
	
	private JButton bRePlay;
	private JButton bNextLevel;
	
	private Fenêtre game ; //host the next play window
	private Fenêtre gameAlreadyPlayed;
	private int levelGameAlrPlayed ; // will keep track of the level value
	
	public TransitionWindow(Fenêtre currentGame) {
		
		// Definition of the windows properties
		super("Catapult's World") ;
		this.setSize(800, 800);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    
	    //we get the past game and its level
	    this.gameAlreadyPlayed = currentGame;
	    this.levelGameAlrPlayed = this.gameAlreadyPlayed.getWorld().getLevelNumber(); 
	    
	    //Creation of the Background and Menu
	    transition = new JPanel();
	    transition.setBounds(0, 0, 800, 800);
	    transition.setLayout(null);
	    
	    Image background = Toolkit.getDefaultToolkit().getImage("./images/DecorationLevel/décor_transi.png");
		JLabel jBackGround = new JLabel(new ImageIcon(background));
		jBackGround.setBounds(0, 0, transition.getWidth(), transition.getHeight());
		transition. add(jBackGround);
		
	    //Configurations of the Buttons and JLabels and Text
	    lTitle = new JLabel("VICTORY");
	    lTitle.setBounds(300, 250, 200 , 100);
	    lTitle.setFont(new Font("TITLE", Font.BOLD,40));
	    
	    lScore = new JLabel(" Your Score : " + Fenêtre.getScore());
	    lScore.setBounds(290, 375, 300, 100);
	    lScore.setBackground(new Color(190, 0, 0));
	    lScore.setFont(new Font("TITLE", Font.BOLD,20));
	    
		bRePlay = new JButton("REPLAY");
	    bRePlay.setBounds(150, 500, 175, 50);
	    bRePlay.setBackground(new Color(190, 0, 0));
	    bRePlay.setFont(new Font("play", Font.BOLD, 20));
	    
	    bNextLevel = new JButton("NEXT LEVEL");
	    bNextLevel.setBounds(470, 500, 175, 50);
	    bNextLevel.setBackground(new Color(190, 0, 0));
	    bNextLevel.setFont(new Font("play", Font.BOLD, 20));
	    
	    //Implementation of the ActionListener
	    bRePlay.addActionListener(this);
	    bNextLevel.addActionListener(this);
	    
	    //Display of the buttons in the window
	    jBackGround.add(lTitle);
	    jBackGround.add(lScore);
	    jBackGround.add(bNextLevel);
	    jBackGround.add(bRePlay);
	    
	    this.setContentPane(transition);
	    this.setVisible(true); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == bRePlay) {
			game = new Fenêtre(new Terrain());
		}
		if(e.getSource()== bNextLevel) {
			System.out.println("You ask to play the Next Level");
			
			//We check which level has been played just before
			if(this.levelGameAlrPlayed ==1) {
				game = new Fenêtre(new Terrain2());
			}
			if(this.levelGameAlrPlayed == 2) {
				game = new Fenêtre(new Terrain3());
			}
			if(this.levelGameAlrPlayed == 3) {
				game = new Fenêtre(new Terrain());
			}
		}
		
		//We close the transition window
		this.setVisible(false);
		this.dispose();
	}

}
