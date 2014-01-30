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

		for (int i = y; i < y + 4; i++) {
			for (int j = x; j < x + 4; j++) {
				if (i < 20)
					grille[i][j] = 0;
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
					if (piece[i - y][j - x] != 0)
						grille[i][j] = piece[i - y][j - x];
				}
			}
		}
	}

	public boolean bloqueDroite() {
		boolean b = false;
		// A CODER
		return b;

	}

	public boolean bloqueGauche() {
		// A CODER
		return false;
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
					if ((grille[i + k + 1][j] != 0) || (i + k + 1 == 19)) {
						bloque = true;
					}

				}
			}

		}

		return bloque;
	}

	public void deplaceBas() {
		System.out.println(pieceCourante.getLig() + " "
				+ pieceCourante.getCol());

		effacePiece();
		if (!bloqueBas()) {
			pieceCourante.setLig(pieceCourante.getLig() + 1);
		}
		affichePiece();
	}

	public Piece getPieceCourante() {
		return pieceCourante;
	}

	public void setPieceCourante(Piece pieceCourante) {
		this.pieceCourante = pieceCourante;
	}

}
