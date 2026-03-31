//Write a program to store multiple values in an array up to a maximum of 10 or until the user enters a 0 or a negative number. Show all the numbers as well as the sum of all numbers 
package arrays;
import java.util.Scanner;
public class UserEnterZero {

	public static void main(String[] args) {
		
		// Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Create an array of 10 double elements
        double[] numbers = new double[10];

        // Variable to store total sum
        double total = 0.0;

        // Index variable for array
        int index = 0;

        // Infinite while loop
        while (true) {

            // Check if array size limit reached
            if (index == 10) {
                System.out.println("Array limit reached (10 values).");
                break;
            }

            // Take user input
            System.out.print("Enter a number: ");
            double value = sc.nextDouble();

            // Break if user enters 0 or negative number
            if (value <= 0) {
                System.out.println("Stopping input...");
                break;
            }

            // Store value in array and increment index
            numbers[index] = value;
            index++;
        }

        // Display stored numbers and calculate total
        System.out.println("\nStored Numbers:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        // Display total sum
        System.out.println("\nSum of all numbers = " + total);

        // Close scanner
        sc.close();

	}

}
