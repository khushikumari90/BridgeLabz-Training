//Write a program that takes two numbers as input from the user and prints their sum.
package programmingelements;
import java.util.*; 
public class addTwoNumbers {

	public static void main(String[] args) {
		// Create Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter the first number
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        // Ask the user to enter the second number
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        // Calculate the sum of the two numbers
        int sum = num1 + num2;

        // Print the result
        System.out.println("Sum of the two numbers is: " + sum);

        // Close the Scanner
        sc.close();

	}

}
