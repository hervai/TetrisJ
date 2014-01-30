public class Grille {

	public static final int LARGEUR_GRILLE = 10;
	public static final int HAUTEUR_GRILLE = 20;
	public static final int COL_APPARITION = 3;
	public static final int LIG_APPARITION = 0;

	private int[][] grille;
	private Piece pieceCourante = new Piece(); // pièce courante
	private Piece pieceSuivante = new Piece(); // pièce suivante

	public Grille() {
		grille = new int[HAUTEUR_GRILLE][LARGEUR_GRILLE];
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

	public boolean bloqueDroite() {
		int i = pieceCourante.getLig();
		int j = pieceCourante.getCol();
		int[][] piece = new int[4][4];
		piece = pieceCourante.recupererPiece();
		boolean bloque = false;

		for (int k = 0; k < 4; k++) {
			for (int l = 0; l < 4; l++) {

				if (piece[k][l] != 0) {
					if (j + l + 1 < grille[0].length) {
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

	public boolean deplaceBas() {
		boolean pieceBloquee = false;
		effacePiece();

		if (!bloqueBas()) {
			pieceCourante.setLig(pieceCourante.getLig() + 1);
		} else
			pieceBloquee = true;

		affichePiece();
		return pieceBloquee;
	}

	public boolean deplaceGauche() {
		boolean pieceBloquee = false;
		effacePiece();

		if (!bloqueGauche()) {
			pieceCourante.setCol(pieceCourante.getCol() - 1);
		} else
			pieceBloquee = true;

		affichePiece();
		return pieceBloquee;
	}

	public boolean deplaceDroite() {
		boolean pieceBloquee = false;
		effacePiece();

		if (!bloqueDroite()) {
			pieceCourante.setCol(pieceCourante.getCol() + 1);
		} else
			pieceBloquee = true;

		affichePiece();
		return pieceBloquee;
	}

	public Piece getPieceCourante() {
		return pieceCourante;
	}

	public void setPieceCourante(Piece pieceCourante) {
		this.pieceCourante = pieceCourante;
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
	}

	public void tournerPiece() {

		if (!bloqueRotation()) {
			if (pieceCourante.getSens() < 3)
				pieceCourante.setSens(pieceCourante.getSens() + 1);
			else
				pieceCourante.setSens(0);
		}

	}

	public boolean bloqueRotation() {
		// A CODER
		return false;
	}

}
