//Create a program to find the multiplication table of a number entered by the user from 6 to 9 and display the result
package arrays;
import java.util.Scanner;
public class MultiplicationTableSixToNine {

	public static void main(String[] args) {
		
		// Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Take integer input from the user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Define an integer array to store multiplication results (6 to 9)
        int[] multiplicationResult = new int[4];

        // Using for loop to calculate multiplication from 6 to 9
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }

        // Display the multiplication table from the array
        System.out.println("\nMultiplication Table of " + number + " (6 to 9):");
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 6]);
        }

        // Close the scanner
        sc.close();

	}

}
