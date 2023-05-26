package labovi.deveti.treci;
import java.io.*;

public class SerializationUtil {
    public static <T> Boolean saveObject(T object, String filenameWithPath) {
        assert object instanceof Serializable;

        try (BufferedOutputStream in = new BufferedOutputStream(new FileOutputStream(filenameWithPath));
            ObjectOutputStream writer = new ObjectOutputStream(in)) {
            writer.writeObject(object);
        } catch (IOException ex) {
            System.err.println(ex.getLocalizedMessage());
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public static <T> T readObject(String filenameWithPath) {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(filenameWithPath));
        ObjectInputStream reader = new ObjectInputStream(in)) {
            Object read = reader.readObject();

            if (read != null)
                return (T)read;

            throw new InvalidClassException("Unable to cast deserialized object to it's class.");

        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getLocalizedMessage());
            ex.printStackTrace();
        }

        return null;
    }
}
