package labovi.deveti.cetvrti;

import java.util.*;

public class IstorijaIscrtavanja {
    public List<List<? extends Oblik>> iscrtavanja = new ArrayList<>();

    public void dodajIscrtavanje(List<? extends Oblik> oblici) {
        iscrtavanja.add(oblici);

        for (Oblik o : oblici)
            o.iscrtaj();
    }

    public void ispisIscrtavanja() {
        Integer brojKrugova = 0, brojPravougaonika = 0, brojPTrouglova = 0;

        for (List<? extends Oblik> listaIscrtavanja : this.iscrtavanja) {
            for (Oblik o : listaIscrtavanja)
            {
                if (o instanceof Krug)
                    brojKrugova++;
                else if (o instanceof Pravougaonik)
                    brojPravougaonika++;
                else if (o instanceof PravougliTrougao)
                    brojPTrouglova++;
            }
        }

        System.out.println("Broj ispisanih oblika: " + (brojKrugova + brojPravougaonika + brojPTrouglova));
        System.out.println("Broj krugova: " + brojKrugova);
        System.out.println("Broj pravougaonika: " + brojPravougaonika);
        System.out.println("Broj p. trouglova: " + brojPTrouglova);
    }
}
