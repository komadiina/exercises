public class Zlikovac extends Stanovnik {
	public boolean imaKriptonit;

	public Zlikovac(String ime, String prezime, boolean kriptonit) {
		super(ime, prezime);
		this.imaKriptonit = kriptonit;

	}

	public Zlikovac(boolean	kriptonit) { super("Zli", "Zloco");
		imaKriptonit = kriptonit;
	}

	public Zlikovac() {
		super("Zli", "Zloco");
		imaKriptonit = false;
	}
}