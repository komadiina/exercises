import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;
import java.text.*;
import java.util.Locale;

public class Student implements Serializable {
    public String indeks;
    public Double prva, druga, treca, cetvrta;

    public Student() {
        this.indeks = null;
        prva = druga = treca = cetvrta = null;
    }

    public Student(String indeks, Double prva, Double druga, Double treca, Double cetvrta) {
        this.indeks = indeks.replace('/', '_');

        this.prva = prva;
        this.druga = druga;
        this.treca = treca;
        this.cetvrta = cetvrta;
    }

    public Double prosjek() {
        return (this.prva + this.druga + this.treca + this.cetvrta) / 4.0;
    }

    @Override
    public boolean equals(Object drugi) {
        // instanceof shadows '== null'
        if (drugi != null) {
            if (drugi instanceof Student == false)
                return false;

            return this.indeks.equals(((Student) drugi).indeks);
        } else return false;
    }

    @Override
    public String toString() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("00.00", symbols);

        return this.indeks
                + " " + df.format(this.prva)
                + " " + df.format(this.druga)
                + " " + df.format(this.treca)
                + " " + df.format(this.cetvrta);
    }

    public static Student readStudent(String feed) throws IOException {
        feed = feed.replace('.', ',');
        String[] split = feed.split(" ");

        if (split.length != 5) throw new IOException();

        try {
            return new Student(split[0],
                    Double.parseDouble(split[1]),
                    Double.parseDouble(split[2]),
                    Double.parseDouble(split[3]),
                    Double.parseDouble(split[4]));
        } catch (NumberFormatException ex) {
            throw new IOException();
        }
    }
}
