
import java.time.Year;
import java.util.*;

public class Film {
    protected String nazivFilma;
    protected Integer godinaObjavljivanja;
    protected String[] glumci = new String[5];
    protected Double ocjena;

    public Double getOcjena() {
        return ocjena;
    }

    public Film() {
        this.nazivFilma = "";
        this.godinaObjavljivanja = -1;
        this.glumci = new String[5];
        this.ocjena = 0.0;
    }

    public Film(String nazivFilma, Integer godinaObjavljivanja, String[] glumci, Double ocjena) {
        this.nazivFilma = nazivFilma;
        this.godinaObjavljivanja = godinaObjavljivanja;
        this.glumci = glumci;
        this.ocjena = ocjena;
    }

    @Override
    public String toString() {
        String izlaz = "Film: " + this.nazivFilma;
        izlaz += "\nGodina: " + this.godinaObjavljivanja;
        izlaz += "\nProsjecna ocjena: " + this.ocjena.toString();

        izlaz += "\nGlumci: ";
        for (String glumac : glumci) {
            izlaz += glumac + ", ";
        }

        return izlaz;
    }

    public Boolean imaGlumac(String glumac) {
        for (String g : this.glumci) {
            if (g.equals(glumac))
                return true;
        }

        return false;
    }

    public Boolean imaGlumacCI(String glumac) {
        // String::compareToIgnoreCase

        glumac = glumac.toLowerCase();
        List<String> str = Arrays.stream(this.glumci).map(g -> g.toLowerCase()).toList();
        return str.contains(glumac);
    }

    public Integer kolikoStar() {
        return Year.now().getValue() - this.godinaObjavljivanja;
    }

    public Boolean nazivSadrziRijec(String rijec) {
        return this.nazivFilma.contains(rijec);
    }
}
