package labovi.deseti.drugi;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        final Integer BROJ_REDOVA = 8;
        final Integer DUZINA_STAZE = 15;

        // Mogao sam ovo wrappovati u klasu Staza ali nmvz, moze i ovako, nije sporno
        Object[][] staza = new Object[BROJ_REDOVA][DUZINA_STAZE];

        // Postavimo nasumicno znakove "STOP"
        Random rng = new Random(42);
        for (Integer red = 0; red < BROJ_REDOVA; red++) {
            Integer brojZnakova = 4;
            while (brojZnakova-- > 0) {
                staza[red][1 + rng.nextInt(DUZINA_STAZE-1)] = "STOP";
            }
        }

        // Inicijalizujmo automobile
        List<Automobil> automobili = new ArrayList<>();

        for (Integer red = 0; red < BROJ_REDOVA; red++) {
            String modelAuta;
            Integer crit = red % 3;
            if (crit == 0) {
                modelAuta = "Alfa Romeo 147 1.9 JTDm";
            } else if (crit == 1) {
                modelAuta = "BMW 520d 2.0";
            } else {
                modelAuta = "Porsche 924 Singer 2.8";
            }

            automobili.add(new Automobil(modelAuta, staza[red]));
        }

        Trka trka = new Trka(staza, automobili);
        trka.zapocni();

        // Čekanje da se svi automobili završe
        for (Automobil automobil : automobili) {
            try {
                automobil.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Svi automobili su završili trku.");
    }
}
