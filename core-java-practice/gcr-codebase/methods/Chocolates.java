//Create a program to divide N number of chocolates among M children. Print the number of chocolates each child will get and also the remaining chocolates
package methods;
import java.util.Scanner;
public class Chocolates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Take input for number of chocolates and number of children
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = sc.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = sc.nextInt();

        if (numberOfChildren <= 0) {
            System.out.println("Error: Number of children must be greater than zero.");
        } else {
            // Call the method
            int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

            // Display the result
            System.out.println("Each child gets: " + result[0] + " chocolates");
            System.out.println("Remaining chocolates: " + result[1]);
        }

        sc.close();
	}
    // Method to find chocolates per child (quotient) and remaining chocolates (remainder)
    // Returns an array: index 0 = chocolates per child, index 1 = remaining chocolates
    public static int[] findRemainderAndQuotient(int numberOfChocolates, int numberOfChildren) {
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;   // Quotient
        int remainingChocolates = numberOfChocolates % numberOfChildren;  // Remainder
        return new int[] {chocolatesPerChild, remainingChocolates};
    }
}
