package labovi.deveti.cetvrti;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Krug k = new Krug(3.14);
        Pravougaonik p = new Pravougaonik(5, 2);
        PravougliTrougao pt = new PravougliTrougao(4, 3);

        IstorijaIscrtavanja ii = new IstorijaIscrtavanja();
        ii.dodajIscrtavanje(Arrays.asList(k, p, pt));
        ii.dodajIscrtavanje(Arrays.asList(k, k, pt));
        ii.dodajIscrtavanje(Arrays.asList(pt, p, k));

        ii.ispisIscrtavanja();
    }
}
