package labovi.deveti.osmi;

import java.util.*;
public class Tiket {
    private static Integer ID = 0;
    private Integer id;
    private List<Integer> kombinacija;

    public Tiket(List<Integer> kombinacija) throws NevazeciTiketException {
        if (kombinacija.size() != 6)
            throw new NevazeciTiketException("Kombinacija ne sadrzi 6 brojeva.");

        // Provjera za duplikate
        List<Integer> brojevi = new ArrayList<>();
        kombinacija.sort(Comparator.naturalOrder());

        for (Integer i : kombinacija)
        {
            if (brojevi.contains(i))
                throw new NevazeciTiketException("Greska: Tiket ne smije sadrzati duplikate. "
                        + brojevi.toString() + " - " + i);
            else brojevi.add(i);
        }

        this.kombinacija = kombinacija;
        this.id = ++Tiket.ID;
    }

    public Tiket() {
        // Tiket od 6 slucajno generisanih brojeva
        List<Integer> brojevi = new ArrayList<>();

        Random rnd = new Random();
        while (brojevi.size() != 6) {
            Integer i = rnd.nextInt(45) + 1;
            while (brojevi.contains(i))
                i = rnd.nextInt(45) + 1;

            brojevi.add(i);
        }

        brojevi.sort(Comparator.naturalOrder());
        this.kombinacija = brojevi;
        this.id = ++Tiket.ID;
    }

    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.id.toString() + " | " + this.kombinacija.toString();
    }

    @Override
    public boolean equals(Object drugi) {
        if (drugi == null)
            return false;
        else if (drugi instanceof Tiket == false)
            return false;
        else {
            return this.kombinacija.equals(((Tiket)drugi).kombinacija);
        }
    }
}
