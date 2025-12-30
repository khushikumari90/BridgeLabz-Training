package scenariobased;
import java.util.Random;
class EmployeeWageComputationProblem {

    // Class constants
    static final int WAGE_PER_HOUR = 20;
    static final int FULL_DAY_HOUR = 8;
    static final int PART_TIME_HOUR = 4;
    static final int WORKING_DAYS = 20;
    static final int MAX_HOURS = 100;

    // UC1: Check employee attendance
    void checkAttendance() {
        Random rand = new Random();
        int attendance = rand.nextInt(2); // 0 or 1

        if (attendance == 1) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }
    }

    // UC2: Calculate daily wage
    int calculateDailyWage() {
        return FULL_DAY_HOUR * WAGE_PER_HOUR;
    }

    // UC3–UC6: Calculate monthly wage using switch case
    int calculateMonthlyWage() {
        int totalWage = 0;
        int totalHours = 0;
        int day = 0;

        Random rand = new Random();

        // Loop till max days or hours reached
        while (day < WORKING_DAYS && totalHours < MAX_HOURS) {
            day++;

            int workType = rand.nextInt(3); // 0-Absent, 1-Full time, 2-Part time
            int hoursWorked;

            switch (workType) {
                case 1:
                    hoursWorked = FULL_DAY_HOUR;
                    break;

                case 2:
                    hoursWorked = PART_TIME_HOUR;
                    break;

                default:
                    hoursWorked = 0;
            }

            totalHours += hoursWorked;
            totalWage += hoursWorked * WAGE_PER_HOUR;
        }

        System.out.println("Total Working Days: " + day);
        System.out.println("Total Working Hours: " + totalHours);

        return totalWage;
    }
}

public class EmployeeWage {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("Welcome to Employee Wage Computation Program");

        // Object creation
        EmployeeWageComputationProblem emp =
                new EmployeeWageComputationProblem();

        // UC1
        emp.checkAttendance();

        // UC2
        System.out.println("Daily Wage: " + emp.calculateDailyWage());

        // UC3 to UC6
        System.out.println("Monthly Wage: " + emp.calculateMonthlyWage());

        System.out.println("Thank You");
    }
}

