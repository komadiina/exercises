import java.nio.file.*;
import java.io.*;
import java.util.Scanner;

public class Sim {
    public static void main(String[] args) {
        FolderSurfer worker = new FolderSurfer(System.getProperty("user.home"));

        System.out.println("------- Folder explorer -------");
        System.out.println("Ponudjene komande: " +
                "\n\tmd (name)" +
                "\n\tdir" +
                "\n\tcd (name)" +
                "\n\tdel (name)" +
                "\n\tcopy (src) (dest)" +
                "\n\tword" +
                "\n\tquit"
        );

        System.out.println("Unesite komandu > ");
        Scanner scn = new Scanner(System.in);
        String command;

        while (worker.execute(command = scn.nextLine()) != -1) {
            System.out.println("Unesite komandu > ");
        }
    }
}
