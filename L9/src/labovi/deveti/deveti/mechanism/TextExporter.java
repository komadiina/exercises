package labovi.deveti.deveti.mechanism;

import labovi.deveti.deveti.engine.*;
import labovi.deveti.deveti.example.Item;

import java.io.*;
import java.util.List;

public class TextExporter extends Exporter<List<Item>> {

    public TextExporter(Integer priority, String path) {
        super(priority, path);
    }

    @Override
    public Boolean export(List<Item> data) throws Exception {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(this.path)));

        for (Item elem : data) {
            pw.println(elem.toString());
        }

        pw.close();
        return true;
    }
}
