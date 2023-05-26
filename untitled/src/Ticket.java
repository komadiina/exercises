import java.util.Scanner;
import java.util.Arrays;

public class Ticket {
    private static Integer redniBroj = 1;
    private Integer serijskiBroj;

    private Integer[] kombinacije;
    public static Integer getRedniBroj() {
        return redniBroj;
    }

    public static void setRedniBroj(Integer redniBroj) {
        Ticket.redniBroj = redniBroj;
    }

    public Integer getSerijskiBroj() {
        return serijskiBroj;
    }

    public void setSerijskiBroj(Integer serijskiBroj) {
        this.serijskiBroj = serijskiBroj;
    }

    public Integer[] getKombinacije() {
        return kombinacije;
    }

    public void setKombinacije(Integer[] kombinacije) {
        this.kombinacije = kombinacije;
    }


    public Ticket() throws Exception {
        serijskiBroj = redniBroj++;
        kombinacije = new Integer[7];
        for (int i = 0; i < 7; i++) {
            kombinacije[i] = -1;
        }

        Scanner scn = new Scanner(System.in);
        System.out.println("Unesite vasu kombinaciju (7 brojeva): ");

        for (int i = 0; i < 7; i++) {
            System.out.println("[" + (i+1) + ".]: ");
            Integer trenutni = scn.nextInt();

            if (trenutni > 0 && trenutni < 90) {
                // Kombinacije sadrze dati broj
                for (int k : kombinacije)
                    if (trenutni == k) throw new DuplicateValueException();

                kombinacije[i] = trenutni;
            }
            else {
                 throw new ValueException("Dati broj nije u validnom domenu (1-90).");
            }
        }
    }

    public Ticket(Integer[] combination) {
        serijskiBroj = redniBroj++;
        this.kombinacije = combination;
    }

    public static boolean isWinning(Ticket t, Ticket winning) {
        Integer[] k1 = t.getKombinacije();
        Integer[] k2 = winning.getKombinacije();

        Arrays.sort(k1); Arrays.sort(k2);

        if (Arrays.equals(k1, k2))
            return true;

        return false;
    }
}
