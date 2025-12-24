//Create a program to check if a number is armstrong or not.
package controlflows;
import java.util.*;
public class armstrongNumber {

	public static void main(String[] args) {
		
		    // Create Scanner object to take input
		    Scanner sc = new Scanner(System.in);

	        // Step 1: Input number
	        System.out.print("Enter a number: ");
	        int number = sc.nextInt();

	        // Step 2: Initialize variables
	        int sum = 0;
	        int originalNumber = number;

	        // Step 3: While loop to extract digits
	        while (originalNumber != 0) {

	            // Step 4: Find the last digit
	            int digit = originalNumber % 10;

	            // Step 5: Find cube of the digit and add to sum
	            sum = sum + (digit * digit * digit);

	            // Step 6: Remove the last digit
	            originalNumber = originalNumber / 10;
	        }

	        // Step 7: Check Armstrong condition
	        if (sum == number) {
	            System.out.println(number + " is an Armstrong Number");
	        } else {
	            System.out.println(number + " is Not an Armstrong Number");
	        }
 
	        //Close the scanner
	        sc.close();

	}

}
