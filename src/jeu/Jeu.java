package jeu;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Observable;

public class Jeu extends Observable implements Runnable {

	private boolean debutJeu, finJeu, finAnimFusee;
	private Grille g;
	private boolean pause;
	private int indexFusee;
	public static final int VITESSE_DEFAUT = 500;

	public Jeu() {
		debutJeu = false;
		finJeu = false;
		g = new Grille();
		pause = false;
		finAnimFusee = false;
		indexFusee = 0;
	}

	public void descentePiece(Grille g) {
		boolean finDeplacement = false;
		finDeplacement = (g.deplaceBas());
		System.out.println("Déplacement fini : "+finDeplacement);
		if (finDeplacement) {
			System.out.println("Possibilité nouvelle pièce : "+g.nouvellePiecePossible(g.getPieceSuivante()));
			if (g.lignePleine(Grille.HAUTEUR_GRILLE - 1))
				g.majScore();
			if (g.nouvellePiecePossible(g.getPieceSuivante())) {
				g.setPieceCourante(g.getPieceSuivante());
				g.setPieceSuivante(g.nouvellePiece());
			} else
			{
				//setFinJeu(this.controleFinJeu(g));
				setFinJeu(true);
			}
		}
		// g.dessinerGrille();
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

	public void setDebutJeu(boolean debut) {
		debutJeu = debut;
	}

	public boolean getDebutjeu() {
		return debutJeu;
	}

	public void run() {
		System.out.println("****** START ******");
		File f = new File("msc/zikdebut.mp3");
		Son test = new Son();
		try {
			test.playMP3(f.toURI().toURL().toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (!debutJeu) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

				break;
			}

		}
		System.out.println("Debut du jeu");
		test.mediaPlayer.stop();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

		}
		f = new File("msc/zik.mp3");

		test = new Son();

		try {
			test.playMP3(f.toURI().toURL().toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (!finJeu) {
			if (!pause) {
				try {
					Thread.sleep(VITESSE_DEFAUT - (g.getNiveau() * 100));
				} catch (InterruptedException e) {

					break;
				}
				descentePiece(g);
			}
		}

		test.mediaPlayer.stop();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

		}
		f = new File("msc/zikend.mp3");
		test = new Son();
		try {
			test.playMP3(f.toURI().toURL().toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (!finAnimFusee) {

			finAnimFusee = (indexFusee >= 8);
			try {
				Thread.sleep(1000);
				indexFusee++;
				setChanged();
				notifyObservers();
			} catch (InterruptedException e) {

				break;
			}

		}

		System.out.println("Game over");
	}

	public Grille getGrille() {
		return g;

	}

	public void setGrille(Grille g) {
		this.g = g;
	}

	public void pause() {
		pause = !pause;

	}

	public int getIndexFusee() {
		return indexFusee;
	}
}
