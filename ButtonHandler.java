import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//PLay the sounds on button press
    public class ButtonHandler implements ActionListener{
    	
    	private String clickSound, backgroundMusic;
    	private SoundEffect soundEffect = new SoundEffect();
    	private Music bMusic = new Music();
    	
    	public ButtonHandler() {
    			   this. clickSound = "./sounds/clickSound.wav"; //import the click sound from a file
    			   this.backgroundMusic = "./sounds/backgroundMusic.wav"; //import the background music from a file
    	}
	    
    	public void actionPerformed(ActionEvent event){

    		String clickedButton = event.getActionCommand(); //to get the sound name from the button
    		
    		switch(clickedButton){
    			case "soundB":
    			soundEffect.setFile(clickSound); // create the click sound 
    			soundEffect.play(); // play the sound
    			break; // to stop it quickly so as not to be a loop

    			case "musicB":
    			soundEffect.setFile(clickSound); 
    			soundEffect.play();
    			bMusic.setFile(backgroundMusic);
    			bMusic.play(); 
    		}
    	}
    }