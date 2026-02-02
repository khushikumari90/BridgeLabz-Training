package csv_data_handling;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // CSV file to create/write

        // Employee data: ID, Name, Department, Salary
        String[][] employees = {
            {"101", "Rohit", "IT", "50000"},
            {"102", "Sneha", "HR", "45000"},
            {"103", "Ankit", "Finance", "60000"},
            {"104", "Meera", "Marketing", "48000"},
            {"105", "Priya", "Sales", "52000"}
        };

        try (FileWriter fw = new FileWriter(filePath)) {
            // Write header
            fw.append("ID,Name,Department,Salary\n");

            // Write each employee record
            for (String[] emp : employees) {
                fw.append(String.join(",", emp));
                fw.append("\n"); // New line after each record
            }

            System.out.println("CSV file created successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
