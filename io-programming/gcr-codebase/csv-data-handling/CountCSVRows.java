package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "students.csv"; // CSV file path
        String line = "";
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read header row first
            br.readLine(); // Skip header

            // Count remaining lines
            while ((line = br.readLine()) != null) {
                count++;
            }

            System.out.println("Number of records (excluding header): " + count);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
