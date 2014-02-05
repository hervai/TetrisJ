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
import javax.swing.JPanel;

import jeu.Grille;
import jeu.Piece;

public class VuePieceSuivante extends JPanel implements Observer {
	private Grille g;
	private Piece pieceSuivante;
	private int[][] grillePiece;

	public VuePieceSuivante(Grille g) {
		this.g = g;
		g.addObserver(this);
		pieceSuivante = g.getPieceSuivante();
		grillePiece = pieceSuivante.recupererPiece(pieceSuivante.getSens());

		setBackground(Color.lightGray);
		setLocation(Grille.LARGEUR_GRILLE * FenetreTetris.TAILLE_CARRE + 20,
				Grille.HAUTEUR_GRILLE * FenetreTetris.TAILLE_CARRE + 20);
		setPreferredSize(new Dimension(4 * FenetreTetris.TAILLE_CARRE,
				4 * FenetreTetris.TAILLE_CARRE));
	}

	public void paintComponent(Graphics gr) {
		int valeurCase;

		try {
			Image carre0 = ImageIO.read(new File("img/carre0.jpg"));
			Image carre1 = ImageIO.read(new File("img/carre1.jpg"));
			Image carre2 = ImageIO.read(new File("img/carre2.jpg"));
			Image carre3 = ImageIO.read(new File("img/carre3.jpg"));
			Image carre4 = ImageIO.read(new File("img/carre4.jpg"));
			Image carre5 = ImageIO.read(new File("img/carre5.jpg"));
			Image carre6 = ImageIO.read(new File("img/carre6.jpg"));
			Image carre7 = ImageIO.read(new File("img/carre7.jpg"));

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					valeurCase = grillePiece[i][j];
					switch (valeurCase) {
					case 0:
						gr.drawImage(carre0, j * FenetreTetris.TAILLE_CARRE, i
								* FenetreTetris.TAILLE_CARRE, this);
						break;
					case 1:
						gr.drawImage(carre1, j * FenetreTetris.TAILLE_CARRE, i
								* FenetreTetris.TAILLE_CARRE, this);
						break;
					case 2:
						gr.drawImage(carre2, j * FenetreTetris.TAILLE_CARRE, i
								* FenetreTetris.TAILLE_CARRE, this);
						break;
					case 3:
						gr.drawImage(carre3, j * FenetreTetris.TAILLE_CARRE, i
								* FenetreTetris.TAILLE_CARRE, this);
						break;
					case 4:
						gr.drawImage(carre4, j * FenetreTetris.TAILLE_CARRE, i
								* FenetreTetris.TAILLE_CARRE, this);
						break;
					case 5:
						gr.drawImage(carre5, j * FenetreTetris.TAILLE_CARRE, i
								* FenetreTetris.TAILLE_CARRE, this);
						break;
					case 6:
						gr.drawImage(carre6, j * FenetreTetris.TAILLE_CARRE, i
								* FenetreTetris.TAILLE_CARRE, this);
						break;
					case 7:
						gr.drawImage(carre7, j * FenetreTetris.TAILLE_CARRE, i * FenetreTetris.TAILLE_CARRE, this);
						break;
					default:
						gr.drawImage(carre0, j * FenetreTetris.TAILLE_CARRE, i
								* FenetreTetris.TAILLE_CARRE, this);
						break;
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		pieceSuivante = g.getPieceSuivante();
		grillePiece = pieceSuivante.recupererPiece(pieceSuivante.getSens());
		repaint();
	}
}
