package csv_data_handling;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.FileWriter;
import java.io.IOException;

public class ExportToCSV {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/your_database"; // Replace with your DB
        String user = "root"; // DB username
        String password = "password"; // DB password

        String csvFile = "employee_report.csv"; // CSV file to create

        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             FileWriter fw = new FileWriter(csvFile)) {

            // Write header
            fw.append("Employee ID,Name,Department,Salary\n");

            // Write each record
            while (rs.next()) {
                String id = rs.getString("employee_id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                String salary = rs.getString("salary");

                fw.append(id).append(",")
                  .append(name).append(",")
                  .append(department).append(",")
                  .append(salary)
                  .append("\n");
            }

            System.out.println("CSV report generated successfully: " + csvFile);

        } catch (IOException e) {
            System.out.println("Error writing CSV file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
