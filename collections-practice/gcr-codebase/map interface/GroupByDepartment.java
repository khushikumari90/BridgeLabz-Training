package map_interface;
import java.util.*;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));

        Map<String, List<Employee>> deptMap = new HashMap<>();

        for (Employee emp : employees) {
            if (!deptMap.containsKey(emp.department)) {
                deptMap.put(emp.department, new ArrayList<>());
            }
            deptMap.get(emp.department).add(emp);
        }

        System.out.println(deptMap);
    }
}
