package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jeu.*;

public class VueGrille extends JPanel implements Observer {
	private Grille g;
	private Jeu j;
	private Piece pieceSuivante;
	private int indexFusee;
	private int[][] grillePiece;
	private static final int DECALAGE_GRILLE_X = 81;
	private static final int DECALAGE_GRILLE_Y = 0;
	private static final int DECALAGE_PIECES_SUIV_X = 554;
	private static final int DECALAGE_PIECES_SUIV_Y = 96;
	private JLabel jscore, jniveau, jlignes;
	private int score, niveau, lignes;

	public VueGrille(Grille g, Jeu j) {
		this.g = g;
		this.j = j;
		indexFusee = j.getIndexFusee();
		// this.setLayout(null);
		g.addObserver(this);
		j.addObserver(this);
		Font f = new Font("Serif", Font.PLAIN, 32);

		setPreferredSize(new Dimension(Grille.LARGEUR_GRILLE
				* FenetreTetris.TAILLE_CARRE + 480, (Grille.HAUTEUR_GRILLE)
				* FenetreTetris.TAILLE_CARRE + 40));

		pieceSuivante = g.getPieceSuivante();
		grillePiece = pieceSuivante.recupererPiece(pieceSuivante.getSens());

		jscore = new JLabel("<html>" + score + "<br><br><br>" + niveau
				+ "<br><br><br>" + lignes + "</html>");

		jscore.setFont(f);

		add(Box.createRigidArea(new Dimension(620, 1070)));
		add(jscore);

		this.setVisible(true);

	}

	public void paintComponent(Graphics gr) {
		int valeurCase;
		Image image, carre0, carre1, carre2, carre3, carre4, carre5, carre6, carre7, carrebc, gameover, pressstart;
		Image[] fusee = new Image[9];
		// Background
		try {
			image = ImageIO.read(new File("img/background.jpg"));
			super.paintComponent(gr); // paint background
			if (image != null) { // there is a picture: draw it
				int height = this.getSize().height;
				int width = this.getSize().width;
				// g.drawImage(image, 0, 0, this); //use image size
				gr.drawImage(image, 0, 0, width, height, this);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Dessin de la grille
		try {
			carre0 = ImageIO.read(new File("img/carre0.jpg"));
			carre1 = ImageIO.read(new File("img/carre1.jpg"));
			carre2 = ImageIO.read(new File("img/carre2.jpg"));
			carre3 = ImageIO.read(new File("img/carre3.jpg"));
			carre4 = ImageIO.read(new File("img/carre4.jpg"));
			carre5 = ImageIO.read(new File("img/carre5.jpg"));
			carre6 = ImageIO.read(new File("img/carre6.jpg"));
			carre7 = ImageIO.read(new File("img/carre7.jpg"));
			carrebc = ImageIO.read(new File("img/carreblanc.jpg"));
			gameover = ImageIO.read(new File("img/gameover.jpg"));
			fusee[0] = ImageIO.read(new File("img/fusee0.jpg"));
			fusee[1] = ImageIO.read(new File("img/fusee1.jpg"));
			fusee[2] = ImageIO.read(new File("img/fusee2.jpg"));
			fusee[3] = ImageIO.read(new File("img/fusee3.jpg"));
			fusee[4] = ImageIO.read(new File("img/fusee4.jpg"));
			fusee[5] = ImageIO.read(new File("img/fusee5.jpg"));
			fusee[6] = ImageIO.read(new File("img/fusee6.jpg"));
			fusee[7] = ImageIO.read(new File("img/fusee7.jpg"));
			fusee[8] = ImageIO.read(new File("img/fusee8.jpg"));
			pressstart = ImageIO.read(new File("img/pressstart.jpg"));

			if (!j.getDebutjeu()) {
				gr.drawImage(pressstart, DECALAGE_GRILLE_X, 0, this);
			}

			else {

				if (!j.getFinjeu()) {
					for (int i = 0; i < Grille.HAUTEUR_GRILLE; i++) {
						for (int j = 0; j < Grille.LARGEUR_GRILLE; j++) {
							valeurCase = this.g.getGrille()[i][j];
							switch (valeurCase) {
							case 0:
								gr.drawImage(carre0, j
										* FenetreTetris.TAILLE_CARRE
										+ DECALAGE_GRILLE_X, i
										* FenetreTetris.TAILLE_CARRE, this);
								break;
							case 1:
								gr.drawImage(carre1, j
										* FenetreTetris.TAILLE_CARRE
										+ DECALAGE_GRILLE_X, i
										* FenetreTetris.TAILLE_CARRE, this);
								break;
							case 2:
								gr.drawImage(carre2, j
										* FenetreTetris.TAILLE_CARRE
										+ DECALAGE_GRILLE_X, i
										* FenetreTetris.TAILLE_CARRE, this);
								break;
							case 3:
								gr.drawImage(carre3, j
										* FenetreTetris.TAILLE_CARRE
										+ DECALAGE_GRILLE_X, i
										* FenetreTetris.TAILLE_CARRE, this);
								break;
							case 4:
								gr.drawImage(carre4, j
										* FenetreTetris.TAILLE_CARRE
										+ DECALAGE_GRILLE_X, i
										* FenetreTetris.TAILLE_CARRE, this);
								break;
							case 5:
								gr.drawImage(carre5, j
										* FenetreTetris.TAILLE_CARRE
										+ DECALAGE_GRILLE_X, i
										* FenetreTetris.TAILLE_CARRE, this);
								break;
							case 6:
								gr.drawImage(carre6, j
										* FenetreTetris.TAILLE_CARRE
										+ DECALAGE_GRILLE_X, i
										* FenetreTetris.TAILLE_CARRE, this);
								break;
							case 7:
								gr.drawImage(carre7, j
										* FenetreTetris.TAILLE_CARRE
										+ DECALAGE_GRILLE_X, i
										* FenetreTetris.TAILLE_CARRE, this);
								break;
							default:
								gr.drawImage(carre0, j
										* FenetreTetris.TAILLE_CARRE
										+ DECALAGE_GRILLE_X, i
										* FenetreTetris.TAILLE_CARRE, this);
								break;
							}
						}
					}
				} else {
					if (!g.victoire()) {
						// YOU DIED
						gr.drawImage(gameover, DECALAGE_GRILLE_X, 0, this);
					} else {
						// DECOLAGE FUSEE
						gr.drawImage(fusee[indexFusee], DECALAGE_GRILLE_X, 0,
								this);
					}
				}

				// Dessin pièce suivante
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {

						valeurCase = grillePiece[i][j];

						switch (valeurCase) {
						case 0:
							gr.drawImage(carrebc, j
									* FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_X, i
									* FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_Y, this);
							break;
						case 1:
							gr.drawImage(carre1, j * FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_X, i
									* FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_Y, this);
							break;
						case 2:
							gr.drawImage(carre2, j * FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_X, i
									* FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_Y, this);
							break;
						case 3:
							gr.drawImage(carre3, j * FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_X, i
									* FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_Y, this);
							break;
						case 4:
							gr.drawImage(carre4, j * FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_X, i
									* FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_Y, this);
							break;
						case 5:
							gr.drawImage(carre5, j * FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_X, i
									* FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_Y, this);
							break;
						case 6:
							gr.drawImage(carre6, j * FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_X, i
									* FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_Y, this);
							break;
						case 7:
							gr.drawImage(carre7, j * FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_X, i
									* FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_Y, this);
							break;
						default:
							gr.drawImage(carrebc, j
									* FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_X, i
									* FenetreTetris.TAILLE_CARRE
									+ DECALAGE_PIECES_SUIV_Y, this);
							break;
						}
					}
				}
				// Fin dessin pièce suivante
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		pieceSuivante = g.getPieceSuivante();
		grillePiece = pieceSuivante.recupererPiece(pieceSuivante.getSens());
		score = g.getScore();
		niveau = g.getNiveau();
		lignes = g.getNouvellesLignes();
		indexFusee = j.getIndexFusee();
		jscore.setText("<html>" + score + "<br><br><br>" + niveau
				+ "<br><br><br>" + lignes + "</html>");
		repaint();

	}
}
