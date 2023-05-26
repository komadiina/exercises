package labovi.deveti.osmi;

import java.util.*;
public class Loto645 {
    private List<Kolo> odigranaKola = new ArrayList<>();

    public Loto645() {}

    public void odigrajKolo(Kolo k) {this.odigranaKola.add(k); k.zapocni(); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("--- LOTO 6/45 ---\n");

        for (Kolo k : this.odigranaKola) {
            sb.append(k + "\n");
        }

        return sb.toString();
    }

    public Kolo pretraziKolo(Kolo target) {
        for (Kolo k : this.odigranaKola) {
            if (k.equals(target))
                return k;
        }

        return null;
    }

    public Kolo pretraziKolo(Integer id) {
        for (Kolo k : this.odigranaKola) {
            if (k.getId().equals(id))
                return k;
        }

        return null;
    }

    public void pogledajTiket(Integer idTiket, Integer idKolo) {
        Kolo k = this.pretraziKolo(idKolo);

        if (k != null) {
            Tiket t = k.pretraziTiket(idTiket);

            if (t != null) {
                System.out.println("\nRezultat pretrage (Kolo #"+ idKolo +"): ");
                System.out.println(t);
                System.out.println(k.isDobitni(t) ? "Dobitni!" : "Nije dobitni.");
            }
            else System.out.println("Tiket nije postojeci. (Kolo: " + idKolo + ", Tiket: " + idTiket + ")");
        }
        else System.out.println("Kolo nije postojece. (ID kola: " + idKolo + ")");
    }
}
