//Write a program that takes a year as input and outputs the Year is a Leap Year or not
package methods;
import java.util.Scanner;
public class LeapYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Take year input from user
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        // Check if year is valid for Gregorian calendar
        if (year < 1582) {
            System.out.println("Leap Year calculation is valid only for year >= 1582.");
        } else {
            // Check leap year
            if (isLeapYear(year)) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is NOT a Leap Year.");
            }
        }

        sc.close();
	}
	/**
     * Method to check whether a year is a leap year
     * Condition:
     * (Divisible by 4 AND not divisible by 100) OR divisible by 400
     */
    public static boolean isLeapYear(int year) {

        // Condition (a): divisible by 4 and not divisible by 100
        boolean conditionA = (year % 4 == 0) && (year % 100 != 0);

        // Condition (b): divisible by 400
        boolean conditionB = (year % 400 == 0);

        return conditionA || conditionB;
    }
}
