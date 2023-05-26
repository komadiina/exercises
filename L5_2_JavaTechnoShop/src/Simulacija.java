public class Simulacija {
    public static void main(String[] args) {
        // JavaTechnoShop
        // Inicijalizovacemo lager prodavnice
        Lager lager = new Lager();

        // Inicijalizujmo nekoliko proizvodjaca
        Proizvodjac LG = new Proizvodjac("LG", "SAD", "lg-support@lg.com");
        Proizvodjac ALIENWARE = new Proizvodjac("Alienware", "Kina", "alienware@dell.com");
        Proizvodjac SAMSUNG = new Proizvodjac("Samsung", "Japan", "samsung@samsung.com");
        Proizvodjac META = new Proizvodjac("Meta", "SAD", "meta@metaverse.com");

        // Inicijalizujmo nekoliko proizvoda
        Monitor m1 = new Monitor("1160",
                "LG Flatron W2243S",
                LG, 199.99, new String[]{"144Hz", "1080p"}, "W2243S");
        Racunar r1 = new Racunar("2115", "Alienware Area 56", ALIENWARE, 4999.99, new String[]{"Ryzen 7 7800x", "RTX 4090Ti", "64GB DDR4", "2TB NVMe"});
        Telefon t1 = new Telefon("3164", "Samsung Galaxy S20 Ultra", SAMSUNG, 1699.99, new String[]{"100Hz", "6.4in", "512 GB"}, "S20-U512");
        Softver s1 = new Softver("0999", "Facebook-Whisper", META, 567899.0, "AI prepoznavanje glasovnih audiozapisa");

        // Dodajmo proizvode na lager
        lager.dodajProizvod(m1);
        lager.dodajProizvod(r1);
        lager.dodajProizvod(t1);
        lager.dodajProizvod(s1);

        // Kreirajmo cjenovnik na osnovu lagera
        Cjenovnik cjen = new Cjenovnik(lager.getNaStanju());
        System.out.println("--- Cjenovnik ---\n" + cjen.toString());

        // Ulazimo u prodavnicu
        Racun rac = new Racun();
        rac.dodajProizvod(r1);
        rac.dodajProizvod(t1);
        rac.dodajProizvod(m1);
        System.out.println(rac.toString());
        System.out.println("Trenutno nas kosta: " + rac.getIznos());

        // Probajmo izbaciti neke proizvode iz korpe
        try {
            rac.izbaciProizvod(r1);
            rac.izbaciProizvod(r1);
        } catch (ProizvodNePostojiException ex) {
            System.out.println("Nije moguce skinuti dati proizvod! " + ex.getMessage());
        }

        System.out.println(rac.toString());
        Double zaPlatiti = rac.zavrsiKupovinu();
        System.out.println("Zavrsena kupovina! Potrebno platiti: " + zaPlatiti.toString());

        System.out.println(rac.toString());
    }
}
