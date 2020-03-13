import java.awt.event.*;
import javax.swing.*;

public class Timer implements ActionListener {
	
	// Les attributs de la classe
	public long temps;
	public int interval;
	
	public Timer (int interval){
		this.interval=interval;
		Timer time = new Timer(interval); // Création du timer
		temps = 0;
		// On initialise le temps à 0
	}	
	
	public Timer(int dELTA_T, FenetrePlotCourbe fenetrePlotCourbe) {
		// TODO Auto-generated constructor stub
	}

	// Méthode exécutée à chaque réveil du Timer
	public void actionPerformed(ActionEvent e) {

		temps+=interval; // On incrémente le temps
		System.out.println("Je suis vivant depuis "+temps+" ms");
	}
	
}