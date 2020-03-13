import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game{

	public static void main(String [] args){

		timer = new Timer(interval, this);

		new Fenêtre(20, timer) ;

	}
}
