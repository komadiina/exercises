package labovi.deseti.drugi;

import java.util.ArrayList;
import java.util.List;

public class Trka {
    /* 15 celija, [#14] == [KRAJ]
    * [] ---> ... [] [] [] [####]
    * [] ---> ... [] [] [] [####]
    * [] ---> ... [] [] [] [####]
    * */

    public Object[][] staza;
    public List<Automobil> ucesnici;

    public Boolean kraj = false;

    public Trka(Object[][] staza, List<Automobil> ucesnici) {
        this.staza = staza;
        this.ucesnici = ucesnici;
    }

    public Trka(List<Automobil> ucesnici, final Integer duzinaStaze) {
        this.staza = new Object[ucesnici.size()][duzinaStaze];
        this.ucesnici = ucesnici;
    }

    public void zapocni() {
        for (Automobil a : this.ucesnici) {
            System.out.println("Zapoceo utrku: " + a.toString());
            a.start();
        }

    }
}
