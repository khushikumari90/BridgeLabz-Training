//Create a program to find all the multiples of a number taken as user input below 100.
package controlflows;
import java.util.*;
public class multiplesOfNumberBelowHundred {

	public static void main(String[] args) {
		
		// Create Scanner object to take user input
		Scanner scanner = new Scanner(System.in);

        // Take input from the user
        System.out.print("Enter a positive integer less than 100: ");
        int number = scanner.nextInt();

        // Validate input
        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100.");
        } else {
            System.out.println("Multiples of " + number + " below 100:");

            // Backward loop from 100 to 1
            for (int i = 100; i >= 1; i--) {

                // Check if i is a multiple of number
                if (i % number == 0) {
                    System.out.println(i);
                }
            }
        }

        //Close the scanner
        scanner.close();

	}

}
