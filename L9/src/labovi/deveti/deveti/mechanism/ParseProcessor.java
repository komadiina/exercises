package labovi.deveti.deveti.mechanism;

import labovi.deveti.deveti.example.Item;
import labovi.deveti.deveti.engine.*;

import java.util.ArrayList;
import java.util.List;

public class ParseProcessor extends Processor<List<Item>, List<String>> {
    public ParseProcessor(Integer priority) { super(priority); }

    @Override
    public List<Item> process(List<String> source) throws Exception {
        List<Item> result = new ArrayList<Item>();

        for (String s : source) {
            String[] tokens = s.split(",");
            result.add(new Item(
                    tokens[0],
                    Double.parseDouble(tokens[1]),
                    Double.parseDouble(tokens[2]),
                    0.0 // Bice izracunato putem CalculateProcessor-a
            ));
        }

        return result;
    }
}
