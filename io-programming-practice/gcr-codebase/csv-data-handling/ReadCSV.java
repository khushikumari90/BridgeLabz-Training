package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Path to your CSV file
        String line = "";
        String splitBy = ","; // CSV delimiter

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Student Details:");
            System.out.println("-------------------------------");
            while ((line = br.readLine()) != null) {
                // Split line by comma
                String[] student = line.split(splitBy);

                // Assuming CSV format: ID,Name,Age,Marks
                String id = student[0];
                String name = student[1];
                String age = student[2];
                String marks = student[3];

                // Print in structured format
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Marks: " + marks);
                System.out.println("-------------------------------");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
