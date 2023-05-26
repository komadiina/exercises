import java.util.Scanner;

public class PretragaFilmova {
    public static void main(String[] args) {
        Film f1 = new Film("Top Gun: Maverick", 1999, new String[]{"Ognjen Komadina", "Maja Mujadzic", "Vito Korleone"}, 4.9);
        AnimiraniFilm f2 = new AnimiraniFilm("Yuki", 2001, new String[]{"Simo", "Zule", "Juki", "Gavro"}, 10.0, "Maja");

        Film[] filmovi = new Film[]{f1, f2};

        System.out.println(f1);
        System.out.println(f1.imaGlumacCI("ognjen komadina"));
        System.out.println(f1.imaGlumac("Maja Mujadzic"));
        System.out.println(f1.kolikoStar());
        System.out.println(f1.nazivSadrziRijec("Top"));

        System.out.println(f2);
        System.out.println(f2.imaGlumac("simo"));
        System.out.println(f2.imaGlumacCI("Zule"));
        System.out.println(f2.kolikoStar());

        Scanner scn = new Scanner(System.in);
        System.out.println("Unesite ocjenu: ");
        Double criteria = scn.nextDouble();

        System.out.println("Kriterij: a) veci od ocjene, b) manji od ocjene");
        String sel = scn.next();

        if (sel.equals("a")) {
            for (Film f : filmovi) {
                if (f.getOcjena() >= criteria)
                    System.out.println(f);
            }
        } else if (sel.equals("b")) {
            for (Film f : filmovi) {
                if (f.getOcjena() < criteria)
                    System.out.println(f);
            }
        }
        else {
            System.out.println("Pogresan unos.");
        }
    }
}
