import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class KupljenProizvod implements Serializable {
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
        return this.proizvod.toString() + "Datum kupovine: " + this.datumKupovine.toString() + "\n";
    }
}
