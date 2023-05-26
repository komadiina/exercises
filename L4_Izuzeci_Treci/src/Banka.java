import javax.annotation.processing.FilerException;
import java.util.logging.*;
import java.io.*;
import java.util.*;

public class Banka {
    private Klijent[] klijenti = new Klijent[4];
    public static Handler handler;

    {
        try {
            handler = new FileHandler("banka.log");
            Logger.getLogger(Banka.class.getName()).addHandler(handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Banka() {
        klijenti[0] = new Klijent("Ognjen", "Komadina", "1163/20", 535.27);
        klijenti[1] = new Klijent("Maja", "Mujadzic", "1161/20", 700.69);
        klijenti[2] = new Klijent("Djordje", "Joldzic", "1145/20", 420.42);
        klijenti[3] = new Klijent("Marko", "Grbic", "123/21", 1750.50);
    }

    public static void main(String[] args)
    {
        Banka banka = new Banka();
        Random rnd = new Random();

        for (Klijent k : banka.klijenti) {
            System.out.println(k);

            try {
                k.umanjiStanje(rnd.nextDouble(1000));
            } catch (NedovoljnoNovcaException e) {
                Logger.getLogger(Banka.class.getName()).log(
                        Level.WARNING,
                        e.fillInStackTrace().toString());
            }

            System.out.println("Nakon RTV takse: " + k.getBalans().toString());
        }
    }
}
