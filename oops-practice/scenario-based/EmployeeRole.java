package oops_scenario_based;
abstract class Employee {

    private final String name;
    private final double salary;

    protected Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    protected double getSalary() {
        return salary;
    }

    public abstract double getBonus();
}

class Manager extends Employee {

    private final double bonus;

    public Manager(String name, double salary) {
        super(name, salary);
        this.bonus = salary * 0.10;
    }

    @Override
    public double getBonus() {
        return bonus;
    }
}

class Developer extends Employee {

    private final double bonus;

    public Developer(String name, double salary) {
        super(name, salary);
        this.bonus = salary > 50000 ? salary * 0.05 : 0.0;
    }

    @Override
    public double getBonus() {
        return bonus;
    }
}

public class EmployeeRole {
    public static void main(String[] args) {

        Employee manager = new Manager("Alice", 80000);
        System.out.printf("%.2f%n", manager.getBonus());

        Employee dev1 = new Developer("Bob", 60000);
        System.out.printf("%.2f%n", dev1.getBonus());

        Employee dev2 = new Developer("Charlie", 40000);
        System.out.printf("%.2f%n", dev2.getBonus());
    }
}
