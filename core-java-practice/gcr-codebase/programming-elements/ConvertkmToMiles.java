//Write a program that takes the distance in kilometers as input from the user and converts it into miles.
package programmingelements;
import java.util.*;
public class ConvertkmToMiles {

	public static void main(String[] args) {
		
		   // Create Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter distance in kilometers
        System.out.print("Enter distance in kilometers: ");
        double kilometers = sc.nextDouble();

        // Convert kilometers to miles using the given formula
        // miles = kilometers * 0.621371
        double miles = kilometers * 0.621371;

        // Display the converted distance in miles
        System.out.println("Distance in miles is: " + miles);

        // Close the Scanner
        sc.close();

	}

}
