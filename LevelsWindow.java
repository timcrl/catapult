import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 * Selection Level Window, basic display to select between 3 levels
 * @author sebastien
 *
 */
public class LevelsWindow  extends JFrame implements ActionListener {
	
	//Declaration of the components
	private JPanel selectionLevels; 
	private JLabel jBackGround;
	private JLabel lTitle ;
	
	private JButton bLevel1;
	private JButton bLevel2;
	private JButton bLevel3;
	
	private JLabel jPicture1;
	private JLabel jPicture2;
	private JLabel jPicture3;
	
	private ButtonHandler bHandler = new ButtonHandler(); // use the classes for the sound effects
	private GameWindow game ;//host the world in the Play Window
	
	/**
	 * Constructor, setting the position of every components and incorporates the sounds and images
	 */
	public LevelsWindow() {
		// Definition of the windows properties
		super("Catapult's World") ;
		this.setSize(800, 800);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    
	    //Creation of the Background and Menu
	    selectionLevels = new JPanel();
	    selectionLevels.setBounds(0, 0, 800, 800);
	    selectionLevels.setLayout(null);
	    
	    Image background = Toolkit.getDefaultToolkit().getImage("./images/DecorationLevel/décor_forêt2.png");
		jBackGround = new JLabel(new ImageIcon(background));
		jBackGround.setBounds(0, 0, selectionLevels.getWidth(), selectionLevels.getHeight());
		selectionLevels. add(jBackGround);
	    
	    //Configurations of the Buttons
	    lTitle = new JLabel("SELECT YOUR LEVEL : ");
	    lTitle.setBounds(250, 50, 400 , 100);
	    lTitle.setFont(new Font("TITLE", Font.BOLD,20));
		
		bLevel1 = new JButton("LEVEL 1 : Earth");
	    bLevel1.setBounds(150, 200, 200, 50);
	    bLevel1.setBackground(new Color(190, 0, 0));
	    bLevel1.setFont(new Font("play", Font.BOLD, 18));
	    
	    bLevel2 = new JButton("LEVEL 2 : Moon");
	    bLevel2.setBounds(150, 400, 200, 50);
	    bLevel2.setBackground(new Color(190, 0, 0));
	    bLevel2.setFont(new Font("play", Font.BOLD, 18));
	    
	    bLevel3 = new JButton("LEVEL 3 : Mars ");
	    bLevel3.setBounds(150, 600, 200, 50);
	    bLevel3.setBackground(new Color(190, 0, 0));
	    bLevel3.setFont(new Font("play", Font.BOLD, 18));
	    
	    //Configurations of the JLabels    
	    Image pic1 = Toolkit.getDefaultToolkit().getImage("./images/DecorationLevel/décor_forêt_level.png");
	    jPicture1 = new JLabel(new ImageIcon(pic1));
	    jPicture1.setBounds(400, 150, 150,150);
		
	    Image pic2 = Toolkit.getDefaultToolkit().getImage("./images/DecorationLevel/décor_moon_level.png");
	    jPicture2 = new JLabel(new ImageIcon(pic2));
	    jPicture2.setBounds(400, 350, 150,150);
		
	    Image pic3 = Toolkit.getDefaultToolkit().getImage("./images/DecorationLevel/décor_mars_level.png");
	    jPicture3 = new JLabel(new ImageIcon(pic3));
	    jPicture3.setBounds(400, 550, 150,150);
	    
	    //Implementation of the ActionListener
	    bLevel1.addActionListener(this);
	    bLevel2.addActionListener(this);
	    bLevel3.addActionListener(this);
	    
	    //Implementation of sound effects on button click
	    bLevel1.addActionListener(bHandler);
	    bLevel2.addActionListener(bHandler);
	    bLevel3.addActionListener(bHandler);
	    
	    //Differentiate between buttons clicked
	    bLevel1.setActionCommand("musicB");
	    bLevel2.setActionCommand("musicB");
	    bLevel3.setActionCommand("musicB");
	    
	    //Display of the buttons and labels in the window
	    jBackGround.add(lTitle);
	    jBackGround.add(bLevel1);
	    jBackGround.add(bLevel2);
	    jBackGround.add(bLevel3);
	    jBackGround.add(jPicture1);
	    jBackGround.add(jPicture2);
	    jBackGround.add(jPicture3);
	    
	    this.setContentPane(selectionLevels);
	    this.setVisible(true); //appear only after pushing levels in Welcome Window
}

	/**
	 * Method saying what to do when a button is pushed (e.g. : launch Level 1 for bLevel1)
	 * @param  e
	 */
	public void actionPerformed(ActionEvent e) {
				
		if(e.getSource() == bLevel1) {
			System.out.println("You ask to play the Level 1 ");
			game = new GameWindow(new Terrain());
		}
		if(e.getSource()==bLevel2) {
			System.out.println("You ask to play the Level 2 ");
			game = new GameWindow(new Terrain2());
		}
		if(e.getSource()==bLevel3) {
			System.out.println("You ask to play the Level 3 ");
			game = new GameWindow(new Terrain3());
		}
		
		//We close the LevelSelectionWindow
		this.setVisible(false);
		this.dispose();
		
	}
}
