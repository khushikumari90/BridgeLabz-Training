//Create a program to take a number as input and reverse the number. To do this, store the digits of the number in an array and display the array in reverse order
package arrays;
import java.util.Scanner;
public class ReverseNumber {

	public static void main(String[] args) {

        // Scanner class is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int temp = number;

        // Count digits
        int count = 0;
        while (temp != 0) {
            count++;
            temp /= 10;
        }

        // Store digits in original order
        int[] digits = new int[count];
        temp = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        // Print digits in reverse order
        System.out.print("\nReversed Number: ");
        for (int i = count - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }

        // Close the scanner
        sc.close();

	}

}
