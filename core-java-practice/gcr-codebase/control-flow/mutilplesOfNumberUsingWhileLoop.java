//Rewrite the program to find all the multiples of a number below 100 using while loop.
package controlflows;
import java.util.*;
public class mutilplesOfNumberUsingWhileLoop {

	public static void main(String[] args) {
		
		// Create Scanner object to take user input
		Scanner scanner = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a positive integer less than 100: ");
        int number = scanner.nextInt();

        // Validate input
        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100.");
        } else {
            System.out.println("Multiples of " + number + " below 100:");

            // Initialize counter to 99 (largest number below 100)
            int counter = 99;

            // While loop till counter is greater than or equal to number
            while (counter >= number) {

                // Check if counter is a multiple of number
                if (counter % number == 0) {
                    System.out.println(counter);
                }

                // Decrement counter
                counter--;
            }
        }

        //Close the scanner
        scanner.close();


	}

}
