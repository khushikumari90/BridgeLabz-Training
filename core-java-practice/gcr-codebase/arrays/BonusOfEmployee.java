//Create a program to find the bonus of 10 employees based on their years of service and the total bonus amount the company Zara has to pay, along with the old and new salary.
package arrays;
import java.util.Scanner;
public class BonusOfEmployee {

	public static void main(String[] args) {
		
        //Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Number of employees
        int size = 10;

        // Arrays to store salary and years of service
        double[] salary = new double[size];
        double[] yearsOfService = new double[size];

        // Arrays to store bonus and new salary
        double[] bonus = new double[size];
        double[] newSalary = new double[size];

        // Variables to store totals
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        // Loop to take input from the user
        for (int i = 0; i < size; i++) {

            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("Enter salary: ");
            double sal = sc.nextDouble();

            System.out.print("Enter years of service: ");
            double years = sc.nextDouble();

            // Validate input
            if (sal <= 0 || years < 0) {
                System.out.println("Invalid input! Please enter valid salary and years of service.");
                i--; // Decrement index to retry input for same employee
                continue;
            }

            salary[i] = sal;
            yearsOfService[i] = years;
        }

        // Loop to calculate bonus, new salary, and totals
        for (int i = 0; i < size; i++) {

            // Calculate bonus based on years of service
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05; // 5% bonus
            } else {
                bonus[i] = salary[i] * 0.02; // 2% bonus
            }

            // Calculate new salary
            newSalary[i] = salary[i] + bonus[i];

            // Add to totals
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // Display results
        System.out.println("\n===== Zara Bonus Summary =====");
        System.out.println("Total Old Salary of Employees : " + totalOldSalary);
        System.out.println("Total Bonus Paid              : " + totalBonus);
        System.out.println("Total New Salary After Bonus  : " + totalNewSalary);

        //Close the scanner
        sc.close();

	}

}
