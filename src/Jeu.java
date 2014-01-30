public class Jeu {

	private int score, niveau, lignes;

	public static void main(String[] args) {
		boolean finJeu = false;
		boolean finTour = false;
		Jeu jeu = new Jeu();
		Grille g = new Grille();

		g.setPieceCourante(g.nouvellePiece());
		System.out.println("");
		g.affichePiece();
		jeu.dessinerGrille(g);

		while (!finTour) {

			g.deplaceBas();
			jeu.dessinerGrille(g);
			finTour = (g.bloqueBas());

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
