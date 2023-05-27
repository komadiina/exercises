package labovi.deveti.deveti.engine;

// T - resulting object's class (Item)
// E - processing source (string if loaded, else file)
public abstract class Processor<T, E> extends Engine {
    public Processor(Integer priority) {
        super(priority);
    }

    public abstract T process(E source) throws Exception;
}
