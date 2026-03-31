//Write a program to check if a number is divisible by 5
package controlflows;
import java.util.*;
public class divisbleByFive {

	public static void main(String[] args) {
	     // Create Scanner object to take input
        Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Check divisibility by 5
        boolean result = (number % 5 == 0);

        // Print output
        System.out.println("Is the number " + number + " divisible by 5? " + result);

        // Close scanner
        sc.close();

	}

}
