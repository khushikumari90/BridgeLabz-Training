//Create a program to find the bonuses of employees based on their years of service
package controlflows;
import java.util.*;
public class bonusesOfEmployee {

	public static void main(String[] args) {
		
		// Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Take salary input
        System.out.print("Enter your salary: ");
        double salary = scanner.nextDouble();

        // Take years of service input
        System.out.print("Enter your years of service: ");
        int yearsOfService = scanner.nextInt();

        // Check if employee is eligible for bonus
        if (yearsOfService > 5) {
            // Calculate 5% bonus
            double bonus = salary * 0.05;
            System.out.println("You are eligible for a bonus.");
            System.out.println("Bonus Amount: " + bonus);
        } else {
            System.out.println("You are not eligible for a bonus.");
            System.out.println("Bonus Amount: 0");
        }

        // Close the scanner
        scanner.close();
		

	}

}
