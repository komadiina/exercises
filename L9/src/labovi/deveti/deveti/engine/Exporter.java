package labovi.deveti.deveti.engine;

public abstract class Exporter<T> extends Engine {
    protected String path;

    public Exporter(Integer priority, String path) {
        super(priority);

        this.path = path;
    }

    public abstract Boolean export(T data) throws Exception;
}
