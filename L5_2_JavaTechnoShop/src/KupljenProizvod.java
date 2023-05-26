import java.time.LocalDateTime;
import java.util.Date;

public class KupljenProizvod {
    public Proizvod proizvod = new Proizvod();
    public LocalDateTime datumKupovine;

    public KupljenProizvod(Proizvod proizvod, LocalDateTime datumKupovine) {
        this.proizvod = proizvod;
        this.datumKupovine = datumKupovine;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public LocalDateTime getDatumKupovine() {
        return datumKupovine;
    }

    @Override
    public String toString() {
        return this.proizvod.toString() + "\nDatum kupovine: " + this.datumKupovine.toString() + "\n";
    }
}
