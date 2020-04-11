import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class WelcomeWindow extends JFrame implements ActionListener  {
	
	private JPanel welcome ; 
	private JPanel menu ; 
	
	private JLabel lTitle ;
	private JLabel lbestScore ;
	private JLabel lindications ;
	private JTextField tPseudo ;
	
	private JButton bPlay;
	private JButton bLevels;
	
	private String userName ;
	private int scoreRecord = 0 ;
	
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
		    
		    Image background = Toolkit.getDefaultToolkit().getImage("./images/décor_forêt2.png");
		   JLabel myImage = new JLabel(new ImageIcon(background));
		   myImage.setBounds(0, 0, welcome.getWidth(), welcome.getHeight());
		   welcome. add(myImage);
		    
		    menu = new JPanel();
		    menu.setBounds(150, 100, 500, 600);
		    menu.setOpaque(false);
		    menu.setLayout(null);
		     
		    //Configurations of the Buttons and JLables and Text
		    lTitle = new JLabel("WELCOME TO CATAPULT'S WORLD");
		    lTitle.setBounds(15, 100, 500 , 100);
		    lTitle.setFont(new Font("TITLE", Font.BOLD,25));
		    
		    lbestScore = new JLabel(" Best Score : " + scoreRecord);
		    lbestScore.setBounds(200, 200, 200, 50);
		    lbestScore.setBackground(new Color(190, 0, 0));
		    
		    lindications = new JLabel(" Please enter your pseudo : ");
		    lindications.setBounds(150, 275, 300, 50);
		    tPseudo = new JTextField();
		    tPseudo.setBounds(150, 330, 200, 50);
		    
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
		    
		    //Display of the buttons in the menu
		    menu.add(lTitle);
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
		public void checkBestScore() {
			
			if(scoreRecord <= Fenêtre.getScore()) {
				scoreRecord = Fenêtre.getScore();
			}
				
		}

		public void paintComponent(Graphics g){

		}
		
		@Override
		public void actionPerformed(ActionEvent e) {

				if (e.getSource()== bPlay) {
					
					if(userName != null) {
						System.out.println("Let's start the game");
						Fenêtre jeu = new Fenêtre() ; //open the play window
						this.setVisible(false); //close the welcomewindow
					}
					else {
						lindications.setText("<html> <p> You didn't enter your pseudo <br/> (push enter on the keyboard) ! </p></html>");
					}
				}
				if (e.getSource()== bLevels) {
					System.out.println("You can choose your level"); //enable the selection of the level
				}
				if(e.getSource()==tPseudo) {
				    userName = (tPseudo.getText()); // recuperates the player's name
					System.out.println(" Alright your name is : " + userName);
					lindications.setText("<html> <p> Now, General " + userName + "<br/> you can push the play button </p></html>"); //use of html/ so as to get a LineWrap
				}
			
		}
		
		
		
		
}
