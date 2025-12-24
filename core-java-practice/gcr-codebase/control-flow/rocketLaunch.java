//Write a program to count down the number from the user input value to 1 using a while loop for a rocket launch.
package controlflows;
import java.util.*;
public class rocketLaunch {

	public static void main(String[] args) {
		// Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter countdown starting number
        System.out.print("Enter the countdown start number: ");
        int counter = scanner.nextInt();

        // While loop to count down until 1
        while (counter >= 1) {
            System.out.println(counter);
            counter--; // Decrement the counter
        }

        // Print launch message
        System.out.println("Rocket Launched ");

        // Close the scanner
        scanner.close();

	}

}
