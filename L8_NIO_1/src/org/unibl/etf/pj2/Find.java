package org.unibl.etf.pj2;

import java.io.IOException;
import java.nio.file.*;

public class Find {
    public static void main(String[] args) {
        Path current = Paths.get(System.getProperty("user.home"));
        String pattern = "*.txt"; // glob sablon
        Finder finder = new Finder(pattern);

        try {
            // statickoj metodi walkFileTree prosljedjujemo klasu koja implementira FileVisitor interfejs,
            // kao i pocetni direktorijum.
            Files.walkFileTree(current, finder);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        // Signalizacija korisniku za kraj
        finder.done();
    }
}
