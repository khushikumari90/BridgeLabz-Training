//Write a program to find the side of the square whose parameter you read from the user 
package programmingelements;
import java.util.*;
public class sideOfSquare {

	public static void main(String[] args) {
		// Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Declare variable for perimeter
        double perimeter;

        // Take perimeter input from user
        System.out.print("Enter the perimeter of the square: ");
        perimeter = sc.nextDouble();

        // Calculate side of the square
        // Perimeter of square = 4 * side
        double side = perimeter / 4;

        // Print the result
        System.out.println(
            "The length of the side is " + side +
            " whose perimeter is " + perimeter
        );

        // Close the scanner
        sc.close();

	}

}
