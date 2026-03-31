//Rewrite the above program to find the power of a number using a while loop.
package controlflows;
import java.util.*;
public class powerOfNumberUsingWhileLoop {

	public static void main(String[] args) {
		
		 // Create Scanner object to take user input
		  Scanner scanner = new Scanner(System.in);

	        // Take input for base number
	        System.out.print("Enter the base number: ");
	        int number = scanner.nextInt();

	        // Take input for power
	        System.out.print("Enter the power: ");
	        int power = scanner.nextInt();

	        // Check for valid input
	        if (number <= 0 || power < 0) {
	            System.out.println("Please enter valid positive integers (power can be zero).");
	        } else {
	            // Initialize result
	            int result = 1;

	            // Initialize counter
	            int counter = 0;

	            // While loop until counter equals power
	            while (counter < power) {
	                result = result * number;  // Multiply result by base number
	                counter++;                 // Increment counter
	            }

	            // Display the result
	            System.out.println(number + " raised to the power " + power + " is: " + result);
	        }

	        //Close the scanner
	        scanner.close();
		

	}

}
