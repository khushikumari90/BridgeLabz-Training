//Rewrite the above program 7 to find the factors of a number using the while loop
package controlflows;
import java.util.*;
public class factorsOfNumberUsinggWhileLoop {

	public static void main(String[] args) {
		
        // Create Scanner object to take user input
		Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check for positive integer
        if (number <= 0) {
            System.out.println("Please enter a valid positive integer.");
        } else {
            System.out.println("Factors of " + number + " are:");

            int counter = 1;

            // While loop to find factors
            while (counter < number) {
                if (number % counter == 0) {
                    System.out.println(counter);
                }
                counter++;
            }
        }
        
        //Close the scanner
        scanner.close();

	}

}
