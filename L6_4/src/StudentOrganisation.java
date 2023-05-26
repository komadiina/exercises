//import javax.annotation.processing.Filer;
import java.io.*;
//import java.nio.file.*;
import java.util.*;

public class StudentOrganisation {
    public static final File STUDENT_PATH = new File("students");
    public static final File GRADES_PATH = new File("grades.txt");

    public static List<Student> studenti = new ArrayList<>();

    public static Boolean addStudent(Student st) {
        // Dodajmo studenta u kolekciju
        studenti.add(st);

        // Dodajmo studentove ocjene u GRADES_PATH fajl
        File f = GRADES_PATH;
        if (!f.canWrite())
            if (!f.setWritable(true)) {
                System.out.println("Nemoguce upisati studenta u fajl!");
                return false;
            }

        try (FileOutputStream gradesFile = new FileOutputStream(f.getPath());
            ObjectOutputStream out = new ObjectOutputStream(gradesFile)) {
            out.writeObject(st);
            out.close();
            return true;
        } catch (IOException ex) { ex.printStackTrace(); }

        return false;
    }

    public static void listStudents() {
        StudentOrganisation.loadStudents();

        for (Student st : StudentOrganisation.studenti) {
            System.out.println(st);
        }
    }

    public static void loadStudents() {
        // entry point: ./grades.txt
        // Ispraznimo trenutnu kolekciju studenata
        StudentOrganisation.studenti.clear();

        // Osigurajmo da postoji STUDENT_PATH folder
        if (!STUDENT_PATH.exists())
            try {
                STUDENT_PATH.mkdir();
            } catch (SecurityException ex) { ex.printStackTrace(); }

        try (BufferedReader reader = new BufferedReader(new FileReader(GRADES_PATH.getPath()))) {
            String line;
            while ((line = reader.readLine()) != null)
                studenti.add(Student.readStudent(line));
        } catch (IOException ex) {
            System.out.println("Nema studenata u bazi podataka!");
            ex.printStackTrace();
        }
    }
}
