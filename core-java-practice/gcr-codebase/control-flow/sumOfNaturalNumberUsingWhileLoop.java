//Write a program to find the sum of n natural numbers using while loop compare the result with the formulae n*(n+1)/2 and show the result from both computations was correct. 
package controlflows;
import java.util.*;
public class sumOfNaturalNumberUsingWhileLoop {

	public static void main(String[] args) {
		
		// Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number (n > 0): ");
        int n = sc.nextInt();

        // Check if input is a natural number
        if (n <= 0) {
            System.out.println("Invalid input! Please enter a natural number greater than 0.");
        } else {
            // Using while loop to calculate sum
            int sumLoop = 0;
            int i = 1;
            while (i <= n) {
                sumLoop += i; // Add i to sum
                i++;
            }

            // Using formula n*(n+1)/2
            int sumFormula = n * (n + 1) / 2;

            // Display results
            System.out.println("Sum using while loop: " + sumLoop);
            System.out.println("Sum using formula: " + sumFormula);

            // Compare results
            if (sumLoop == sumFormula) {
                System.out.println("Both computations are correct!");
            } else {
                System.out.println("There is a mistake in the calculations.");
            }
        }
        
        // Close the scanner
        sc.close();


	}

}
