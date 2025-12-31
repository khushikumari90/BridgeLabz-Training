//Problem 4: Employee Records
package constructor;
public class EmployeeRecords {

    // Parent Class
    static class Employee {

        // Access Modifiers
        public int employeeID;           // public
        protected String department;     // protected
        private double salary;           // private

        // Constructor
        Employee(int employeeID, String department, double salary) {
            this.employeeID = employeeID;
            this.department = department;
            this.salary = salary;
        }

        // Public method to modify private salary
        public void setSalary(double salary) {
            this.salary = salary;
        }

        // Public method to access private salary
        public double getSalary() {
            return salary;
        }
    }

    // Child Class
    static class Manager extends Employee {

        String role;

        Manager(int employeeID, String department, double salary, String role) {
            super(employeeID, department, salary);
            this.role = role;
        }

        // Method demonstrating access to public & protected members
        void displayManagerDetails() {
            System.out.println("Employee ID: " + employeeID);     // public
            System.out.println("Department: " + department);     // protected
            System.out.println("Salary: " + getSalary());         // private via method
            System.out.println("Role: " + role);
        }
    }

    // Main Method
    public static void main(String[] args) {

        Manager manager =
                new Manager(1001, "IT", 75000, "Project Manager");

        // Modify salary using public method
        manager.setSalary(85000);

        // Display details
        manager.displayManagerDetails();
    }
}

