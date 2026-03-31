package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Employee class
class Employee {
    String id;
    String name;
    String department;
    double salary;

    public Employee(String id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getter method for salary (needed for Comparator)
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + department + ", " + String.format("%.2f", salary);
    }
}

// Main class
public class SortCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // CSV file path
        String line = "";
        String splitBy = ",";

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read header
            String header = br.readLine();
            System.out.println("Top 5 Highest-Paid Employees:");
            System.out.println(header);

            // Read records
            while ((line = br.readLine()) != null) {
                String[] empData = line.split(splitBy);
                String id = empData[0];
                String name = empData[1];
                String department = empData[2];
                double salary = Double.parseDouble(empData[3]);

                employees.add(new Employee(id, name, department, salary));
            }

            // Sort employees by salary in descending order
            employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());

            // Print top 5 highest-paid employees
            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                System.out.println(employees.get(i));
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in CSV: " + e.getMessage());
        }
    }
}
