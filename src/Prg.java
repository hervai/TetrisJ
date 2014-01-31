public class Prg {

	public static void main(String[] args) {
		Thread t = new Thread(new Jeu());
		System.out.println("****** START ******");
		t.start();
	}

}
