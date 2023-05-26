package org.unibl.etf.pj2;

import java.io.IOException;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// Finder implementira FileVisitor<T> interfejs, gdje je T argument pretrage (Path)
// Klasa Finder mora da implementira visitFile(), preVisitDirectory(), visitFileFailed() i postVisitDirectory() metode

public class Finder implements FileVisitor<Path> {
    private final PathMatcher matcher;
    private Integer matches = 0;

    public Finder(String pattern) {
        // "glob:" ili "regex:" (isto, samo je glob jednostavniji engine)
        matcher = FileSystems.getDefault().getPathMatcher("glob:"+pattern);
    }

    public void find(Path file) {
        Path fileName = file.getFileName();

        if (fileName != null && matcher.matches(fileName)) {
            this.matches++;
            System.out.println(fileName);
        }
    }

    public void done() {
        System.out.println("Num. matched: " + matches);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attribs) {
        this.find(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attribs) {
        this.find(dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path dir, IOException ex) {
        System.err.println(ex.getMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException ex) throws IOException {
        this.find(dir);
        return FileVisitResult.CONTINUE;
    }
}
