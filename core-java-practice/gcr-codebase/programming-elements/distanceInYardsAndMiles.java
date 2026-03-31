//Write a program to find the distance in yards and miles for the distance provided by the user in feet.
package programmingelements;
import java.util.*;
public class distanceInYardsAndMiles {

	public static void main(String[] args) {
		   // Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Take distance in feet from user
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = sc.nextDouble();

        // Conversion formulas
        // 1 yard = 3 feet
        double distanceInYards = distanceInFeet / 3;

        // 1 mile = 1760 yards
        double distanceInMiles = distanceInYards / 1760;

        // Display the result
        System.out.println("The distance in yards is " + distanceInYards + " while the distance in miles is " + distanceInMiles);

        // Close the scanner
        sc.close();

	}

}
