//Write a program to take user input for 5 numbers and check whether a number is positive,  negative, or zero. Further for positive numbers check if the number is even or odd. Finally compare the first and last elements of the array and display if they equal, greater or less
package arrays;
import java.util.Scanner;
public class CheckNumber {

	public static void main(String[] args) {
		
		 // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Define an integer array of 5 elements
        int[] numbers = new int[5];

        // Take user input for the array
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("\nNumber Analysis:");

        // Loop through the array to check each number
        for (int i = 0; i < numbers.length; i++) {

            // Check if number is positive
            if (numbers[i] > 0) {
                System.out.print(numbers[i] + " is Positive and ");

                // Check even or odd
                if (numbers[i] % 2 == 0) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            }
            // Check if number is negative
            else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is Negative");
            }
            // If number is zero
            else {
                System.out.println(numbers[i] + " is Zero");
            }
        }

        // Compare first and last elements of the array
        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        System.out.println("\nComparison of First and Last Elements:");

        if (first == last) {
            System.out.println("First and last elements are equal");
        } else if (first > last) {
            System.out.println("First element is greater than last element");
        } else {
            System.out.println("First element is less than last element");
        }

        // Close the scanner
        sc.close();

	}

}
