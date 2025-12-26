//Rewrite program 14 using for loop
package controlflows;
import java.util.*;
public class factorialUsingForLoop {

	public static void main(String[] args) {
		 // Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt(); // Read integer input from user

        // Check if the number is positive
        if (number < 0) {
            System.out.println("Invalid input! Please enter a positive integer.");
        } else {
            int factorial = 1; // Variable to store factorial result

            // Compute factorial using for loop
            for (int i = 1; i <= number; i++) {
                factorial = factorial * i; // Multiply current factorial by i
            }

            // Display the factorial
            System.out.println("Factorial of " + number + " is: " + factorial);
        }

        // Close the Scanner
        sc.close();

	}

}
