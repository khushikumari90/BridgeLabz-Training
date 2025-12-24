//Create a program to find the factors of a number taken as user input.
package controlflows;
import java.util.*;
public class factorsOfNumber {

	public static void main(String[] args) {
		
		// Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Take number input from the user
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check if the number is a positive integer
        if (number <= 0) {
            System.out.println("Please enter a valid positive integer.");
        } else {
            System.out.println("Factors of " + number + " are:");

            // Loop from 1 to less than the number
            for (int i = 1; i < number; i++) {

                // Check if number is perfectly divisible by i
                if (number % i == 0) {
                    System.out.println(i);
                }
            }
        }

        // Close the scanner
        scanner.close();

	}

}
