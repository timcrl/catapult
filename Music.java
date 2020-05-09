import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 * Music class creating all the necessary stuff such as the AudioInput, File
 * And enables the play, loop, stop actions for the music
 * @author Chetanveer
 *
 */
public class Music{

	Clip clip;
	/**
	 * Create the file containing the soundtrack
	 * @param soundFileName
	 */
	public void setFile(String soundFileName){
		try{
			File file = new File(soundFileName);
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(sound);
		}
		catch(Exception e){
			//left blank intentionally
		}
	}
	/**
	 * Launch the music 
	 */
	public void play(){
		clip.setFramePosition(0);
		clip.start();
	}
	/**
	 * Play the music in a loop
	 */
	public void loop(){
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	/**
	 * Stop the music and close it
	 */
	public void stop(){
		clip.stop();
		clip.close();
	}
}