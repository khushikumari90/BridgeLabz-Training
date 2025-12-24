//Create a program to find the power of a number.
package controlflows;
import java.util.*;
public class powerOfNumber {

	public static void main(String[] args) {
		
		// Create Scanner object to take user input
	    Scanner scanner = new Scanner(System.in);

	    // Take input for number
	    System.out.print("Enter the base number: ");
	    int number = scanner.nextInt();

	    // Take input for power
	    System.out.print("Enter the power: ");
        int power = scanner.nextInt();

        // Check for positive integers
	    if (number <= 0 || power < 0) {
            System.out.println("Please enter valid positive integers.");
	     } else {
            // Initialize result
            int result = 1;

            // Calculate power using for loop
	        for (int i = 1; i <= power; i++) {
	             result = result * number;
            }

	        // Display the result
	        System.out.println(number + " raised to the power " + power + " is: " + result);
	     }

         scanner.close();

	}

}
