//Write a program to find the age of Harry if the birth year is 2000. Assume the Current Year is 2024.
package programmingelements;

public class ageOfHarry {

	public static void main(String[] args) {
		 // Declare and initialize birth year
        int birthYear = 2000;

        // Declare and initialize current year
        int currentYear = 2024;

        // Calculate age
        int age = currentYear - birthYear;

        // Display the result
        System.out.println("Harry's age in 2024 is " + age);
	}

}
