//Create a program to take a number as input find the frequency of each digit in the number using an array and display the frequency of each digit
package arrays;
import java.util.Scanner;
public class Frequency {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a number: ");
	        long number = sc.nextLong();  // Use long to handle large numbers

	        // Step 1: Count the number of digits
	        long temp = number;
	        int count = 0;
	        while (temp != 0) {
	            temp /= 10;
	            count++;
	        }

	        // Step 2: Store digits in an array
	        int[] digits = new int[count];
	        temp = number;
	        for (int i = count - 1; i >= 0; i--) {
	            digits[i] = (int)(temp % 10);
	            temp /= 10;
	        }

	        // Step 3: Find frequency of each digit
	        int[] frequency = new int[10]; // Index 0 to 9
	        for (int i = 0; i < count; i++) {
	            frequency[digits[i]]++;
	        }

	        // Step 4: Display frequency of each digit
	        System.out.println("\nDigit Frequency:");
	        for (int i = 0; i < 10; i++) {
	            if (frequency[i] > 0) {
	                System.out.println("Digit " + i + " appears " + frequency[i] + " times");
	            }
	        }

	        sc.close();

	}

}
