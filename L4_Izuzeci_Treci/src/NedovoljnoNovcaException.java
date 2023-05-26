public class NedovoljnoNovcaException extends Exception {
    public NedovoljnoNovcaException(String message) {
        super(message);
    }

    public NedovoljnoNovcaException() {
        super("Nije moguce umanjiti stanje na racunu za dati iznos!");
    }
}
