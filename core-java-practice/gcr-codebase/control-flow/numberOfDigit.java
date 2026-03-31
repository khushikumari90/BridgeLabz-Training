//Create a program to count the number of digits in an integer.
package controlflows;
import java.util.*;
public class numberOfDigit {

	public static void main(String[] args) {
		
	    // Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Get integer input from the user
        System.out.print("Enter an integer number: ");
        int number = scanner.nextInt();

        // Create count variable and initialize it to 0
        int count = 0;

        // Special case: if the number is 0, it has 1 digit
        if (number == 0) {
            count = 1;
        } else {
            // Loop until number becomes 0
            while (number != 0) {
                // Remove the last digit from the number
                number = number / 10;

                // Increase the count by 1
                count++;
            }
        }

        // Display the total number of digits
        System.out.println("Number of digits = " + count);

        // Close the scanner
        scanner.close();

	}

}
