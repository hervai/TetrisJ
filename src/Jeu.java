import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Jeu extends Thread implements KeyListener {

	private int score, niveau, lignes;
	private boolean finJeu;
	private Grille g;

	public Jeu() {
		score = 0;
		lignes = 0;
		niveau = 0;
		finJeu = false;
		g = new Grille();
		this.start();
	}

	public void nouveauTour(Grille g) {
		g.setPieceCourante(g.getPieceSuivante());
		g.setPieceSuivante(g.nouvellePiece());
		g.affichePiece();
		g.dessinerGrille();
	}

	public void descentePiece(Grille g) {
		boolean finDeplacement = false;
		finDeplacement = (g.deplaceBas());

		if (finDeplacement)
			if (g.nouvellePiecePossible(g.getPieceSuivante())) {
				g.setPieceCourante(g.getPieceSuivante());
				g.setPieceSuivante(g.nouvellePiece());
			} else
				setFinJeu(true);
		g.dessinerGrille();
	}

	public void premierTour(Grille g) {
		g.setPieceCourante(g.nouvellePiece());
		g.setPieceSuivante(g.nouvellePiece());
		System.out.println("");
		g.affichePiece();
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
		while ((Thread.currentThread() == this) && (!this.isInterrupted())
				&& (!finJeu)) {
			descentePiece(g);
			try {
				Thread.sleep(20 - (niveau * 150));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
		}
		System.out.println("Game over");
		Thread.currentThread().interrupt();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
