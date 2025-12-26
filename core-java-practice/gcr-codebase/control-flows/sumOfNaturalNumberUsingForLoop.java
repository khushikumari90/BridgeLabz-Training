//Rewrite the program number 12 with the for loop instead of a while loop to find the sum of n Natural Numbers.
package controlflows;
import java.util.*;
public class sumOfNaturalNumberUsingForLoop {

	public static void main(String[] args) {
		
		// Create Scanner object to take user input
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number (n > 0): ");
        int n = sc.nextInt();

        // Check if input is a natural number
        if (n <= 0) {
            System.out.println("Invalid input! Please enter a natural number greater than 0.");
        } else {
            // Using for loop to calculate sum
            int sumFor = 0;
            for (int i = 1; i <= n; i++) {
                sumFor += i; // Add i to sum
            }

            // Using formula n*(n+1)/2
            int sumFormula = n * (n + 1) / 2;

            // Display results
            System.out.println("Sum using for loop: " + sumFor);
            System.out.println("Sum using formula: " + sumFormula);

            // Compare results
            if (sumFor == sumFormula) {
                System.out.println("Both computations are correct!");
            } else {
                System.out.println("There is a mistake in the calculations.");
            }
        }

        // Close the scanner
        sc.close();

	}

}
