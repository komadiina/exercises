import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.*;

public class Cjenovnik {
    private List<Proizvod> proizvodi = new ArrayList<Proizvod>();

    public Cjenovnik() {}

    public Cjenovnik(Proizvod p) {
        this.proizvodi.add(p);
    }

    public Cjenovnik(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Proizvod p : this.proizvodi) {
            sb.append(p.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    public Proizvod getProizvodSaSifrom(String sifra) throws ProizvodNePostojiException {
        for (Proizvod p : this.proizvodi) {
            if (p.getSifra().equals(sifra))
                return p;
        }

        throw new ProizvodNePostojiException();
    }

    public Proizvod getProizvodSaNazivom(String naziv) throws ProizvodNePostojiException {
        for (Proizvod p : this.proizvodi) {
            if (p.getNaziv().compareToIgnoreCase(naziv) == 0) {
                return p;
            }
        }

        throw new ProizvodNePostojiException();
    }
}
