//Rewrite program 1 to determine Leap Year with single if condition using logical and && and or || operators
package controlflows;
import java.util.*;
public class leapYearSingleIf {

	public static void main(String[] args) {
		
	    // Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a year
        System.out.print("Enter a year (>=1582): ");
        int year = scanner.nextInt();

        if (year >= 1582 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println(year + " is a Leap Year.");
        } 
        // Handle invalid year input
        else if (year < 1582) {
            System.out.println("Please enter a year >= 1582.");
        } 
        // Remaining years are not leap years
        else {
            System.out.println(year + " is not a Leap Year.");
        }
        
        //Close the scanner
        scanner.close();

	}

}
