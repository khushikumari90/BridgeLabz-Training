package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DetectDuplicatesCSV {
    public static void main(String[] args) {
        String filePath = "students.csv"; // CSV file path
        String splitBy = ",";

        Map<String, String> idMap = new HashMap<>(); // Stores ID -> full line
        Map<String, String> duplicates = new HashMap<>(); // Stores duplicates

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine(); // Read header
            System.out.println("Header: " + header);

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                String id = data[0].trim();

                if (idMap.containsKey(id)) {
                    // Duplicate found
                    duplicates.put(id, line);
                } else {
                    idMap.put(id, line);
                }
            }

            // Print duplicate records
            if (duplicates.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("\nDuplicate Records Found:");
                for (String dup : duplicates.values()) {
                    System.out.println(dup);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
