import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList; 

public class test{
	public static void main(String [] args){
		LinkedList <Cercle> mesCercle= new LinkedList<Cercle>();
		FenetrePlotCourbe fenetre = new FenetrePlotCourbe(mesCercle);
		double c1x=0; double c1y=0.3;
		Cercle c1 = new Cercle(new APoint(30,(c1y*fenetre.getHeight()-30)*fenetre.limite_sol),30,Color.black);
		c1.velocity = new double []{70,0};//initial velocity
		mesCercle.add(c1);
		fenetre.lancement();
	}
}
