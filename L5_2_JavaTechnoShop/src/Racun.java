import java.util.*;
import java.time.*;

public class Racun {
    private List<KupljenProizvod> korpa = new ArrayList<KupljenProizvod>();
    private Double iznos = 0.0;

    public Racun() {
        this.korpa = new ArrayList<KupljenProizvod>();
        this.iznos = 0.0;
    }

    public Double getIznos() { return this.iznos; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (KupljenProizvod kp : this.korpa) {
            sb.append(kp.toString());
        }

        return sb.toString() + "\n";
    }

    public void dodajProizvod(Proizvod p) {
        LocalDateTime ldt = LocalDateTime.now();
        KupljenProizvod kp = new KupljenProizvod(p, ldt);

        this.korpa.add(kp);
        this.iznos += p.getCijena();
    }

    public void izbaciProizvod(Proizvod p) throws ProizvodNePostojiException {
        try {
            this.korpa.removeIf(kp -> kp.proizvod.getSifra().equals(p.getSifra()));
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
