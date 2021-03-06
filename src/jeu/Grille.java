package jeu;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Herve
 * 
 */

public class Grille extends Observable {

	public static final int LARGEUR_GRILLE = 10;
	public static final int HAUTEUR_GRILLE = 20;
	public static final int COL_APPARITION = 3;
	public static final int LIG_APPARITION = 0;
	public static final int SCORE_VICTOIRE=3;
	private ArrayList<Observer> listObservateur = new ArrayList<Observer>();

	private int[][] grille;
	private Piece pieceCourante; // pi�ce courante
	private Piece pieceSuivante; // pi�ce suivante
	private int score, niveau, nouvellesLignes;

	public Grille() {
		pieceSuivante = new Piece(nouvellePiece());
		pieceCourante = new Piece(nouvellePiece());

		grille = new int[HAUTEUR_GRILLE][LARGEUR_GRILLE];
		score = 0;
		nouvellesLignes = 0;
		niveau = 0;

		this.affichePiece();

	}

	public void setGrille(int[][] g) {
		grille = g;

	}

	public int[][] getGrille() {
		return grille;
	}

	public Piece nouvellePiece() {

		int typePiece = Math.round((float) Math.random() * 6);
		Piece p = new Piece(typePiece);
		p.setCol(COL_APPARITION);
		p.setLig(LIG_APPARITION);
		return p;

	}

	public void effacePiece() {
		int x, y;
		x = pieceCourante.getCol();
		y = pieceCourante.getLig();
		int[][] piece = pieceCourante.recupererPiece();

		for (int i = y; i < y + 4; i++) {
			for (int j = x; j < x + 4; j++) {
				if (i < 20) {
					if (piece[i - y][j - x] != 0) {
						grille[i][j] = 0;
					}
				}

			}
		}
		setChanged();
		notifyObservers();

	}

	public void affichePiece() {
		int x, y;
		x = pieceCourante.getCol();
		y = pieceCourante.getLig();
		int[][] piece = pieceCourante.recupererPiece();

		for (int i = y; i < y + 4; i++) {
			for (int j = x; j < x + 4; j++) {
				if (i < 20) {
					if (piece[i - y][j - x] != 0) {
						grille[i][j] = piece[i - y][j - x];
					}
				}
			}
		}
		setChanged();
		notifyObservers();

	}

	public boolean bloqueDroite() {
		int i = pieceCourante.getLig();
		int j = pieceCourante.getCol();
		int[][] piece = new int[4][4];
		piece = pieceCourante.recupererPiece();
		boolean bloque = false;

		for (int k = 0; k < 4; k++) {
			for (int l = 0; l < 4; l++) {

				if (piece[k][l] != 0) {
					if (j + l + 1 < 10) {
						if (grille[i + k][j + l + 1] != 0) {
							bloque = true;
						}

					} else
						bloque = true;

				}
			}
		}

		return bloque;

	}

	public boolean bloqueGauche() {
		int i = pieceCourante.getLig();
		int j = pieceCourante.getCol();
		int[][] piece = new int[4][4];
		piece = pieceCourante.recupererPiece();
		boolean bloque = false;

		for (int k = 0; k < 4; k++) {
			for (int l = 0; l < 4; l++) {

				if (piece[k][l] != 0) {
					if (j + l - 1 >= 0) {
						if (grille[i + k][j + l - 1] != 0) {
							bloque = true;
						}

					} else
						bloque = true;

				}
			}
		}
		return bloque;
	}

	public boolean bloqueBas() {
		int i = pieceCourante.getLig();
		int j = pieceCourante.getCol();
		int[][] piece = new int[4][4];
		piece = pieceCourante.recupererPiece();
		boolean bloque = false;

		for (int k = 0; k < 4; k++) {
			for (int l = 0; l < 4; l++) {

				if (piece[k][l] != 0) {
					if (i + k + 1 < 20) {
						if (grille[i + k + 1][j + l] != 0) {
							bloque = true;
						}

					} else
						bloque = true;

				}
			}
		}
		return bloque;
	}

	public boolean bloqueRotation() {
		int i = pieceCourante.getLig();
		int j = pieceCourante.getCol();
		int[][] piece = new int[4][4];
		int sens = pieceCourante.getSens();
		int sensProchain;
		boolean bloque = false;

		if (sens < 3)
			sensProchain = sens + 1;
		else
			sensProchain = 0;

		piece = pieceCourante.recupererPiece(sensProchain);

		for (int k = 0; k < 4; k++) {
			for (int l = 0; l < 4; l++) {

				if (piece[k][l] != 0) {
					if (grille[i + k][j + l] != 0) {
						bloque = true;

					}
				}
			}
		}
		return bloque;
	}

	/**
	 * @return renvoie true si le d�placement n'a pas �t� effectu�
	 */
	public boolean deplaceDroite() {
		boolean finDeplacement = false;
		effacePiece();

		if (!bloqueDroite()) {
			pieceCourante.setCol(pieceCourante.getCol() + 1);
			setChanged();
			notifyObservers();

		} else
			finDeplacement = true;

		affichePiece();
		return finDeplacement;
	}

	/**
	 * @return renvoie true si le d�placement n'a pas �t� effectu�
	 */
	public boolean deplaceGauche() {
		boolean finDeplacement = false;
		effacePiece();

		if (!bloqueGauche()) {
			pieceCourante.setCol(pieceCourante.getCol() - 1);
			setChanged();
			notifyObservers();

		} else
			finDeplacement = true;

		affichePiece();
		return finDeplacement;
	}

	/**
	 * @return renvoie true si le d�placement n'a pas �t� effectu�
	 */
	public boolean deplaceBas() {
		boolean finDeplacement = false;
		effacePiece();

		if (!bloqueBas()) {
			pieceCourante.setLig(pieceCourante.getLig() + 1);
			setChanged();
			notifyObservers();

		} else {
			finDeplacement = true;

		}
		affichePiece();

		return finDeplacement;
	}

	public boolean rotationPiece() {

		boolean finRotation = false;

		effacePiece();
		if (!bloqueRotation()) {
			pieceCourante.tournerPiece();
			setChanged();
			notifyObservers();

		} else {
			finRotation = true;
		}

		affichePiece();
		return finRotation;
	}

	public Piece getPieceCourante() {
		return pieceCourante;
	}

	public void setPieceCourante(Piece pieceCourante) {
		this.pieceCourante = pieceCourante;
		this.affichePiece();

	}

	public void dessinerGrille() {

		for (int i = 0; i < Grille.HAUTEUR_GRILLE; i++) {
			System.out.println("______________________________");
			for (int j = 0; j < Grille.LARGEUR_GRILLE; j++) {
				System.out.print("|" + this.getGrille()[i][j] + "|");

			}
			System.out.print("\n");

		}
		System.out.println("+++++++++++++++++++++++++++++++");
	}

	public Piece getPieceSuivante() {
		return pieceSuivante;
	}

	public void setPieceSuivante(Piece pieceSuivante) {
		this.pieceSuivante = pieceSuivante;
		setChanged();
		notifyObservers();
	}

	public boolean nouvellePiecePossible(Piece p) {
		boolean npPossible = true;
		int[][] piece = p.recupererPiece();
		int[][] grille = this.getGrille();

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (piece[i][j] != 0) {
					if (grille[i + Grille.LIG_APPARITION][j + COL_APPARITION] != 0)
						npPossible = false;
				}
			}
		}

		return npPossible;
	}

	public boolean lignePleine(int numLigne) {
		boolean supprLigne = true;
		int[][] grille = this.getGrille();
		int ligne = numLigne;
		for (int l = 0; l < Grille.LARGEUR_GRILLE; l++) {
			if (grille[ligne][l] == 0) {
				supprLigne = false;
			}
		}
		if (ligne > 0)
			this.lignePleine(ligne - 1);
		if (supprLigne) {
			nouvellesLignes++;
			
			this.lignePleine(ligne - 1);
			if (ligne > 0)
				
			supprimerLigne(ligne);
		}

		return supprLigne;
	}

	public void supprimerLigne(int ligne) {
		int l = ligne;

		

		for (int i = l - 1; i > 0; i--) {
			for (int j = 0; j < Grille.LARGEUR_GRILLE; j++) {
				grille[i+1][j] = grille[i][j];
			}
			System.out.println("D�calage ligne fini");
			setChanged();
			notifyObservers();

		}
	}

	public void majScore() {
		
		score = score + nouvellesLignes;
		niveau = nouvellesLignes / 10;

		setChanged();
		notifyObservers();

	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public int getNouvellesLignes() {
		return nouvellesLignes;
	}

	public void setNouvellesLignes(int nouvellesLignes) {
		this.nouvellesLignes = nouvellesLignes;
	}

	public boolean victoire(){
		return(score>=SCORE_VICTOIRE);
	}
}
