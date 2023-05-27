package labovi.deveti.deveti.engine;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Process {

    private Object accumulator;
    private PriorityQueue<Engine> engines = new PriorityQueue<>(new Comparator<Engine>() {

        @Override
        public int compare(Engine e1, Engine e2) {
            return e2.getPriority().compareTo(e1.getPriority());
        }
    });

    public Process(Object accumulator) {
        super();
        this.accumulator = accumulator;
    }

    public boolean addEngine(Engine e) {
        return engines.add(e);
    }

    public Object getAccumulator() {
        return accumulator;
    }

    public void setAccumulator(Object accumulator) {
        this.accumulator = accumulator;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Object execute() {
        while (!engines.isEmpty()) {
            Engine engine = engines.poll();
            try {
                System.out.println("Run " + engine.getClass().getName() + " engine");
                if (engine instanceof Loader) {
                    accumulator = ((Loader<?>) engine).load();
                }
                if (engine instanceof Processor) {
                    accumulator = ((Processor) engine).process(accumulator);
                }
                if (engine instanceof Exporter) {
                    accumulator = ((Exporter) engine).export(accumulator);
                }
                System.out.println("Engine done");
            } catch (Exception e) {
                e.printStackTrace();
                // abort execution if one is required
                if (engine.isRequired()) {
                    return false;
                }
            }
        }
        System.out.println("Process done without exceptions");
        return accumulator;
    }

}
