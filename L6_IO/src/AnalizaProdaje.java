import java.io.*;
import java.util.*;

public class AnalizaProdaje {
    public static void main(String[] args) {
        // Ulazni podaci se nalaze u roditeljskom direktorijumu
        // Format: PROIZVOD#PROIZVODJAC#KOLICINA#ID#CIJENA

        Double  cijenaRacunara = 0.0,
                cijenaMonitora = 0.0,
                cijenaTelefona = 0.0,
                cijenaSoftvera = 0.0,
                cijenaUkupno = 0.0;

        Integer brojRacunara = 0,
                brojMonitora = 0,
                brojTelefona = 0,
                brojSoftvera = 0,
                brojUkupno = 0;

        try {
            PrintWriter outRacunari = new PrintWriter(new BufferedWriter(new FileWriter("../prodajaRacunari.txt")));
            PrintWriter outMonitori = new PrintWriter(new BufferedWriter(new FileWriter("../prodajaMonitori.txt")));
            PrintWriter outTelefoni = new PrintWriter(new BufferedWriter(new FileWriter("../prodajaTelefoni.txt")));
            PrintWriter outSoftver = new PrintWriter(new BufferedWriter(new FileWriter("../prodajaSoftver.txt")));

            BufferedReader in = new BufferedReader(new FileReader("./prodaja.txt"));
            String s;

            List<Proizvod> proizvodi = new ArrayList<Proizvod>();

            while ((s = in.readLine()) != null) {
                String[] parametri = s.split("#");

                // racunar | monitor | telefon | softver
                String kategorija = parametri[0];

                // lg | alienware | samsung | meta
                String proizvodjac = parametri[1];

                Integer kolicina = Integer.parseInt(parametri[2]);
                brojUkupno += kolicina;

                Integer id = Integer.parseInt(parametri[3]);
                Double cijena = Double.parseDouble(parametri[4]);


                // Razvrstajmo proizvode po kategoriji i ubacujmo u kolekciju
                switch (kategorija) {
                    case "racunar":
                        Racunar p = new Racunar(id.toString(), kategorija, new Proizvodjac(proizvodjac, "", ""), cijena, new String[]{});

                        proizvodi.add(p);

                        brojRacunara += kolicina;
                        cijenaRacunara += p.getCijena() * kolicina;
                        cijenaUkupno += p.getCijena() * kolicina;

                        break;
                    case "monitor":
                        Monitor m = new Monitor(id.toString(), kategorija, new Proizvodjac(proizvodjac, "", ""), cijena, new String[]{}, "nepoznat-model");

                        proizvodi.add(m);

                        brojMonitora += kolicina;
                        cijenaMonitora += m.getCijena() * kolicina;
                        cijenaUkupno += m.getCijena() * kolicina;

                        break;
                    case "telefon":
                        Telefon t = new Telefon(id.toString(), kategorija, new Proizvodjac(proizvodjac, "", ""), cijena, new String[]{}, "nepoznat-model");

                        proizvodi.add(t);

                        brojTelefona += kolicina;
                        cijenaTelefona += t.getCijena() * kolicina;
                        cijenaUkupno += t.getCijena() * kolicina;

                        break;
                    case "softver":
                        Softver sw = new Softver(id.toString(), kategorija, new Proizvodjac(proizvodjac, "", ""), cijena, "");

                        proizvodi.add(sw);

                        brojSoftvera += kolicina;
                        cijenaSoftvera += sw.getCijena() * kolicina;
                        cijenaUkupno += sw.getCijena() * kolicina;

                        break;
                }
            }
            // Nisu nam potrebni ulazni fajlovi vise
            outMonitori.close();
            outSoftver.close();
            outRacunari.close();
            outTelefoni.close();
            in.close();

            PrintWriter racuncic = new PrintWriter(new BufferedWriter(new FileWriter("izvjestaj_racun.txt")));
            for (Proizvod p : proizvodi) {
                racuncic.println(p.toString());
            }
            racuncic.close();

            // Zapisimo izvjestaj u fajl (PROIZVOD UKUPNA_CIJENA)
            PrintWriter izvjestaj = new PrintWriter(new BufferedWriter(new FileWriter("izvjetaj.txt")));
            izvjestaj.println("Racunari: [" + brojRacunara.toString() + "] " + cijenaRacunara);
            izvjestaj.println("Monitori: [" + brojMonitora.toString() + "] " + cijenaMonitora);
            izvjestaj.println("Telefoni: [" + brojTelefona.toString() + "] " + cijenaTelefona);
            izvjestaj.println("Softver: [" + brojSoftvera.toString() + "] " + cijenaSoftvera);
            izvjestaj.println("-------------------\nUkupno: [" + brojUkupno.toString() + "] -> " + cijenaUkupno.toString());

            izvjestaj.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
