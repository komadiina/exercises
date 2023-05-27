package labovi.deveti.deveti.engine;

import java.util.List;

public abstract class Loader<T> extends Engine {

    protected String path;

    public Loader(Integer priority, String path) {
        super(priority);

        this.path = path;
    }

    public abstract List<T> load() throws Exception;
}
