package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import jeu.Grille;
import jeu.Piece;

public class VueMenu extends JPanel {
	private Grille g;

	public VueMenu(Grille g) {
		this.g = g;
		//g.addObserver(this);

		setBackground(Color.lightGray);
		setLocation(Grille.LARGEUR_GRILLE * FenetreTetris.TAILLE_CARRE + 20,
				Grille.HAUTEUR_GRILLE * FenetreTetris.TAILLE_CARRE + 20);
		setPreferredSize(new Dimension(4 * FenetreTetris.TAILLE_CARRE,
				4 * FenetreTetris.TAILLE_CARRE));
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		VueScore vs = new VueScore(g);
		VuePieceSuivante vps = new VuePieceSuivante(g);
		this.add(vs);
		this.add(Box.createRigidArea(new Dimension(0,5)));
		this.add(vps);
	}

	
}
