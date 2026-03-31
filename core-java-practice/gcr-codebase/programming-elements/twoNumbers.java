//Write a program to take 2 numbers and print their quotient and reminder
package programmingelements;
import java.util.*;
public class twoNumbers {

	public static void main(String[] args) {
        // Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Take first number input
        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();

        // Take second number input
        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();

        // Calculate quotient and remainder
        int quotient = number1 / number2;
        int remainder = number1 % number2;

        // Display the result
        System.out.println("The Quotient is " + quotient + " and Reminder is " + remainder + " of two number " + number1 + " and " + number2);

        // Close the scanner
        sc.close();

	}

}
