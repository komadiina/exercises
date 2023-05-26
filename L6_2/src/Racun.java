import java.util.*;
import java.time.*;
import java.io.Serializable;
import java.lang.*;

public class Racun implements Serializable, Cloneable {
    private List<KupljenProizvod> korpa = new ArrayList<KupljenProizvod>();
    private Double iznos = 0.0;

    public Racun() {
        this.korpa = new ArrayList<KupljenProizvod>();
        this.iznos = 0.0;
    }

    @Override
    public Racun clone() throws RuntimeException {
        try {
            Racun novi = (Racun)super.clone();
            novi.korpa = new ArrayList<>(this.korpa);
            novi.iznos = this.iznos;
            return novi;
        } catch (CloneNotSupportedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Double getIznos() { return this.iznos; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (KupljenProizvod kp : this.korpa) {
            sb.append(kp.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    public void dodajProizvod(Proizvod p) {
        LocalDateTime ldt = LocalDateTime.now();
        KupljenProizvod kp = new KupljenProizvod(p, ldt);

        this.korpa.add(kp);
        this.iznos += p.getCijena();
    }

    public void izbaciProizvod(Proizvod p) throws ProizvodNePostojiException {
        try {
            // Brise sva pojavljivanja proizvoda (brise sve proizvode cak iako ih ima vise)
//            this.korpa.removeIf(kp -> kp.proizvod.getSifra().equals(p.getSifra()));
            for (KupljenProizvod kp : this.korpa) {
                if (kp.proizvod.getSifra().equals(p.getSifra())) {
                    this.korpa.remove(kp);
                    break;
                }
            }
        } catch (Exception ex) {
            throw new ProizvodNePostojiException("Proizvod se ne nalazi u korpi!");
        }
    }

    public Double zavrsiKupovinu() {
        Double temp = this.iznos;
        this.iznos = 0.0;
        this.korpa.clear();

        return temp;
    }
}
