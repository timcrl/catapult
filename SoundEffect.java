import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 * Class creating the Sound effects such as click ones
 * Using the same principle as Music
 * @author Chetanveer
 *
 */
public class SoundEffect{

	Clip clip;
	/**
	 * Set the file with the audio
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
	 * Explain what to do when SoundEffect is played
	 */
	public void play(){
		clip.setFramePosition(0);
		clip.start();
	}
}