//Write a program to take 2 numbers and print their quotient and reminder
package methods;
import java.util.Scanner;
public class RemainderAndQuotient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Take input for two numbers
        System.out.print("Enter the number (dividend): ");
        int number = sc.nextInt();
        System.out.print("Enter the divisor: ");
        int divisor = sc.nextInt();

        if (divisor == 0) {
            System.out.println("Error: Division by zero is not allowed.");
        } else {
            // Call the method
            int[] result = findRemainderAndQuotient(number, divisor);

            // Display the result
            System.out.println("Quotient: " + result[0]);
            System.out.println("Remainder: " + result[1]);
        }

        sc.close();
	}
	// Method to find quotient and remainder
    // Returns an array where index 0 = quotient, index 1 = remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;   // Division operator
        int remainder = number % divisor;  // Modulus operator
        return new int[] {quotient, remainder};
    }
}
