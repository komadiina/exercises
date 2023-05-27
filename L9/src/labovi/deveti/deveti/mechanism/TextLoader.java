package labovi.deveti.deveti.mechanism;

import labovi.deveti.deveti.engine.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TextLoader extends Loader<String> {
    public TextLoader(Integer priority, String path) {
        super(priority, path);
    }

    @Override
    public List<String> load() throws Exception {
        return Files.readAllLines(Paths.get(path));
    }
}
