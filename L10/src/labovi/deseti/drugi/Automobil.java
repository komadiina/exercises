package labovi.deseti.drugi;

public class Automobil extends Thread {
    public String tip;
    public String id;
    private static Integer ID = 0;

    public Object[] staza;
    public Integer doKraja;

    public Automobil(String tip, Object[] staza) {
        this.staza = staza;
        this.tip = tip;
        this.id = (++ID).toString();
    }

    @Override
    public void run() {
        this.staza[0] = this;
        this.doKraja = this.staza.length - 1;
        Boolean zavrsio;

        for (Integer pos = 1; pos < staza.length; pos++) {
            if (this.staza[pos] != null)
                // Provjerimo da li je naletio na STOP znak:
                if (this.staza[pos].equals("STOP")) {
                    // Uspavajmo nit na 5s
                    try {
                        System.out.println(this + " naletio na STOP!");
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

            // Prebacimo objekat na sledecu poziciju
            this.staza[pos] = this;

            // 'Oslobodimo' referencu prethodne celije
            this.staza[pos - 1] = null;

            // Automobil zavrsio trku?
            zavrsio = (pos == this.staza.length - 1);

            if (zavrsio) {
                synchronized (Semafor.lock) {
                    if (Semafor.ZAVRSILO == 0) {
                        // Zavrsio prije svih ostalih
                        System.out.println("POBJEDNIK! " + this);
                    } else {
                        System.out.println("Automobil zavrsio, ali nije pobjednik... " + this);
                    }

                    Semafor.ZAVRSILO++;
                }

                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Automobil #" + this.id + ", tip: " + this.tip;
    }
}
