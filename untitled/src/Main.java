import java.util.*;

public class Main {
    private static final Integer NUM_OF_TICKETS = 3;

    public static void main(String[] args) {
        // Initialize our tickets
        Ticket[] tiketi = new Ticket[NUM_OF_TICKETS];
        for (int i = 0; i < NUM_OF_TICKETS; i++) {
            System.out.println("Tiket broj " + (i+1) + ": ");

            try {
                Ticket t = new Ticket();
                tiketi[i] = t;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Initialize our winning ticket
        Integer[] winningCombination = new Integer[7];
        Random rnd = new Random();

        for (int i = 0; i < 7; i++) {
            Integer r = 1 + rnd.nextInt(90);

            for (Integer k : winningCombination) {
                while (k == r) {
                    r = rnd.nextInt(90) + 1;
                }
            }

            winningCombination[i] = r;
        }

        Ticket winningTicket = new Ticket(winningCombination);
        System.out.println("Winning combination:");
        for (Integer n : winningCombination)
            System.out.print(" " + n);

        // Check for winning tickets
        for (Ticket t : tiketi) {
            if (Ticket.isWinning(t, winningTicket)) {
                System.out.println("Tiket (SN: " + t.getSerijskiBroj().toString() + ") je dobitni!");
            }
        }
    }
}