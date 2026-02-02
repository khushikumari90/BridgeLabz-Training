package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "students1.csv"; // ID, Name, Age
        String file2 = "students2.csv"; // ID, Marks, Grade
        String outputFile = "merged_students.csv";

        Map<String, String[]> map1 = new HashMap<>(); // ID -> [Name, Age]
        Map<String, String[]> map2 = new HashMap<>(); // ID -> [Marks, Grade]

        // Read first CSV
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0].trim();
                String name = parts[1].trim();
                String age = parts[2].trim();
                map1.put(id, new String[]{name, age});
            }
        } catch (IOException e) {
            System.out.println("Error reading " + file1 + ": " + e.getMessage());
        }

        // Read second CSV
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0].trim();
                String marks = parts[1].trim();
                String grade = parts[2].trim();
                map2.put(id, new String[]{marks, grade});
            }
        } catch (IOException e) {
            System.out.println("Error reading " + file2 + ": " + e.getMessage());
        }

        // Merge and write to new CSV
        try (FileWriter fw = new FileWriter(outputFile)) {
            // Write header
            fw.append("ID,Name,Age,Marks,Grade\n");

            // Merge based on ID
            for (String id : map1.keySet()) {
                String[] info1 = map1.get(id);
                String[] info2 = map2.get(id);

                if (info2 != null) { // Only merge if ID exists in both files
                    fw.append(id).append(",")
                      .append(info1[0]).append(",") // Name
                      .append(info1[1]).append(",") // Age
                      .append(info2[0]).append(",") // Marks
                      .append(info2[1]).append("\n"); // Grade
                } else {
                    System.out.println("Warning: ID " + id + " missing in second CSV");
                }
            }

            System.out.println("Merged CSV created successfully: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
