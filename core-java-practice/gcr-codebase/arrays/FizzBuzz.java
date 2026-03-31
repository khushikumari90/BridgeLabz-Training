//Write a program FizzBuzz, take a number as user input and if it is a positive integer loop from 0 to the number and save the number, but for multiples of 3 save "Fizz" instead of the number, for multiples of 5 save "Buzz", and for multiples of both save "FizzBuzz".
package arrays;
import java.util.Scanner;
public class FizzBuzz {

	public static void main(String[] args) {
		
		// Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Take number input from the user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Check if the number is a positive integer
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            sc.close();
            return; // Exit the program
        }

        // Create a String array to store results from 0 to number
        String[] result = new String[number + 1];

        // Loop from 0 to number and store values in array
        for (int i = 0; i <= number; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                result[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                result[i] = "Fizz";
            } else if (i % 5 == 0) {
                result[i] = "Buzz";
            } else {
                result[i] = String.valueOf(i);
            }
        }

        // Loop again to display results with index position
        System.out.println("\nFizzBuzz Results:");
        for (int i = 0; i < result.length; i++) {
            System.out.println("Position " + i + " = " + result[i]);
        }

        // Close scanner
        sc.close();

	}

}
