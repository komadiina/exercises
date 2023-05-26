package org.unibl.etf.pj2.watch;

/* Pogledati video za ovo */

import java.io.File;
import java.util.List;
import java.nio.file.*;
import java.io.IOException;

public class FileWatcher {
    public static void register(Path dir, WatchService watcher) {
        try {
            dir.register(watcher,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);

            System.out.println("Watch service registered for directory " + dir.toString());

            // Start watching
            while (true) {
                WatchKey key;

                try {
                    key = watcher.take();
                } catch (InterruptedException ex) {
                    System.out.println("FileWatcher service interrupted, exiting...");
                    System.err.println(ex.getLocalizedMessage());
                    return;
                }

                for (WatchEvent<?> event: key.pollEvents()) {

                    // ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY
                    WatchEvent.Kind<?> kind = event.kind();

                    // Unchecked cast, but doesn't matter
                    WatchEvent<Path> ev = (WatchEvent<Path>)event;

                    // Relative path
                    Path fileName = ev.context();

                    System.out.println(kind.name() + ": " + fileName);

                    if (fileName.toString().trim().endsWith(".txt")
                            && kind.equals(StandardWatchEventKinds.ENTRY_MODIFY)) {
                        List<String> fileContent = Files.readAllLines(dir.resolve(fileName));

                        for (String str : fileContent)
                            System.out.println(str);

                        System.out.println("=====================================");
                    }
                }

                // Check for WatchKey validity
                if (!key.reset()) {
                    break;
                }
            }

        } catch (IOException ex) {
            System.err.println(ex.getLocalizedMessage());
        }

    }

    public static void main(String[] args) {
        try {
            FileWatcher.register(
                    Paths.get(System.getProperty("user.home") + File.separator + "Desktop"),
                    FileSystems.getDefault().newWatchService());
        } catch (IOException ex) {
            System.err.println(ex.getLocalizedMessage());
        }
    }
}
