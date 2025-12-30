//Write a program to find the sum of n natural numbers using loop
package methods;
import java.util.Scanner;
public class SumOfNaturalNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Ask user for input
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            // Call the method and store the result
            int sum = sumOfNumbers(n);

            // Display the sum
            System.out.println("The sum of first " + n + " natural numbers is: " + sum);
        }

        sc.close();

	}
	 // Method to find the sum of first n natural numbers using a loop
    public static int sumOfNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i; // Add each number to sum
        }
        return sum;
    }

}
