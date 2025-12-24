//Write a LeapYear program that takes a year as input and outputs the Year is a Leap Year or not a Leap Year. 
package controlflows;
import java.util.*;
public class leapYear {

	public static void main(String[] args) {
		
	    // Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a year
        System.out.print("Enter a year (>=1582): ");
        int year = scanner.nextInt();

        // Check if the year is before 1582 (invalid for Gregorian calendar)
        if (year < 1582) {
            System.out.println("Please enter a year >= 1582.");
        } else {
            // Check if the year is NOT divisible by 4
            if (year % 4 != 0) {
                System.out.println(year + " is not a Leap Year.");
            } else {
                // Year is divisible by 4, now check if it is NOT divisible by 100
                if (year % 100 != 0) {
                    System.out.println(year + " is a Leap Year.");
                } else {
                    // Year is divisible by 100, now check if it is divisible by 400
                    if (year % 400 == 0) {
                        System.out.println(year + " is a Leap Year.");
                    } else {
                        System.out.println(year + " is not a Leap Year.");
                    }
                }
            }
        }    
        //Close the scanner
        scanner.close();

	}

}
