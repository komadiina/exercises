public class DuplicateValueException extends ValueException{
    public DuplicateValueException(String message) {
        super(message);
    }

    public DuplicateValueException() {
        super("Broj je duplikat!");
    }
}
