public class Jeu {

	private int score, niveau, lignes;

	public static void main(String[] args) {
		boolean finJeu = false;
		boolean finTour = false;
		int compteurPiece = 0;

		Jeu jeu = new Jeu();
		Grille g = new Grille();

		premierTour(g);

		while (!finJeu) {
			descentePiece(g);

			finJeu = controleFinJeu(g);
			nouveauTour(g);

			// compteurPiece++;
		}

		System.out.println("");

		descentePiece(g);

		System.out.println("Fin de partie");
	}

	public Jeu() {
		score = 0;
		lignes = 0;
		niveau = 0;
	}

	public static void nouveauTour(Grille g) {
		g.setPieceCourante(g.getPieceSuivante());
		g.setPieceSuivante(g.nouvellePiece());
		g.affichePiece();
		g.dessinerGrille();
	}

	public static void descentePiece(Grille g) {
		boolean finTour = false;
		while (!finTour) {
			g.deplaceDroite();
			finTour = g.deplaceBas();
			g.dessinerGrille();
		}
	}

	public static void premierTour(Grille g) {
		g.setPieceCourante(g.nouvellePiece());
		g.setPieceSuivante(g.nouvellePiece());
		System.out.println("");
		g.affichePiece();
		g.dessinerGrille();
	}

	public static boolean controleFinJeu(Grille g) {
		boolean finJeu = false;
		int[][] grilleDuJeu = g.getGrille();
		for (int j = 0; j < grilleDuJeu[0].length; j++) {
			if (grilleDuJeu[0][j] != 0)
				finJeu = true;
		}
		return finJeu;
	}
}
