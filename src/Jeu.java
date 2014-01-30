public class Jeu {

	private int score, niveau, lignes;

	public static void main(String[] args) {
		boolean fin = false;
		// TODO Auto-generated method stub
		Jeu jeu = new Jeu();
		Grille g = new Grille();
		Piece pc = g.nouvellePiece();
		System.out.println("");
		g.majPieceCourante(pc);
		g.affichePiece(pc);
		jeu.dessinerGrille(g);
		
		while (!fin) {

			g.deplaceBas(pc);
			jeu.dessinerGrille(g);
			fin=(g.bloqueBas(pc));
		}
		
		pc = g.nouvellePiece();
		System.out.println("");
		g.majPieceCourante(pc);
		g.affichePiece(pc);
		jeu.dessinerGrille(g);
		fin=false;
		while (!fin) {

			g.deplaceBas(pc);
			jeu.dessinerGrille(g);
			fin=(g.bloqueBas(pc));
		}
		
		System.out.println("Fin de partie");
	}

	public Jeu() {
		score = 0;
		lignes = 0;
		niveau = 0;
	}

	public void dessinerGrille(Grille g) {

		for (int i = 0; i < Grille.HAUTEUR_GRILLE; i++) {
			System.out.println("______________________________");
			for (int j = 0; j < Grille.LARGEUR_GRILLE; j++) {
				System.out.print("|" + g.getGrille()[i][j] + "|");

			}
			System.out.print("\n");

		}
		System.out.println("+++++++++++++++++++++++++++++++");
	}
}
