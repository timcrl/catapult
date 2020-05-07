import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WelcomeWindow extends JFrame implements ActionListener  {
	
	private JPanel welcome ; 
	private JPanel menu ; 
	
	private JLabel jTitle ;
	private JLabel lbestScore ;
	private JLabel lindications ;
	private JTextField tPseudo ;
	
	private JButton bPlay;
	private JButton bLevels;

	private ButtonHandler bHandler = new ButtonHandler(); // uses the classes for the sound effects
	
	private String userName ;
	private int scoreRecord = 0 ;
	
	private GameWindow game ; //open the window containing the game
	private LevelsWindow selection ; //open the selection window for levels
	
		public WelcomeWindow() {
			// Definition of the windows properties
			super("Catapult's World") ;
			this.setSize(800, 800);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    this.setResizable(false);
		    
		    //Creation of the Background and Menu
		    welcome = new JPanel();
		    welcome.setBounds(0, 0, 800, 800);
		    welcome.setLayout(null);
		    
		    Image background = Toolkit.getDefaultToolkit().getImage("./images/DecorationLevel/décor_forêt2.png");
		   JLabel myImage = new JLabel(new ImageIcon(background));
		   myImage.setBounds(0, 0, welcome.getWidth(), welcome.getHeight());
		   welcome. add(myImage);
		    
		    menu = new JPanel();
		    menu.setBounds(150, 100, 500, 600);
		    menu.setOpaque(false);
		    menu.setLayout(null);
		     
		    //Configurations of the  JLabels and Text
		    jTitle = new JLabel("WELCOME TO CATAPULT'S WORLD");
		    jTitle.setBounds(15, 100, 500 , 100);
		    jTitle.setFont(new Font("TITLE", Font.BOLD,25));
		    
		    lbestScore = new JLabel(" Best Score : " + this.returnBestScore());
		    lbestScore.setBounds(200, 200, 200, 50);
		    lbestScore.setBackground(new Color(190, 0, 0));
		    
		    lindications = new JLabel(" Please enter your pseudo : ");
		    lindications.setBounds(150, 275, 300, 50);
		    tPseudo = new JTextField();
		    tPseudo.setBounds(150, 330, 200, 50);
		    
		    //Configurations of the Buttons 
			bPlay = new JButton("PLAY");
		    bPlay.setBounds(300, 450, 125, 50);
		    bPlay.setBackground(new Color(190, 0, 0));
		    bPlay.setFont(new Font("play", Font.BOLD, 20));
		    bLevels = new JButton("LEVELS");
		    bLevels.setBounds(75, 450, 125, 50);
		    bLevels.setBackground(new Color(190, 0, 0));
		    bLevels.setFont(new Font("play", Font.BOLD, 20));
		    
		    //Implementation of the ActionListener
		    bPlay.addActionListener(this);
		    bLevels.addActionListener(this);
		    tPseudo.addActionListener(this);

		    //Implementation of sound effects on button click
		    bPlay.addActionListener(bHandler);
		    bLevels.addActionListener(bHandler);
		    tPseudo.addActionListener(bHandler);

		    //Differentiate between buttons clicked
		    tPseudo.setActionCommand("soundB");
		    bLevels.setActionCommand("soundB");
		    bPlay.setActionCommand("musicB");

		    //Display of the buttons in the menu
		    menu.add(jTitle);
		    menu.add(lbestScore);
		    menu.add(lindications);
		    menu.add(tPseudo);
		    menu.add(bPlay);
		    menu.add(bLevels);
		    
			// Addition of the panel "welcome" and "menu"  to WelcomeWindow	  
			this.setContentPane(welcome);
			myImage.add(menu);
			this.setVisible(true);
		}
		
		public int returnBestScore() {
			
			if(scoreRecord <= GameWindow.getScore()) {
				scoreRecord = GameWindow.getScore();
			}
			return scoreRecord;
		}
		
		public GameWindow returnGameWindow() {
			return game;
		}

		public void paintComponent(Graphics g){

		}
		
		@Override
		public void actionPerformed(ActionEvent e) {

			 if(userName != null){
				
				if (e.getSource()== bPlay) {
					System.out.println("Let's start the game");
					game = new GameWindow(new Terrain());
					
					this.setVisible(false); //We close the WelcomeWindow
					this.dispose();
				}
				if (e.getSource()== bLevels) {
					System.out.println("You can choose your level"); //enable the selection of the level
					selection = new LevelsWindow();
					
					//We close the WelcomeWindow
					this.setVisible(false);  
					this.dispose(); 
				}
			 }
			else {
					lindications.setText("<html> <p> You didn't enter your pseudo <br/> (push enter on the keyboard) ! </p></html>");
			}
			if(e.getSource()==tPseudo) {
			    userName = (tPseudo.getText()); // recuperates the player's name
				System.out.println(" Alright your name is : " + userName);
				lindications.setText("<html> <p> Now, General " + userName + "<br/> you can push the play button </p></html>"); //use of html/ so as to get a LineWrap
			}
			
		}
		
}
