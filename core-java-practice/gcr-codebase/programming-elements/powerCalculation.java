//Write a program that takes two numbers as input: a base and an exponent, and prints the result of base raised to the exponent (without using loops or conditionals).
package programmingelements;
import java.util.*;
public class powerCalculation {

	public static void main(String[] args) {
		
		// Create Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter the base value
        System.out.print("Enter the base: ");
        double base = sc.nextDouble();

        // Ask the user to enter the exponent value
        System.out.print("Enter the exponent: ");
        double exponent = sc.nextDouble();

        // Calculate power using Math.pow() method
        // Math.pow(base, exponent) returns base raised to the exponent
        double result = Math.pow(base, exponent);

        // Display the result
        System.out.println("Result: " + result);

        // Close the Scanner
        sc.close();

	}

}
