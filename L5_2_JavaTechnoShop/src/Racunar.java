public class Racunar extends Proizvod {
    private String[] konfiguracija;

    public Racunar(String sifra, String naziv, Proizvodjac proizvodjac, Double cijena, String[] konfiguracija) {
        super(sifra, naziv, proizvodjac, cijena);
        this.konfiguracija = konfiguracija;
    }

    public String[] getKonfiguracija() {
        return konfiguracija;
    }
}
