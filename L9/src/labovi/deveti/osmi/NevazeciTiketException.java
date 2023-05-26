package labovi.deveti.osmi;

public class NevazeciTiketException extends Exception {
    public NevazeciTiketException(String message) { super(message); }
    public NevazeciTiketException() { super("Tiket nije vazeci!"); }
}
