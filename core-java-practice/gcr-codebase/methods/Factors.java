//Create a program to find the factors of a number taken as user input, store the factors in an array, and display the factors. Also find the sum, sum of square of factors and product of the factors and display the results
package methods;
import java.util.Scanner;
public class Factors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Get factors array
        int[] factors = findFactors(number);

        // Display factors
        System.out.println("\nFactors of " + number + ":");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }

        // Calculate and display results
        System.out.println("\n\nSum of factors: " + sumOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
        System.out.println("Sum of squares of factors: " + sumOfSquaresOfFactors(factors));

        sc.close();
	}
    /**
     * Method to find factors of a number and return them in an array
     */
    public static int[] findFactors(int number) {

        int count = 0;

        // First loop: count number of factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Initialize array with factor count
        int[] factors = new int[count];
        int index = 0;

        // Second loop: store factors in array
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    /**
     * Method to calculate sum of factors
     */
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    /**
     * Method to calculate product of factors
     */
    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    /**
     * Method to calculate sum of squares of factors
     */
    public static double sumOfSquaresOfFactors(int[] factors) {
        double sum = 0;
        for (int factor : factors) {
            sum += Math.pow(factor, 2);
        }
        return sum;
    }
}



