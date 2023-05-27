package labovi.deseti.prvi;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        String prefix = "T";
        Random rnd = new Random();
        Integer numThreads = rnd.nextInt(50);

        System.out.println("Total amount of threads: " + numThreads.toString());

        for (Integer i = 0; i < numThreads; i++) {
            new CounterThread(5000 + rnd.nextInt(5000), prefix).start();
        }
    }
}
