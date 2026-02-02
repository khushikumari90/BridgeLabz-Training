package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSV {
    public static void main(String[] args) {
        String filePath = "students.csv"; // CSV file path
        String line = "";
        String splitBy = ","; // CSV delimiter

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read header row
            String header = br.readLine();
            System.out.println("Students with marks > 80:");
            System.out.println(header); // Print header

            // Read and filter records
            while ((line = br.readLine()) != null) {
                String[] student = line.split(splitBy);

                String id = student[0];
                String name = student[1];
                int marks = Integer.parseInt(student[3]); // Convert marks to integer

                if (marks > 80) {
                    // Print only qualifying records
                    System.out.println(line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in CSV: " + e.getMessage());
        }
    }
}
