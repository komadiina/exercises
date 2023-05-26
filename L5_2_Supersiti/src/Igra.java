import java.util.*;
import java.util.Arrays;

public class Igra {
	private static final int BROJ_ZLIKOVACA = 6;

	public static String dioGrada(Integer x, Integer y) {
		if (x < 30) return "voda";
		else if (x < 60) {
			return "zemlja";
		}
		else return "vazduh";
		// x > 90 -> throw ali neka
	}

	public static void main(String[] args) {
		// Podesimo Supercity (30x90)
		Stanovnik[][] supercity = new Stanovnik[90][30];

		// Popunimo sa stanovnicima
		for (int i = 0; i < 90; i ++) {
			for (int j = 0; j < 30; j++) {
				supercity[i][j] = new Stanovnik("Supercity", "Resident");
			}
		}

		// Popunimo sa BROJ_ZLIKOVACA zlikovaca
		Random rnd = new Random();
		List<Integer> populatedX = new ArrayList<Integer>();
		List<Integer> populatedY = new ArrayList<Integer>();


		for (int k = 0; k < BROJ_ZLIKOVACA; k++)
		{
			Integer rndX = rnd.nextInt(90);
			Integer rndY = rnd.nextInt(30);

			while (populatedX.contains(rndX)){
				rndX = rnd.nextInt(90);
			}
			while (populatedY.contains(rndY)) {
				rndY = rnd.nextInt(30);
			}

			Boolean hasCryptonite = rnd.nextBoolean();
			supercity[rndX][rndY] = new Zlikovac(hasCryptonite);
			populatedX.add(rndX); populatedY.add(rndY);
		}

		// Ispisimo nasu matricu (supercity)
		for (int x = 0; x < 90; x++) {
			for (int y = 0; y < 30; y++) {
				if (supercity[x][y] instanceof Zlikovac)
					System.out.print("[Z] ");
				else System.out.print("[ ] ");
			}

			System.out.println();
		}

		// Pozovimo superheroje
		Batman batman = new Batman();
		Superman superman = new Superman();
		WonderWoman wonderWoman = new WonderWoman();
		Aquaman aquaman = new Aquaman();
		GreenArrow greenArrow = new GreenArrow();
		Supergirl supergirl = new Supergirl();

		Superheroj[] superheroji = { aquaman, batman, greenArrow, superman, supergirl, wonderWoman };

		// Zapocnimo simulaciju
		Integer brojZlikovaca = BROJ_ZLIKOVACA - 1; // 5

		while (brojZlikovaca >= 0) {
			Integer x = populatedX.get(brojZlikovaca);
			Integer y = populatedY.get(brojZlikovaca);

			Zlikovac zloco = (Zlikovac)supercity[x][y];
			String imeZlikovca = zloco.ime; String prezimeZlikovca = zloco.prezime;

			Superheroj zasluzeni = new Superheroj("", "");
			switch (dioGrada(x, y)) {
				case "zemlja":
					System.out.println("Zlikovac se nalazi u predjelu zemlje!");
					// Batman ili GreenArrow

					// Slucajno cemo izabrati heroja u predjelu djelovanja zemlje:
					Superheroj herojZemlja = superheroji[rnd.nextInt(superheroji.length - 1)];
					while (herojZemlja instanceof DjelovanjeZemlja == false) {
						herojZemlja = superheroji[rnd.nextInt(superheroji.length - 1)];
					}

					for (Integer shX = 30; shX < 60; shX++) {
						for (Integer shY = 0; shY < 30; shY++) {
							if (supercity[shX][shY].equals(herojZemlja)) {
								supercity[shX][shY] = new Stanovnik("Supercity", "Resident");
								break;
							}
							supercity[x][y] = new Stanovnik("Supercity", "Resident");
						}
					}
					// Unisten zlikovac
					brojZlikovaca--;
					supercity[x][y] = herojZemlja;
					zasluzeni = herojZemlja;

					System.out.println("Zlikovac " + imeZlikovca + " " + prezimeZlikovca + " je unisten od strane "
							+ zasluzeni);

					break;
				case "vazduh":
					System.out.println("Zlikovac se nalazi u predjelu vazduha!");
					// Slucajno cemo izabrati heroja u predjelu djelovanja vazduha:
					Superheroj randomHeroj = superheroji[rnd.nextInt(superheroji.length - 1)];
					while (randomHeroj instanceof DjelovanjeVazduh == false) {
						randomHeroj = superheroji[rnd.nextInt(superheroji.length - 1)];
					}

					if (zloco.imaKriptonit && randomHeroj instanceof Superman) {
						System.out.println("Zlikovac " + zloco + " unistava " + randomHeroj + "!");
					}
					else {
						for (Integer shX = 60; shX < 90; shX++) {
							for (Integer shY = 0; shY < 30; shY++) {
								if (supercity[x][y].equals(randomHeroj)) {
									supercity[shX][shY] = new Stanovnik("Supercity", "Resident");
									break;
								}

								supercity[x][y] = new Stanovnik("Supercity", "Resident");
							}
						}

						System.out.println("Zlikovac " + imeZlikovca + " " + prezimeZlikovca + " je unisten od strane " + randomHeroj);
						supercity[x][y] = randomHeroj;
						brojZlikovaca--;
					}

					break;
				case "voda":
					System.out.println("Zlikovac se nalazi u predjelu vode!");

					// Ukoliko postoji negdje, prepisimo ga Stanovnik-om
					for (Superheroj sh : superheroji) {
						if (sh instanceof DjelovanjeVoda) {
							for (Integer shX = 0; shX < 30; shX++) {
								for (Integer shY = 0; shY < 30; shY++) {
									if (supercity[shX][shY].equals(sh))
									{
										supercity[shX][shY] = new Stanovnik("Supercity", "Resident");
										break;
									}
								}
							}


						}
						supercity[x][y] = sh;
						zasluzeni = sh;
						break;
					}

					// Unisten zlikovac
					brojZlikovaca--;
					System.out.println("Zlikovac " + imeZlikovca + " " + prezimeZlikovca + " je unisten od strane "
							+ zasluzeni);

					break;
				default:
					// Nemoguce
					break;
			}
		}

		// Ispisimo nasu matricu (supercity)
		for (int x = 0; x < 90; x++) {
			for (int y = 0; y < 30; y++) {
				if (supercity[x][y] instanceof Zlikovac)
					System.out.print("[Z] ");
				else if (supercity[x][y] instanceof Superheroj)
					System.out.print("[S] ");
				else System.out.print("[ ] ");
			}

			System.out.println();
		}



		System.out.println("Broj preostalih zlikovaca: " + (brojZlikovaca+1));
		System.out.println("Justice League je opet spasila svijet!");
	}
}

