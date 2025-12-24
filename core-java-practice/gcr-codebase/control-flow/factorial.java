//Write a Program to find the factorial of an integer entered by the user.
package controlflows;
import java.util.*;
public class factorial {

	public static void main(String[] args) {
		
		// Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt(); // Read integer input from user

        // Check if the number is positive
        if (number < 0) {
            System.out.println("Invalid input! Please enter a positive integer.");
        } else {
            int factorial = 1; // Variable to store factorial result
            int i = 1;         // Counter for while loop

            // Compute factorial using while loop
            while (i <= number) {
                factorial = factorial * i; // Multiply current factorial by i
                i++;                        // Increment counter
            }

            // Display the factorial
            System.out.println("Factorial of " + number + " is: " + factorial);
        }
 
        // Close the scanner
        sc.close(); 

	}

}
