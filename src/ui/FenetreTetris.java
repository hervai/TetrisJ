package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.Grille;
import jeu.Jeu;

public class FenetreTetris extends JFrame implements KeyListener {
	private Jeu jeu;
	private Thread t;
	private Grille g;
	
	public static final int TAILLE_CARRE = 40;

	public FenetreTetris() {
		Thread t = new Thread(jeu = new Jeu());
		this.g = jeu.getGrille();

		initFenetre();

		this.addKeyListener(this);

		t.start();

	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (g.getPieceCourante() != null && (!jeu.getFinjeu())) {
				
				g.deplaceGauche();
				repaint();
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (g.getPieceCourante() != null && (!jeu.getFinjeu())) {
				
				g.deplaceDroite();
				repaint();
			}
			break;
		case KeyEvent.VK_UP:
			if (g.getPieceCourante() != null && (!jeu.getFinjeu())) {
				
				g.rotationPiece();
				repaint();
			}
		case KeyEvent.VK_DOWN:
			if (g.getPieceCourante() != null && (!jeu.getFinjeu())) {
				
				g.deplaceBas();
				repaint();
			}
			break;
		case KeyEvent.VK_PAUSE:
			if (g.getPieceCourante() != null && (!jeu.getFinjeu())) {
				System.out.println("Pause");
				jeu.pause();
				repaint();
			}
		default:
			repaint();
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

	public void initFenetre() {

		// this.getContentPane().setLayout(null);

		// Fenêtre de jeu
		this.setSize(Grille.LARGEUR_GRILLE * TAILLE_CARRE + 335,
				(Grille.HAUTEUR_GRILLE) * TAILLE_CARRE + 30);
		this.setTitle("Tetris");
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    
	    //Elements à ajouter
	    VueGrille vg = new VueGrille(this.g, this.jeu);
	   
	    getContentPane().add(vg);
	    
	   System.out.println(this.getHeight() + " " + this.getWidth());
	    
	   
		this.setVisible(true);
	}


}
