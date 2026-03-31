//Create a program to check if a number is an Abundant Number.
package controlflows;
import java.util.*;
public class abundantNumber {

	public static void main(String[] args) {
		
		    // Create Scanner object to take input
		    Scanner sc = new Scanner(System.in);

		    System.out.println("Enter a number : ");
	        // Get input
	        int number = sc.nextInt();

	        // Initialize sum
	        int sum = 0;

	        // Find divisors and calculate sum
	        for (int i = 1; i < number; i++) {
	            if (number % i == 0) {
	                sum = sum + i;
	            }
	        }

	        // Check abundant condition
	        if (sum > number) {
	            System.out.println("Abundant Number");
	        } else {
	            System.out.println("Not an Abundant Number");
	        }

	        //Close the scanner
	        sc.close();
	}

}
