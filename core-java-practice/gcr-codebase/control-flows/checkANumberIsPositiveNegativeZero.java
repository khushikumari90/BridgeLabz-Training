//Write a program to check whether a number is positive, negative, or zero.
package controlflows;
import java.util.*;
public class checkANumberIsPositiveNegativeZero {

	public static void main(String[] args) {
	    // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Check the number
        if (number > 0) {
            System.out.println("positive");
        } 
        else if (number < 0) {
            System.out.println("negative");
        } 
        else {
            System.out.println("zero");
        }

        // Close scanner
        sc.close();

	}

}
