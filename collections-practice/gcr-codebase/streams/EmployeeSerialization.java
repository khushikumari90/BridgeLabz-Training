package streams;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSerialization {
    public static void main(String[] args) {

        String filePath = "src/streams/employees.dat";

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Amit", "IT", 50000));
        employees.add(new Employee(102, "Neha", "HR", 45000));
        employees.add(new Employee(103, "Rahul", "Finance", 60000));

        // Serialization
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(filePath))) {

            oos.writeObject(employees);
            System.out.println("Employee list serialized successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(filePath))) {

            List<Employee> empList =
                    (List<Employee>) ois.readObject();

            System.out.println("Deserialized Employee List:");
            for (Employee emp : empList) {
                System.out.println(emp);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

