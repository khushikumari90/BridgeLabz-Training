//Create a program to print the greatest factor of a number beside itself using a loop.
package controlflows;
import java.util.*;
public class greatestFactor {

	public static void main(String[] args) {
		
		// Create Scanner object to take user input
		Scanner scanner = new Scanner(System.in);

        // Take integer input
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check for valid positive integer
        if (number <= 1) {
            System.out.println("Please enter an integer greater than 1.");
        } else {
            // Initialize greatestFactor to 1
            int greatestFactor = 1;

            // Loop from number-1 down to 1
            for (int i = number - 1; i >= 1; i--) {

                // Check if i is a factor
                if (number % i == 0) {
                    greatestFactor = i;
                    break; // Stop after finding the greatest factor
                }
            }

            // Display the result
            System.out.println("Greatest factor of " + number +
                               " besides itself is: " + greatestFactor);
        }

      //Close the scanner
        scanner.close();

	}

}
