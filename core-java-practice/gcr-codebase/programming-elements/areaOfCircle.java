//Write a program to calculate the area of a circle. Take the radius as input.
package programmingelements;
import java.util.*;

public class areaOfCircle {

	public static void main(String[] args) {
		
        // Create Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter the radius of the circle
        System.out.print("Enter the radius of the circle: ");
        double radius = sc.nextDouble();

        // Calculate the area of the circle using the formula
        // Area = π * radius * radius
        double area = Math.PI * radius * radius;

        // Print the area of the circle
        System.out.println("Area of the circle is: " + area);

        // Close the Scanner
        sc.close();

	}

}
