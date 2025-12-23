//Write a program that takes the base and height in cm to find the area of a triangle in square inches and square centimeters 
package programmingelements;
import java.util.*;
public class areaOfTriangle {

	public static void main(String[] args) {
		// Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Declare variables for base and height in centimeters
        float base, height;

        // Take input from user
        System.out.print("Enter base of the triangle (in cm): ");
        base = sc.nextFloat();

        System.out.print("Enter height of the triangle (in cm): ");
        height = sc.nextFloat();

        // Calculate area in square centimeters
        float areaSqCm = (base * height) / 2;

        // Convert cm to inches (1 inch = 2.54 cm)
        float baseInInch = base / 2.54f;
        float heightInInch = height / 2.54f;

        // Calculate area in square inches
        float areaSqIn = (baseInInch * heightInInch) / 2;

        // Print the result
        System.out.println(
            "The Area of the triangle in sq in is "
            + areaSqIn + " and sq cm is " + areaSqCm
        );

        // Close the scanner
        sc.close();

	}

}
