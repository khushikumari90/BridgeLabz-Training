//Write a program that takes three numbers as input from the user and prints their average.
package programmingelements;
import java.util.*;
public class averageOfThreeNumbers {

	public static void main(String[] args) {
		
		// Create Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter the first number
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        // Ask the user to enter the second number
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        // Ask the user to enter the third number
        System.out.print("Enter third number: ");
        double num3 = sc.nextDouble();

        // Calculate the average of the three numbers
        double average = (num1 + num2 + num3) / 3;

        // Display the average
        System.out.println("Average of the three numbers is: " + average);

        // Close the Scanner
        sc.close();

	}

}
