//Rewrite the program 10 to find the sum until the user enters 0 or a negative number using while loop and break statement
package controlflows;
import java.util.*;
public class entersZeroOrNegativeNumber {

	public static void main(String[] args) {
		// Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Variable to store total sum
        double total = 0.0;

        // Infinite while loop
        while (true) {

            System.out.print("Enter a number (0 or negative to stop): ");
            double number = sc.nextDouble();

            // Check stopping condition
            if (number <= 0) {
                break;
            }

            // Add number to total
            total = total + number;
        }

        // Display total sum
        System.out.println("Total sum is: " + total);

        sc.close();


	}

}
