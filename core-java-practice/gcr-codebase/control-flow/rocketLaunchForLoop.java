//Rewrite program 8 to do the countdown using the for-loop.
package controlflows;
import java.util.*;
public class rocketLaunchForLoop {

	public static void main(String[] args) {
		 // Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Take the countdown starting number from user
        System.out.print("Enter the countdown start number: ");
        int counter = scanner.nextInt();

        // For loop to count down from user input to 1
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }

        // Print launch message
        System.out.println("Rocket Launched");

        // Close the scanner
        scanner.close();

	}

}
