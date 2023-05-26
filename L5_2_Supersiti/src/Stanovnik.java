public class Stanovnik {
	public String ime, prezime;

	public Stanovnik(String ime, String prezime) {
		this.ime = ime; this.prezime = prezime;
	}

	public String toString() {
		return this.ime + " " + this.prezime;
	}
}