package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Student class
class Student {
    private String id;
    private String name;
    private int age;
    private double marks;

    public Student(String id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Age=" + age + ", Marks=" + marks + "]";
    }
}

// Main class
public class CSVtoStudentObjects {
    public static void main(String[] args) {
        String filePath = "students.csv"; // CSV file path
        String line = "";
        String splitBy = ",";

        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read header
            String header = br.readLine();
            System.out.println("Header: " + header);

            // Read each row
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);

                // Parse data and create Student object
                String id = data[0].trim();
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                double marks = Double.parseDouble(data[3].trim());

                Student student = new Student(id, name, age, marks);
                students.add(student);
            }

            // Print all student objects
            System.out.println("\nAll Students:");
            for (Student s : students) {
                System.out.println(s);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in CSV: " + e.getMessage());
        }
    }
}
