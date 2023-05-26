import com.sun.jdi.InvalidTypeException;

import java.io.Serializable;

public class Proizvod implements Serializable {
    protected String sifra;
    protected String naziv;

    protected Proizvodjac proizvodjac;
    protected Double cijena;

    public Proizvod() {
        sifra = naziv = "";
        cijena = 0.0;
    }

    public Proizvod(String sifra, String naziv, Proizvodjac proizvodjac, Double cijena) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
        this.cijena = cijena;
    }

    public String getNaziv() {
        return naziv;
    }
    public String getSifra() {
        return sifra;
    }

    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

    public Double getCijena() {
        return cijena;
    }

    @Override
    public String toString() {
        return  "Naziv: " + this.naziv
                + "\nCijena: " + this.cijena.toString()
                +"\nSifra: " + this.sifra
                + "\nProizvodjac: " + this.proizvodjac;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Proizvod) {
            Proizvod p = (Proizvod)other;

            if (this == other || this.sifra.equals(p.sifra)) {
                return true;
            }
            else return false;
        }

        else return false;
    }
}
