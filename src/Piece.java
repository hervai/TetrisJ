public class Piece {

	// Propri�t�s d'une pi�ce
	private int type; // type de pi�ce
	private int sens; // sens de la pi�ce
	private int col; // absisse de la pi�ce
	private int lig; // ordon�e de la pi�ce
	private int[][] dessin;

	public Piece() {
		type = 0;
		sens = 0;
		col = 0;
		lig = 0;
		dessin = null;
	}

	public Piece(int type) {
		this.type = type;
		sens = 0;
		col = 0;
		lig = 0;
		dessin = this.recupererPiece();

	}

	public Piece(Piece p) {
		this.type = p.getType();
		this.sens = p.getSens();
		this.col = p.getCol();
		this.lig = p.getLig();

	}

	public int[][] recupererPiece() {
		int type, sens;
		int[][] resultat=null;
		type = this.getType();
		sens = this.getSens();

		for (int i = 0; i < FabriquePiece.PIECES[sens][type].length; i++) {
			for (int j = 0; j < FabriquePiece.PIECES[sens][type][0].length; j++) {
				resultat[i][j] = FabriquePiece.PIECES[sens][type][i][j];
			}
		}
		return resultat;
	}

	public int getType() {
		return type;
	}

	public void setType(int t) {
		type = t;
	}

	public int getSens() {
		return sens;
	}

	public void setSens(int r) {
		sens = r;
	}

	public int getCol() {
		return col;

	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getLig() {
		return lig;

	}

	public void setLig(int lig) {
		this.lig = lig;
	}

	public void tournerPiece() {

		if (sens < 3)
			sens++;
		else
			sens = 0;
	}

	public void dessinerPiece() {
		System.out.print("____________");
		for (int i = 0; i < 4; i++) {
			System.out.println("");
			for (int j = 0; j < 4; j++) {
				System.out.print("|" + dessin[i][j] + "|");

			}
		}
		System.out.println("");
		System.out.println("____________");

	}

}
