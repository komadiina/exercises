public class ProizvodNePostojiException extends Exception {
    public ProizvodNePostojiException() {
        super("Proizvod nije nadjen u bazi podataka!");
    }

    public ProizvodNePostojiException(String message) { super(message); }
}
