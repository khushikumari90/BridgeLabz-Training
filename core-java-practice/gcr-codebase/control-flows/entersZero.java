//Write a program to find the sum of numbers until the user enters 0
package controlflows;
import java.util.*;
public class entersZero {

	public static void main(String[] args) {
		// Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Initialize total to 0.0
        double total = 0.0;

        // Variable to store user input
        double number;

        // Ask user to enter a number
        System.out.print("Enter a number (0 to stop): ");
        number = scanner.nextDouble();

        // While loop continues until user enters 0
        while (number != 0) {
            total = total + number;   // Add number to total

            // Ask for next number
            System.out.print("Enter a number (0 to stop): ");
            number = scanner.nextDouble();
        }

        // Display the total sum
        System.out.println("Total sum is: " + total);

        // Close the scanner
        scanner.close();

	}

}
