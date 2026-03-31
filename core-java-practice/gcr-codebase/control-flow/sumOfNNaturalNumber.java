//Write a program to check for the natural number and write the sum of n natural numbers 
package controlflows;
import java.util.*;
public class sumOfNNaturalNumber {

	public static void main(String[] args) {
		// Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Check if the number is a natural number
        if (number > 0) {

            // Calculate sum of n natural numbers using formula
            int sum = number * (number + 1) / 2;

            // Print output
            System.out.println("The sum of " + number + " natural numbers is " + sum);

        } else {

            // If number is not a natural number
            System.out.println("The number " + number + " is not a natural number");
        }

        // Close scanner
        sc.close();
        
	}

}
