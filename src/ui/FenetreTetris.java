package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

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

		// Début du jeu
		t.start();
		this.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (g.getPieceCourante() != null && (!jeu.getFinjeu())) {
				System.out.println("Deplacement gauche");
				g.deplaceGauche();
				repaint();
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (g.getPieceCourante() != null && (!jeu.getFinjeu())) {
				System.out.println("Deplacement droite");
				g.deplaceDroite();
				repaint();
			}
			break;
		case KeyEvent.VK_UP:
			if (g.getPieceCourante() != null && (!jeu.getFinjeu())) {
				System.out.println("Rotation");
				g.rotationPiece();
				repaint();
			}
		case KeyEvent.VK_DOWN:
			if (g.getPieceCourante() != null && (!jeu.getFinjeu())) {
				System.out.println("Deplacement bas");
				g.deplaceBas();
				repaint();
			}
			break;
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
		
		this.getContentPane().setLayout(null);

		// Fenetre de jeu
		this.setSize(Grille.LARGEUR_GRILLE * TAILLE_CARRE + 250,
				(Grille.HAUTEUR_GRILLE+2) * TAILLE_CARRE);
		this.setTitle("Tetris");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("img\\background.jpg")));
		setLayout(new FlowLayout());



		

		
		//setContentPane(new JPanel());
		
		Container tableau = getContentPane();
		tableau.setSize(this.getWidth(), this.getHeight());
		tableau.setLayout(new BorderLayout());
		
		VueMenu vMenu=new VueMenu(jeu.getGrille());
		VueGrille vGrille = new VueGrille(jeu.getGrille());
		
		
		tableau.add(vGrille,BorderLayout.CENTER);
		tableau.add(vMenu, BorderLayout.EAST);
	}
}
