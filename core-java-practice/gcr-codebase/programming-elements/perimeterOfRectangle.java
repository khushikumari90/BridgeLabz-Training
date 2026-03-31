//Write a program to calculate the perimeter of a rectangle. Take the length and width as inputs.
package programmingelements;
import java.util.*;
public class perimeterOfRectangle {

	public static void main(String[] args) {
		
		// Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter the length of the rectangle
        System.out.print("Enter the length of the rectangle: ");
        double length = sc.nextDouble();

        // Ask the user to enter the width of the rectangle
        System.out.print("Enter the width of the rectangle: ");
        double width = sc.nextDouble();

        // Calculate the perimeter using the formula
        // Perimeter = 2 * (length + width)
        double perimeter = 2 * (length + width);

        // Display the perimeter of the rectangle
        System.out.println("Perimeter of the rectangle is: " + perimeter);

        // Close the Scanner
        sc.close();

	}

}
