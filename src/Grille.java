public class Grille {

	public static final int LARGEUR_GRILLE = 10;
	public static final int HAUTEUR_GRILLE = 20;
	public static final int COL_APPARITION = 3;
	public static final int LIG_APPARITION = 0;

	private int[][] grille;
	public static Piece piececourante = new Piece(); // pièce courante
	public static Piece pieceSuivante = new Piece(); // pièce suivante

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

		int typePiece = (int) ((Math.random() - 0.00001) * 7);
		Piece p = new Piece(typePiece);
		p.setCol(COL_APPARITION);
		p.setLig(LIG_APPARITION);

		return p;
	}

	public void effacePiece(Piece p) {
		int x, y;
		x = p.getCol();
		y = p.getLig();

		for (int i = y; i < y + 4; i++) {
			for (int j = x; j < x + 4; j++) {
				if (i < 20)
					grille[i][j] = 0;
			}
		}
	}

	public void affichePiece(Piece p) {
		int x, y;
		x = p.getCol();
		y = p.getLig();
		int[][] piece = p.recupererPiece();

		for (int i = y; i < y + 4; i++) {
			for (int j = x; j < x + 4; j++) {
				if (i < 20) {
					if (piece[i - y][j - x] != 0)
						grille[i][j] = piece[i - y][j - x];
				}
			}
		}
	}

	public boolean bloqueDroite(Piece p) {
		boolean b = false;

		return b;

	}

	public boolean bloqueGauche(Piece p) {

		return false;
	}

	public boolean bloqueBas(Piece p) {
		int x = p.getCol();
		int y = p.getLig();
		boolean bloque = false;

		System.out.println("X : " + x + " Y : " + y);
		if ((y + 4) < 20) {
			if (grille[y + 1][x] != 0)
				bloque = true;
		} else {
			System.out.println("bloque else");
			bloque = true;

		}
		return bloque;
	}

	public void deplaceBas(Piece p) {

		effacePiece(p);
		if (!bloqueBas(p)) {
			// if (p.getY() < 19) {
			p.setLig(p.getLig() + 1);
			// }
		}
		affichePiece(p);
	}

}
