import java.io.*;
import java.nio.file.*;
import java.util.*;

public class StudentskaSluzba {
    public static void main(String[] args) {
        // Inicijalizujmo par studenata
        Student s1 = new Student("1163/20", 8.56, 7.00, 9.00, 9.234);
        Student s2 = new Student("1161/20", 7.25, 8.09, 10.0, 9.64);
        Student s3 = new Student("1159/20", 6.00, 6.00, 7.00, 7.11);
        Student s4 = new Student("1162/20", 5.99, 6.00, 9.99, 10.0);

        // Sacuvajmo studente u ./grades.txt
        try (FileOutputStream fout = new FileOutputStream("./grades.txt");
            PrintWriter pw = new PrintWriter(fout)) {
            pw.println(s1.toString());
            pw.println(s2.toString());
            pw.println(s3.toString());
            pw.println(s4.toString());
        } catch (IOException ex) { ex.printStackTrace(); }

        // Ucitajmo studente
        StudentOrganisation.loadStudents();
        StudentOrganisation.listStudents();

        // Dodajmo novog studenta
        StudentOrganisation.addStudent(new Student("1234/21", 8.00, 8.00, 8.00, 8.00));

        // Da li se upisao?
        StudentOrganisation.listStudents();
    }
}
