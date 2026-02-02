package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFile = "employees.csv";       // Original CSV file
        String outputFile = "employees_updated.csv"; // Updated CSV file

        String line = "";
        String splitBy = ","; // CSV delimiter

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             FileWriter fw = new FileWriter(outputFile)) {

            // Read header and write to new file
            String header = br.readLine();
            fw.append(header).append("\n");

            // Process each record
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(splitBy);

                String id = employee[0];
                String name = employee[1];
                String department = employee[2];
                double salary = Double.parseDouble(employee[3]);

                // Increase salary by 10% if department is IT
                if (department.equalsIgnoreCase("IT")) {
                    salary = salary + salary * 0.10; // 10% increase
                }

                // Write updated record to new CSV
                fw.append(id).append(",")
                  .append(name).append(",")
                  .append(department).append(",")
                  .append(String.format("%.2f", salary)) // Format salary to 2 decimal places
                  .append("\n");
            }

            System.out.println("Updated CSV file created successfully: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in CSV: " + e.getMessage());
        }
    }
}
