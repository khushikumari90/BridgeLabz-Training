//Create a program to print a multiplication table of a number.
package arrays;
import java.util.Scanner;
public class MultiplicationTable {

	public static void main(String[] args) {
		
		// Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Get integer input from the user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Define an integer array to store multiplication results (1 to 10)
        int[] table = new int[10];

        // Run loop from 1 to 10 and store results in array
        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;
        }

        // Display the multiplication table using array values
        System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + table[i - 1]);
        }

        // Close the scanner
        sc.close();

	}

}
