//Create a program to save odd and even numbers into odd and even arrays between 1 to the number entered by the user. Finally, print the odd and even numbers array
package arrays;
import java.util.Scanner;
public class OddAndEven {

	public static void main(String[] args) {
		
		// Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Get integer input from the user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Check if the number is a natural number
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number greater than 0.");
            sc.close();
            return; // Exit the program
        }

        // Create arrays for even and odd numbers
        int[] even = new int[number / 2 + 1];
        int[] odd = new int[number / 2 + 1];

        // Index variables for even and odd arrays
        int evenIndex = 0;
        int oddIndex = 0;

        // Iterate from 1 to the given number
        for (int i = 1; i <= number; i++) {

            // Check if number is even
            if (i % 2 == 0) {
                even[evenIndex] = i;
                evenIndex++;
            }
            // Otherwise, number is odd
            else {
                odd[oddIndex] = i;
                oddIndex++;
            }
        }

        // Print odd numbers array
        System.out.println("\nOdd Numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(odd[i] + " ");
        }

        // Print even numbers array
        System.out.println("\n\nEven Numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(even[i] + " ");
        }

        // Close the scanner
        sc.close();

	}

}
