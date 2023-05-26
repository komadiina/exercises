public class Klijent {
    private String ime, prezime, JMBG;
    private Double balans;

    public Klijent(String ime, String prezime, String JMBG, Double balans) {
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.balans = balans;
    }

    public Double umanjiStanje(Double iznos) throws NedovoljnoNovcaException {
        if (iznos > this.balans) throw new NedovoljnoNovcaException();

        this.balans -= iznos;

        return this.balans;
    }

    public String toString() {
        return ime + " " + prezime + ", " + JMBG + " | " + balans.toString();
    }

    public Klijent() throws Exception {
        throw new Exception("Klijent nije identifikovan.");
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public Double getBalans() {
        return balans;
    }

    public void setBalans(Double balans) {
        this.balans = balans;
    }
}
