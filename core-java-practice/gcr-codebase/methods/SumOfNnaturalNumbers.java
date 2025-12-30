//Write a program to find the sum of n natural numbers using recursive method and compare the result with the formulae n*(n+1)/2 and show the result from both computations is correct
package methods;
import java.util.Scanner;
public class SumOfNnaturalNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        // Check if input is a natural number
        if (n <= 0) {
            System.out.println("Please enter a valid natural number (greater than 0).");
            sc.close();
            return;
        }

        // Calculate sum using recursion
        int recursiveSum = sumUsingRecursion(n);

        // Calculate sum using formula
        int formulaSum = sumUsingFormula(n);

        // Display results
        System.out.println("\nSum using Recursion: " + recursiveSum);
        System.out.println("Sum using Formula (n*(n+1)/2): " + formulaSum);

        // Compare both results
        if (recursiveSum == formulaSum) {
            System.out.println("\nResult: Both computations are CORRECT and MATCH.");
        } else {
            System.out.println("\nResult: Computations DO NOT MATCH.");
        }

        sc.close();

	}
	 /**
     * Method to find sum of n natural numbers using recursion
     */
    public static int sumUsingRecursion(int n) {
        if (n == 1) {
            return 1;   // Base condition
        }
        return n + sumUsingRecursion(n - 1);
    }

    /**
     * Method to find sum of n natural numbers using formula
     */
    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2;
    }

}
