import java.io.Serializable;

public class Proizvodjac implements Serializable {
    private String naziv;
    private String drzava;
    private String email;

    public String getNaziv() {
        return naziv;
    }

    public String getDrzava() {
        return drzava;
    }

    public String getEmail() {
        return email;
    }

    public Status getStatus() {
        return status;
    }

    // Klasa Status nam definise trenutni status rada firme
    private Status status;

    public Proizvodjac(String naziv, String drzava, String email) {
        this.naziv = naziv;
        this.drzava = drzava;
        this.email = email;

        // Jedina logicna stvar
        this.status = Status.AKTIVAN;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Proizvodjac: " + this.naziv + "\nDrzava: " + this.drzava + "\nE-mail: " + this.email + "\n";
    }
}
