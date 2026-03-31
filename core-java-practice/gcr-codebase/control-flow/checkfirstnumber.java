//Write a program to check if the first is the smallest of the 3 numbers.
package controlflows;
import java.util.*;
public class checkfirstnumber {

	public static void main(String[] args) {
		
	    // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Take inputs from user
        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int number3 = sc.nextInt();

        // Check if first number is the smallest
        boolean result = (number1 < number2 && number1 < number3);

        // Print output
        System.out.println("Is the first number the smallest? " + result);

        // Close scanner
        sc.close();

	}

}