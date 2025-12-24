//Create a program to check if a number taken from the user is a Harshad Number.
package controlflows;
import java.util.*;
public class harshadNumber {

	public static void main(String[] args) {
		
		// Create Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Get integer input from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Store original number for later use
        int originalNumber = number;

        // Initialize sum of digits to 0
        int sum = 0;

        // While loop to extract each digit
        while (number != 0) {
            int digit = number % 10; // Get last digit
            sum = sum + digit;       // Add digit to sum
            number = number / 10;    // Remove last digit
        }

        // Check if original number is divisible by sum of digits
        if (originalNumber % sum == 0) {
            System.out.println("Harshad Number");
        } else {
            System.out.println("Not a Harshad Number");
        }

        // Close the scanner
        sc.close();

	}

}
