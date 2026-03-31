//Write a program to take user input for the age of all 10 students in a class and check whether the student can vote depending on his/her age is greater or equal to 18.
package arrays;
import java.util.Scanner;
public class Age {

	public static void main(String[] args) {
		
		// Create Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // Define an array of 10 integer elements to store ages
        int[] ages = new int[10];

        // Take input for ages of 10 students
        System.out.println("Enter the age of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            ages[i] = sc.nextInt();
        }

        System.out.println("\nVoting Eligibility Results:");

        // Loop through the array to check voting eligibility
        for (int i = 0; i < ages.length; i++) {

            // Check for invalid (negative) age
            if (ages[i] < 0) {
                System.out.println("Invalid age: " + ages[i]);
            }
            // Check if student can vote
            else if (ages[i] >= 18) {
                System.out.println("The student with the age " + ages[i] + " can vote.");
            }
            // If age is less than 18
            else {
                System.out.println("The student with the age " + ages[i] + " cannot vote.");
            }
        }

        // Close the scanner
        sc.close();

	}

}
