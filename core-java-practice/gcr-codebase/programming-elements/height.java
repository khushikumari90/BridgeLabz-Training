//Write a program that takes your height in centimeters and converts it into feet and inches
package programmingelements;
import java.util.*;
public class height {

	public static void main(String[] args) {

        // Create Scanner object to take input from keyboard
        Scanner input = new Scanner(System.in);

        // Take height in centimeters from user
        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();

        // Convert centimeters to inches
        // 1 inch = 2.54 cm
        double totalInches = heightCm / 2.54;

        // Convert inches to feet
        // 1 foot = 12 inches
        int feet = (int) (totalInches / 12);

        // Remaining inches
        double inches = totalInches % 12;

        // Print the result
        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + feet + " and inches is " + inches);
        
        // Close scanner
        input.close();

	}

}
