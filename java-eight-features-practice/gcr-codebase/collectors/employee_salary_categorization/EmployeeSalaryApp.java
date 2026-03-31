package employee_salary_categorization;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeSalaryApp {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee("Khushi", "IT", 60000),
            new Employee("Amit", "HR", 45000),
            new Employee("Neha", "IT", 70000),
            new Employee("Rahul", "Finance", 55000),
            new Employee("Sneha", "HR", 50000)
        );

        Map<String, Double> avgSalaryByDept =
                employees.stream()
                         .collect(Collectors.groupingBy(
                             Employee::getDepartment,
                             Collectors.averagingDouble(Employee::getSalary)
                         ));

        avgSalaryByDept.forEach((dept, avg) ->
                System.out.println(dept + " Average Salary: ₹" + avg));
    }
}
