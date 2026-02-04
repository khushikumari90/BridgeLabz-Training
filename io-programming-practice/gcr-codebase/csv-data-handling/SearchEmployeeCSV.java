package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployeeCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // CSV file path
        String line = "";
        String splitBy = ","; // CSV delimiter

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = sc.nextLine().trim();

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read header
            String header = br.readLine();
            System.out.println("Searching in: " + header);

            // Read each record
            while ((line = br.readLine()) != null) {
                String[] employee = line.split(splitBy);

                String id = employee[0];
                String name = employee[1];
                String department = employee[2];
                String salary = employee[3];

                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found!");
                    System.out.println("Name: " + name);
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    found = true;
                    break; // Stop after finding the employee
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}
