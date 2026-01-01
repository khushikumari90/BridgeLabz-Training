//Program 3:Employee Management System
package keyword;
public class Employee {

    static String companyName = "Tech Solutions Inc.";
    static int totalEmployees = 0;

    private final int id;
    private String name;
    private String designation;

    Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void displayEmployee(Object obj) {
        if (obj instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Thamarai", "Software Engineer");
        Employee e2 = new Employee(102, "Rohan", "Project Manager");

        Employee.displayTotalEmployees();
        e1.displayEmployee(e1);
        e2.displayEmployee(e2);
    }
}

