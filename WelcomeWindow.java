import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class WelcomeWindow extends JFrame implements ActionListener  {

	private JLabel lbestScore ;
	
	private JPanel welcome ; 
	private JPanel menu ; 
	
	private JButton bPlay;
	private JButton bLevels;
	
	private JLabel lindications ;
	private JTextField tPseudo ;
	
	
		public WelcomeWindow() {
			// Definition of the windows properties
			super("Catapult's World") ;
			this.setSize(800, 800);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    this.setResizable(false);
		    
		    //Creation of the background and menu
		    welcome = new JPanel();
		    welcome.setBounds(0, 0, 800, 800);
		    welcome.setLayout(null);
		   JLabel myImage = new JLabel(new ImageIcon("décor_forêt.png"));
		   myImage.setBounds(0, 0, welcome.getWidth(), welcome.getHeight());
		   welcome. add(myImage);
		    
		    menu = new JPanel();
		    menu.setBounds(150, 100, 500, 600);
		  
		    menu.setBackground(Color.gray);
		    menu.setLayout(null);
		     
		    //Configurations of the Buttons
		    bPlay = new JButton("PLAY");
		    bPlay.setBounds(300, 450, 125, 50);
		    bPlay.setBackground(new Color(190, 0, 0));
		    bPlay.setFont(new Font("play", Font.BOLD, 20));
		    bLevels = new JButton("LEVELS");
		    bLevels.setBounds(75, 450, 125, 50);
		    bLevels.setBackground(new Color(190, 0, 0));
		    bLevels.setFont(new Font("play", Font.BOLD, 20));
		    lbestScore = new JLabel(" Best Score : ");
		    lbestScore.setBounds(200, 200, 100, 50);
		    lbestScore.setBackground(new Color(190, 0, 0));
		    
		    
		    lindications = new JLabel(" Please enter your pseudo : ");
		    lindications.setBounds(150, 275, 300, 50);
		    tPseudo = new JTextField();
		    tPseudo.setBounds(150, 330, 200, 50);
	
		    //Display of the buttons in the menu
		    menu.add(bPlay);
		    menu.add(bLevels);
		    menu.add(lbestScore);
		    menu.add(lindications);
		    menu.add(tPseudo);
		    
			// Addition of the panel "welcome" and "menu"  to WelcomeWindow	  
			this.setContentPane(welcome);
			welcome.add(menu);
			
			this.setVisible(true);
		}

		public void paintComponent(Graphics g){

		}
		
		@Override
		public void actionPerformed(ActionEvent e) {

			
		}
		
		
		
		
}
