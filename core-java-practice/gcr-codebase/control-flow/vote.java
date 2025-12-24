//Write a program to check whether a person can vote, depending on whether his/her age is greater than or equal to 18.
package controlflows;
import java.util.*;
public class vote {

	public static void main(String[] args) {
		 // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Take age input from user
        System.out.print("Enter age: ");
        int age = sc.nextInt();

        // Check if the person can vote
        if (age >= 18) {

            // Person is eligible to vote
            System.out.println("The person's age is " + age + " and can vote.");

        } else {

            // Person is not eligible to vote
            System.out.println("The person's age is " + age + " and cannot vote.");
        }

        // Close scanner
        sc.close();

	}

}
