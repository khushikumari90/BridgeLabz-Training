package oopsscenariobased;
import java.util.*;

class InvalidMarkException extends Exception {
    public InvalidMarkException(String msg) {
        super(msg);
    }
}

class Student {
    String name;
    int[] marks;
    String[] subjects;

    Student(String name, String[] subjects, int[] marks) throws InvalidMarkException {
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;

        for (int m : marks) {
            if (m < 0 || m > 100) {
                throw new InvalidMarkException("Marks must be between 0 and 100");
            }
        }
    }

    double average() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum / (double) marks.length;
    }

    String grade() {
        double avg = average();
        if (avg >= 75) return "A";
        if (avg >= 60) return "B";
        if (avg >= 40) return "C";
        return "Fail";
    }

    void displayReport() {
        System.out.println("Student: " + name);
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + marks[i]);
        }
        System.out.println("Average: " + average());
        System.out.println("Grade: " + grade());
        System.out.println("--------------------");
    }
}

public class StudentReportGenerator {
    public static void main(String[] args) throws Exception {
        List<Student> students = new ArrayList<>();

        students.add(new Student(
                "Anita",
                new String[]{"Math", "Science", "English"},
                new int[]{85, 78, 90}
        ));

        for (Student s : students) {
            s.displayReport();
        }
    }
}

