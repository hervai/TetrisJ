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
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.Grille;
import jeu.Piece;

public class VueLignes extends JPanel implements Observer {
	private Grille g;
	private int score;
	private int niveau;
	private int lignes;
	private JLabel jSNiveau, jSLignes, jSScore, jNiveau, jLignes, jScore;

	public VueLignes(Grille g) {
		this.g = g;
		g.addObserver(this);
		score = g.getScore();
		niveau = g.getNiveau();
		lignes = g.getNouvellesLignes();

		String lignesString = "LINES                    ";
		String niveauString = "LEVEL                    ";
		String scoreString = "SCORE                    ";

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		jSScore = new JLabel(scoreString);
		jSLignes = new JLabel(lignesString);
		jSNiveau = new JLabel(niveauString);
		jScore = new JLabel("" + score);
		jLignes = new JLabel("" + lignes);
		jNiveau = new JLabel("" + niveau);

		this.add(jSScore);
		this.add(jScore);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(jSNiveau);
		this.add(jNiveau);
		this.add(Box.createRigidArea(new Dimension(0, 20)));
		this.add(jSLignes);
		this.add(jLignes);
		this.add(Box.createRigidArea(new Dimension(0, 20)));

	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();

	}

}
