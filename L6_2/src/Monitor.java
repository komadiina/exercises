import java.io.Serializable;

public class Monitor extends Proizvod implements Serializable {
    public String[] konfiguracija;
    public String model;

    public Monitor(String sifra, String naziv,
                   Proizvodjac proizvodjac,
                   Double cijena, String[] konfiguracija,
                   String model) {
        super(sifra, naziv, proizvodjac, cijena);
        this.konfiguracija = konfiguracija;
        this.model = model;
    }

    public String[] getKonfiguracija() {
        return konfiguracija;
    }

    public String getModel() {
        return model;
    }

}
