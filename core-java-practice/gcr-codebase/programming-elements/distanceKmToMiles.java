//Create a program to convert distance in kilometers to miles.
package programmingelements;
import java.util.*;
public class distanceKmToMiles {

	public static void main(String[] args) {
		  // Declare variable for kilometers
        double km;

        // Create Scanner object to take input from keyboard
        Scanner input = new Scanner(System.in);

        // Take kilometer input from user
        System.out.print("Enter distance in kilometers: ");
        km = input.nextDouble();

        // Convert kilometers to miles
        // 1 mile = 1.6 km
        double miles = km / 1.6;

        // Print the result
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");

        // Close scanner
        input.close();
          
	}

}
