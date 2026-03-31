//Create a program to find the multiplication table of a number entered by the user from 6 to 9.
package controlflows;
import java.util.*;
public class multiplicationTable {

	public static void main(String[] args) {
		
		 // Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Take integer input from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Print multiplication table from 6 to 9
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
        }

        // Close the scanner
        scanner.close();

	}

}
