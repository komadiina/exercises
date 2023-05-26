import java.util.*;
public class Lager {
    public List<Proizvod> getNaStanju() {
        return naStanju;
    }

    public List<Proizvod> naStanju = new ArrayList<Proizvod>();

    public Lager() {
        this.naStanju = new ArrayList<Proizvod>();
    }

    public Lager(List<Proizvod> naStanju) {
        this.naStanju = naStanju;
    }

    public void dodajProizvod(Proizvod p) {
        if (this.naStanju.contains(p) == false)
            this.naStanju.add(p);
    }

    public void izbaciProizvod(Proizvod p) {
        try {
            this.naStanju.removeIf(kp -> kp.equals(p));
        } catch (Exception ex) {
            System.out.println();
        }
    }
}
