import com.sun.jdi.InvalidTypeException;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class FolderSurfer {
    private File workingDir;

    private File[] files;

    private InputParser parser;

    public FolderSurfer(String path) {
        this.workingDir = new File(path);
        this.updateFiles();
    }

    public Integer execute(String input) {
        this.parser = new InputParser(input);

        if (this.parser.command == Commands.quit)
            return this.stopSim();
        else if (this.parser.command == Commands.help)
            this.help();
        else if (this.parser.command == Commands.cd)
            this.changeDir(this.parser.arguments.get(0));
        else if (this.parser.command == Commands.mkdir)
            this.createDirectory(this.parser.arguments.get(0));
        else if (this.parser.command == Commands.dir)
            this.listFiles();
        else if (this.parser.command == Commands.del)
            this.delete(this.parser.arguments.get(0));
        else if (this.parser.command == Commands.copy)
            this.copyImageFile(this.parser.arguments.get(0), this.parser.arguments.get(1));
        else if (this.parser.command == Commands.word)
            this.listWordDocuments();

        return 1;
    }
    public Integer stopSim() {
        this.workingDir = null;
        this.files = null;
        this.parser = null;

        return -1;
    }
    public void help() {
        System.out.println("Ponudjene komande: " +
                "\n\tmd (name)" +
                "\n\tdir" +
                "\n\tcd (name)" +
                "\n\tdel (name)" +
                "\n\tcopy (src) (dest)" +
                "\n\tword" +
                "\n\tquit"
        );
    }

    private void updateFiles() {
        this.files = new File(this.workingDir.toString()).listFiles();
    }

    public void changeDir(String name) {
        try {
            if (name.equals("..")) {
                if (this.workingDir.getParent() == null)
                    throw new InvalidPathException(name, "no parent dir");

                this.workingDir = this.workingDir.getParentFile();
            }
            else {
                this.workingDir = new File(this.workingDir + File.separator + name);
            }
        } catch (InvalidPathException ex) {
            System.out.println("Greska: Zadata putanja ne postoji u fajl sistemu!");
        }

        // Update files in the current working directory
        this.updateFiles();

        System.out.println("Trenutna putanja: " + this.workingDir.toString());
    }

    void listFiles() {
        System.out.println("Sadrzaj direktorijuma " + this.workingDir.toString());

        for (File f : this.files) {
            if (f.isDirectory())
                System.out.println("<DIR> " + f.toString());
            else System.out.println(f.toString());
        }
    }

    public void createDirectory(String name) {
        File f = new File(this.workingDir + File.separator + name);

        if (f.exists() == false) {
            if (!f.mkdir()) {
                System.out.println("Nije moguce stvoriti dati direktorijum!");
            }
            else this.updateFiles();
        }
        else System.out.println("Direktorijum vec postoji u trenutnoj radnoj putanji!");
    }

    public void delete(String target) {
        File f = new File(this.workingDir + File.separator + target);
        if (!f.exists()) {
            System.out.println("Nije moguce brisanje, datoteka/direktorijum ne postoji!");
        }
        else {
            try {
                if (!f.delete()) {
                    System.out.println("Nije moguce brisanje ciljne datoteke/foldera.");
                } else this.updateFiles();
            } catch (SecurityException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void copyImageFile(String sourceName, String destinationName) {
        if (!sourceName.endsWith(".jpg")) {
            System.out.println("Greska: Datoteka nije tipa JPG.");
            return;
        } else if (!destinationName.endsWith(".jpg")) {
            System.out.println("Greska: Mismatch u ekstenzijama datoteka...");
            return;
        }
        else if (sourceName.equals(destinationName)) { return; }
        else {
            File src = new File(this.workingDir + File.separator + sourceName);
            if (!src.exists()) {
                System.out.println("Greska: Datoteka ne postoji.");
                return;
            }

            File dest = new File(this.workingDir + File.separator + destinationName);
            try (FileInputStream in = new FileInputStream(src);
                FileOutputStream out = new FileOutputStream(dest))
            {
                Integer data;
                while ((data = in.read()) != -1)
                    out.write(data);

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (SecurityException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void listWordDocuments() {
        File[] docs = this.workingDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return (name.endsWith(".docx") || name.endsWith(".docx"));
            }
        });

        if (docs.length == 0) {
            System.out.println("[!] Ne postoji nijedan Word dokument (.doc, .docx)");
            return;
        }

        for (File f : docs) {
            System.out.println(f.toString());
        }
    }
}
