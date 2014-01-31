public class Prg {

	public static void main(String[] args) {
		Thread t = new Thread(new Jeu());
		t.start();
		System.out.println("Game over MAIN");
		
	}

}
