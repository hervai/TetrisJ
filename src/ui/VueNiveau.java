package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.Grille;
import jeu.Piece;

public class VueNiveau extends JLabel implements Observer {
	private Grille g;
	private int score;
	private int niveau;
	private int lignes;
	
	public VueNiveau(Grille g) {
		this.g = g;
		g.addObserver(this);
		score = g.getScore();
		niveau=g.getNiveau();
		lignes=g.getNouvellesLignes();
		String scoreString="LEVEL\n    "+score;
		setText(scoreString);

		setBackground(Color.green);
	/*	setLocation(Grille.LARGEUR_GRILLE * FenetreTetris.TAILLE_CARRE + 20,
				Grille.HAUTEUR_GRILLE * FenetreTetris.TAILLE_CARRE + 100);*/
		setPreferredSize(new Dimension(4 * FenetreTetris.TAILLE_CARRE,
				4 * FenetreTetris.TAILLE_CARRE));
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		score = g.getScore();
		niveau=g.getNiveau();
		lignes=g.getNouvellesLignes();
		String scoreString="LEVEL\n    "+score;
		setText(scoreString);
		
		
	}
	
}
