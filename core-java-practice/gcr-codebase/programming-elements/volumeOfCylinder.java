//Write a program to calculate the volume of a cylinder. Take the radius and height as inputs.
package programmingelements;
import java.util.*;
public class volumeOfCylinder {

	public static void main(String[] args) {
		
		 // Create Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter the radius of the cylinder
        System.out.print("Enter the radius of the cylinder: ");
        double radius = sc.nextDouble();

        // Ask the user to enter the height of the cylinder
        System.out.print("Enter the height of the cylinder: ");
        double height = sc.nextDouble();

        // Calculate the volume of the cylinder
        // Volume = π * radius * radius * height
        double volume = Math.PI * radius * radius * height;

        // Display the calculated volume
        System.out.println("Volume of the cylinder is: " + volume);

        // Close the Scanner
        sc.close();

	}

}
