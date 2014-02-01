package ui;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import jeu.*;;

public class VueGrille extends JPanel implements Observer{
	private Grille g;
	public VueGrille(Grille g){
		this.g=g;
		g.addObserver(this);

	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
