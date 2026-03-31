//Rework the program 2, especially the Hint f where if index equals maxDigit, we break from the loop. Here we want to modify to Increase the size of the array i,e maxDigit by 10 if the index is equal to maxDigit. This is done to consider all digits to find the largest and second-largest number 
package arrays;
import java.util.Scanner;
public class MaxDigit {

	public static void main(String[] args) {
		
		// Scanner class is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Take number input from the user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Initial maximum size of digits array
        int maxDigit = 10;

        // Array to store digits of the number
        int[] digits = new int[maxDigit];

        // Index variable to track position in array
        int index = 0;

        // Loop until the number becomes 0
        while (number != 0) {

            // If array is full, increase its size by 10
            if (index == maxDigit) {

                // Increase maxDigit by 10
                maxDigit = maxDigit + 10;

                // Create a temporary array with new size
                int[] temp = new int[maxDigit];

                // Copy old digits into the new array
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                // Assign digits array to the new temp array
                digits = temp;
            }

            // Extract last digit
            int digit = number % 10;

            // Store digit in array
            digits[index] = digit;
            index++;

            // Remove last digit from number
            number = number / 10;
        }

        // Variables to store largest and second largest digits
        int largest = 0;
        int secondLargest = 0;

        // Loop through the digits array to find largest and second largest
        for (int i = 0; i < index; i++) {

            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } 
            else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Display results
        System.out.println("\nLargest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);

        // Close the scanner
        sc.close();

	}

}
