//Rewrite the above program to print the greatest factor of a number beside itself using a while loop.
package controlflows;
import java.util.*;
public class greatestFactorUsingWhileLoop {

	public static void main(String[] args) {
		
		// Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Take integer input from the user
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check for valid input
        if (number <= 1) {
            System.out.println("Please enter an integer greater than 1.");
        } else {
            // Initialize greatestFactor to 1
            int greatestFactor = 1;

            // Initialize counter to number - 1
            int counter = number - 1;

            // While loop from number-1 to 1
            while (counter >= 1) {

                // Check if counter is a factor of number
                if (number % counter == 0) {
                    greatestFactor = counter;
                    break; // Exit loop after finding greatest factor
                }

                // Decrement counter
                counter--;
            }

            // Display the result
            System.out.println("Greatest factor of " + number +
                               " besides itself is: " + greatestFactor);
        }
        
        //Close the scanner
        scanner.close();

	}

}
