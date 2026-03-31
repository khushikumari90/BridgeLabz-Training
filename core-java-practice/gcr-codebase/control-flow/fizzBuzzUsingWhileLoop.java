//Rewrite the program 4 FizzBuzz using the while loop 
package controlflows;
import java.util.*;
public class fizzBuzzUsingWhileLoop {

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
            // Initialize counter variable
            int i = 1;

            // Loop from 1 to the entered number using while loop
            while (i <= number) {

                // Check multiples of both 3 and 5
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                }
                // Check multiples of 3
                else if (i % 3 == 0) {
                    System.out.println("Fizz");
                }
                // Check multiples of 5
                else if (i % 5 == 0) {
                    System.out.println("Buzz");
                }
                // Print the number if none of the above
                else {
                    System.out.println(i);
                }

                // Increment the counter
                i++;
            }
        }

        // Close the scanner
        scanner.close();

	}

}
