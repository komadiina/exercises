package labovi.deveti.deveti.mechanism;

import labovi.deveti.deveti.engine.*;
import labovi.deveti.deveti.example.Item;

import java.util.List;

public class CalculateProcessor extends Processor<List<Item>, List<Item>> {
    public CalculateProcessor(Integer priority) { super(priority); }

    @Override
    public List<Item> process(List<Item> source) {
        for (Item elem : source) {
            elem.setTotal(elem.getQuantity() * elem.getPrice());
        }

        return source;
    }
}
