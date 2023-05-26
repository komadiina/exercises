package labovi.deveti.osmi;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Loto645 igra = new Loto645();

        // Namjestimo jedno kolo
        Kolo namjesteno = new Kolo();
        namjesteno.rigged = true; // 1, 2, 3, 4, 5, 6
        try {
            namjesteno.odigrajTiket(new Tiket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        } catch (NevazeciTiketException ex) {;}
        igra.odigrajKolo(namjesteno);

        // Zapocnimo 3 kola
        for (int brojKola = 0; brojKola < 3; brojKola++)
        {
            Kolo k = new Kolo();

            // Generisimo nase RNG tikete
            for (int i = 0; i < 50; i++)
            {
                Tiket t = new Tiket();
                k.odigrajTiket(t);
            }

            igra.odigrajKolo(k);
        }

        igra.pogledajTiket(16, 2);
    }
}
