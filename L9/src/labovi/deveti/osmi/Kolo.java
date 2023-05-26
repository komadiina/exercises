package labovi.deveti.osmi;

import java.util.*;
import java.text.*;
public class Kolo {
    private List<Tiket> uIgri = new ArrayList<>();

    // RNG dobitna kombinacija
    private Tiket dobitniTiket = new Tiket();

    // Kolekcija dobitnih tiketa
    private List<Tiket> dobitniTiketi = new ArrayList<>();
    public Boolean rigged = false;

    private static Integer ID = 1;
    private Integer id;

    public Kolo() { super(); this.id = Kolo.ID++; }
    public Kolo(List<Tiket> tiketi) { this.uIgri = tiketi; this.id = Kolo.ID++; }

    public Integer getId() { return this.id; }

    public void odigrajTiket(Tiket t) {
        uIgri.add(t);
    }


    public List<Integer> zapocni() {
        if (this.rigged) {
            try {
                this.dobitniTiket = new Tiket(Arrays.asList(1, 2, 3, 4, 5, 6));
            } catch (NevazeciTiketException ex) {;}
        }

        // Simulacija 'izvlacenja'
        // Generisimo listu od 45 brojeva [1 -:- 45]
        List<Integer> kuglice = new ArrayList<>();
        for (Integer i = 1; i < 46; i++)
            kuglice.add(i);

        // Promijesajmo kolekciju
        Random rng = new Random();
        Collections.shuffle(kuglice, rng);

        // Ispisimo 'RNG' kola:
        int br = 0;
        for (Integer i : kuglice) {
            if (br % 11 == 0)
                System.out.println();

            System.out.print(i + " | ");
            br++;

            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.err.println(ex.getLocalizedMessage());
            }
        }

        // Ispis statistike
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00", dfs);

        System.out.println("\n-------------------------------\n"
                + "Zavrseno kolo!"
                + "\nBroj dobitnih tiketa: " + this.dobitniTiketi().size()
                + "\nDobitni tiket (RNG): " + this.dobitniTiket.toString()
                + "\nVjerovatnoca dobitka: " + (df.format(this.sansaDobitka() * 100)) + "%"
        );

        // RNG kola
        return kuglice;
    }

    public List<Integer> dobitniTiketi() {
        Integer brojDobitnih = 0;
        List<Integer> dobitniTiketiId = new ArrayList<>();

        for (Tiket t : this.uIgri) {
            if (t.equals(this.dobitniTiket)) {
                System.out.println("Dobitak! " + t.toString());

                dobitniTiketiId.add(t.getId());
                this.dobitniTiketi.add(t);
            }
        }

        return dobitniTiketiId;
    }

    public Double sansaDobitka() {
        return (double)this.dobitniTiketi().size() / (double)this.uIgri.size();
    }

    @Override
    public String toString() {
        return "Kolo #" + this.id + ":\n" +
                "Dobitni tiket: " + this.dobitniTiket.toString() +
                "Broj dobitnih tiketa: " + this.dobitniTiketi().size() +
                "\n";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        else if (other instanceof Kolo == false)
            return false;

        return this.id.equals(((Kolo)other).getId());
    }

    public Tiket pretraziTiket(Tiket target) {
        for (Tiket t : this.uIgri)
            if (t.equals(target))
                return t;

        return null;
    }

    public Tiket pretraziTiket(Integer id) {
        for (Tiket t : this.uIgri)
            if (t.getId().equals(id))
                return t;

        return null;
    }

    public Boolean isDobitni(Tiket t) {
        return this.dobitniTiketi.contains(t);
    }

    public Boolean isDobitni(Integer id) {
        for (Tiket t : this.dobitniTiketi)
            if (t.getId().equals(id))
                return true;

        return false;
    }
}
