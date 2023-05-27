package labovi.deveti.deveti.example;

import labovi.deveti.deveti.engine.*;
import labovi.deveti.deveti.mechanism.*;
import labovi.deveti.deveti.example.Item;

public class Test {

    public static void main(String[] args) {
        Object result = new Object();
        labovi.deveti.deveti.engine.Process process = new labovi.deveti.deveti.engine.Process(result);

        TextLoader loader = new TextLoader(5, "data.txt");
        ParseProcessor parser = new ParseProcessor(4);
        CalculateProcessor calculator = new CalculateProcessor(3);
        TextExporter exporter = new TextExporter(2, "data_exported.txt");

        process.addEngine(loader);
        process.addEngine(parser);
        process.addEngine(calculator);
        process.addEngine(exporter);

        process.execute();
    }
}