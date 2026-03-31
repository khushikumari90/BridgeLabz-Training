//Create a program to store the digits of the number in an array and find the largest and second largest element of the array.
package arrays;
import java.util.Scanner;
public class DigitOfTheNumber {

	public static void main(String[] args) {
		
        // Scanner class is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Take number input from the user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Maximum digits allowed in the array
        int maxDigit = 10;

        // Array to store digits of the number
        int[] digits = new int[maxDigit];

        // Index variable to track array position
        int index = 0;

        // Loop until number becomes 0
        while (number != 0) {

            // If array is full, stop adding more digits
            if (index == maxDigit) {
                break;
            }

            // Remove last digit
            int digit = number % 10;

            // Store digit in array
            digits[index] = digit;
            index++;

            // Remove last digit from number
            number = number / 10;
        }

        // Variables to store largest and second largest digit
        int largest = 0;
        int secondLargest = 0;

        // Loop through stored digits to find largest and second largest
        for (int i = 0; i < index; i++) {

            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Display the results
        System.out.println("\nLargest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);

        // Close the scanner
        sc.close();


	}

}
