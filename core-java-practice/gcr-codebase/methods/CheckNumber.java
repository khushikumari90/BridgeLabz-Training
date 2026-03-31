//Write a program to check whether a number is positive, negative, or zero.
package methods;
import  java.util.Scanner;
public class CheckNumber {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        // Ask the user for input
	        System.out.print("Enter an integer: ");
	        int number = sc.nextInt();

	        // Call the method and store the result
	        int result = checkNumber(number);

	        // Display the result
	        if (result == 1) {
	            System.out.println("The number is positive.");
	        } else if (result == -1) {
	            System.out.println("The number is negative.");
	        } else {
	            System.out.println("The number is zero.");
	        }

	        sc.close();
	}
	// Method to check whether a number is positive, negative, or zero
    public static int checkNumber(int num) {
        if (num > 0) {
            return 1;   // Positive number
        } else if (num < 0) {
            return -1;  // Negative number
        } else {
            return 0;   // Zero
        }
    }
}
