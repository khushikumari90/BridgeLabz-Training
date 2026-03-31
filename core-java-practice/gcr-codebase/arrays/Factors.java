//Create a program to find the factors of a number taken as user input, store the factors in an array, and display the factors
package arrays;
import java.util.Scanner;
public class Factors {

	public static void main(String[] args) {
		
		// Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Take input number from the user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Initial maximum size for factors array
        int maxFactor = 10;

        // Create factors array with initial size
        int[] factors = new int[maxFactor];

        // Index variable to track number of factors
        int index = 0;

        // Loop from 1 to the number to find factors
        for (int i = 1; i <= number; i++) {

            // Check if i is a factor of the number
            if (number % i == 0) {

                // If array is full, increase its size
                if (index == maxFactor) {

                    // Double the size
                    maxFactor = maxFactor * 2;

                    // Create a temporary array with increased size
                    int[] temp = new int[maxFactor];

                    // Copy elements from old array to new array
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }

                    // Assign factors array to temp array
                    factors = temp;
                }

                // Store the factor and increment index
                factors[index] = i;
                index++;
            }
        }

        // Display the factors
        System.out.println("\nFactors of " + number + ":");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        // Close the scanner
        sc.close();

	}

}
