package labovi.deseti.prvi;

import java.lang.*;

public class CounterThread extends Thread {
    private String name;
    public Integer count;
    private static Integer id = 1;

    public CounterThread(Integer count, String prefix) {
        this.count = count;

        this.name = prefix + id.toString();
        ++id;
    }

    @Override
    public void run() {
        Long total = 0L;

        for (Integer i = 0; i < this.count; i++)
            total += i;

        System.out.println("Nit #" + this.name + ": " + total);
    }
}
