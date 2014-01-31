public class Jeu implements Runnable {

	private boolean finJeu;
	private Grille g;

	public Jeu() {

		finJeu = false;
		g = new Grille();
		
	}

	public void descentePiece(Grille g) {
		boolean finDeplacement = false;
		finDeplacement = (g.deplaceBas());
		// g.rotationPiece();

		if (finDeplacement)
			if (g.nouvellePiecePossible(g.getPieceSuivante())) {
				g.setPieceCourante(g.getPieceSuivante());
				g.setPieceSuivante(g.nouvellePiece());
			} else
				setFinJeu(this.controleFinJeu(g));

		g.dessinerGrille();
	}

	public boolean controleFinJeu(Grille g) {
		int[][] grilleDuJeu = g.getGrille();
		for (int j = 0; j < grilleDuJeu[0].length; j++) {
			if (grilleDuJeu[0][j] != 0)
				setFinJeu(true);
		}
		return finJeu;
	}

	public void setFinJeu(boolean fin) {
		finJeu = fin;
	}

	public boolean getFinjeu() {
		return finJeu;
	}

	public void run() {
		g.dessinerGrille();
		while (!finJeu) {

			try {
				Thread.sleep(1500 - (g.getNiveau() * 100));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
			descentePiece(g);
			g.getPieceSuivante().dessinerPiece();
		}
		System.out.println("Game over");
	}

}
