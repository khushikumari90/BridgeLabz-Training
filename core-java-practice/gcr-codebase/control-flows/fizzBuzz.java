//Write a program FizzBuzz, take a number as user input, and check for a positive integer. If positive integer, loop and print the number, but for multiples of 3 print "Fizz" instead of the number, for multiples of 5 print "Buzz", and for multiples of both print "FizzBuzz".
package controlflows;
import java.util.*;
public class fizzBuzz {

	public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Take number input from the user
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check if the number is a positive integer
        if (number <= 0) {
            System.out.println("Please enter a valid positive integer.");
        } else {
            // Loop from 1 to the entered number
            for (int i = 1; i <= number; i++) {

                // Check multiples of both 3 and 5 first
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
            }
        }

        // Close the scanner
        scanner.close();

	}

}
