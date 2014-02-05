package jeu;
public class Jeu implements Runnable {

	private boolean finJeu;
	private Grille g;
	public static final int VITESSE_DEFAUT=500;
	public Jeu() {

		finJeu = false;
		g = new Grille();
		
	}

	public void descentePiece(Grille g) {
		boolean finDeplacement = false;
		finDeplacement = (g.deplaceBas());
	
		// g.rotationPiece();

		if (finDeplacement){
			if (g.lignePleine(Grille.HAUTEUR_GRILLE - 1))
				g.majScore();
			if (g.nouvellePiecePossible(g.getPieceSuivante())) {
				g.setPieceCourante(g.getPieceSuivante());
				g.setPieceSuivante(g.nouvellePiece());
			} else
				setFinJeu(this.controleFinJeu(g));
		}
		//g.dessinerGrille();
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
		System.out.println("****** START ******");
		//g.dessinerGrille();
		while (!finJeu) {

			try {
				Thread.sleep(VITESSE_DEFAUT - (g.getNiveau() * 100));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
			descentePiece(g);
			//g.getPieceSuivante().dessinerPiece();
		}
		System.out.println("Game over");
	}

	public Grille getGrille(){
		return g;
		
	}
	public void setGrille(Grille g){
		this.g=g;
	}
}
