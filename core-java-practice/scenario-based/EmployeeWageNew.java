package extrascenariobased;

import java.util.Random;

public class EmployeeWageNew {

    // Constants
    static final int IS_FULL_TIME = 1;
    static final int IS_PART_TIME = 2;
    static final int WAGE_PER_HOUR = 20;
    static final int FULL_TIME_HOURS = 8;
    static final int PART_TIME_HOURS = 4;
    static final int MAX_WORKING_DAYS = 20;
    static final int MAX_WORKING_HOURS = 100;

    Random rand = new Random();

    // UC1: Check Employee Attendance
    void checkAttendance() {
        int attendance = rand.nextInt(2);
        if (attendance == 1) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }
    }

    // UC2–UC4: Get daily working hours
    int getWorkHours() {
        int empType = rand.nextInt(3); // 0-Absent, 1-Full Time, 2-Part Time

        switch (empType) {
            case IS_FULL_TIME:
                return FULL_TIME_HOURS;
            case IS_PART_TIME:
                return PART_TIME_HOURS;
            default:
                return 0;
        }
    }

    // UC2: Daily Wage Calculation
    int calculateDailyWage() {
        return FULL_TIME_HOURS * WAGE_PER_HOUR;
    }

    // UC5–UC6: Monthly Wage Calculation with Day-wise Hours
    int calculateMonthlyWage() {
        int totalWorkingDays = 0;
        int totalWorkingHours = 0;
        int totalWage = 0;

        System.out.println("\nDay-wise Working Hours:");

        while (totalWorkingDays < MAX_WORKING_DAYS &&
               totalWorkingHours < MAX_WORKING_HOURS) {

            totalWorkingDays++;

            int dailyHours = getWorkHours();

            // Ensure hours do not exceed max limit
            if (totalWorkingHours + dailyHours > MAX_WORKING_HOURS) {
                dailyHours = MAX_WORKING_HOURS - totalWorkingHours;
            }

            totalWorkingHours += dailyHours;
            totalWage += dailyHours * WAGE_PER_HOUR;

            // Print day-wise details
            System.out.println("Day " + totalWorkingDays +
                    " -> Work Hours: " + dailyHours);
        }

        System.out.println("\nTotal Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHours);

        return totalWage;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program");

        EmployeeWageNew emp = new EmployeeWageNew();

        // UC1
        emp.checkAttendance();

        // UC2
        System.out.println("Daily Wage: " + emp.calculateDailyWage());

        // UC3–UC6
        System.out.println("\nMonthly Wage: " + emp.calculateMonthlyWage());

        System.out.println("\nThank You");
    }
}

