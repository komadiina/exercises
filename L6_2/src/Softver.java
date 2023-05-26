import java.io.Serializable;

public class Softver extends Proizvod implements Serializable {
    private String opis;

    public Softver(String sifra, String naziv, Proizvodjac proizvodjac, Double cijena, String opis) {
        super(sifra, naziv, proizvodjac, cijena);
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }
}
