public class ValueException extends Exception {
    public ValueException(String message) {
        super(message);
    }

    public ValueException() {
        super("Broj nije vazeci!");
    }
}
