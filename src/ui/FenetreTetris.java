package ui;
import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import jeu.Grille;
import jeu.Jeu;

public class FenetreTetris extends JFrame implements KeyListener, Observer {
	private Jeu jeu;
	private Thread t;

	public FenetreTetris() {
		Thread t = new Thread(jeu = new Jeu());
		this.setSize(Grille.LARGEUR_GRILLE*50,Grille.HAUTEUR_GRILLE*50);
		this.setTitle("Tetris by hervai");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pan=new JPanel();
		
		pan.setBackground(Color.darkGray);
		this.setContentPane(pan);
		this.setVisible(true);
		t.start();
	}

	
	public void update(){
		
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT : if (jeu.getGrille().getPieceCourante() != null) {
			System.out.println("Deplacement gauche");
			jeu.getGrille().deplaceGauche();	
			//p.gauche(grille);
				repaint();
			}
			break;
		case KeyEvent.VK_RIGHT : if (jeu.getGrille().getPieceCourante() != null) {
				//p.droite(grille);
				repaint();
			}
			break;
		case KeyEvent.VK_UP : if (jeu.getGrille().getPieceCourante() != null) {
				//p.tourned(grille);
				repaint();
			}
		case KeyEvent.VK_DOWN : if (jeu.getGrille().getPieceCourante() != null) {
                               // p.descend(grille);
                                repaint();
			}
                break;
		default : repaint();
	}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
