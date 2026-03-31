//Create a program to print odd and even numbers between 1 to the number entered by the user.
package controlflows;
import java.util.*;
public class oddAndEven {

	public static void main(String[] args) {
		
		// Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a number
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        // Check if the number is a natural number
        if (number <= 0) {
            System.out.println("Please enter a valid natural number (greater than 0).");
        } else {
            // Loop from 1 to the entered number
            for (int i = 1; i <= number; i++) {

                // Check if the number is even or odd
                if (i % 2 == 0) {
                    System.out.println(i + " is an Even number");
                } else {
                    System.out.println(i + " is an Odd number");
                }
            }
        }

        // Close the scanner
        scanner.close();


	}

}
