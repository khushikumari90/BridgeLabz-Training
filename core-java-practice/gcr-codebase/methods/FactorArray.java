//Write a program to find the factors of a number and perform various tasks using the factors array
package methods;
import java.util.Scanner;
public class FactorArray {

	public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a number: ");
	        int number = sc.nextInt();

	        int[] factors = findFactors(number);

	        System.out.println("\nFactors of " + number + ":");
	        for (int f : factors) {
	            System.out.print(f + " ");
	        }

	        System.out.println("\n\nResults:");
	        System.out.println("Greatest Factor            : " + greatestFactor(factors));
	        System.out.println("Sum of Factors             : " + sumOfFactors(factors));
	        System.out.println("Product of Factors         : " + productOfFactors(factors));
	        System.out.println("Product of Cube of Factors : " + productOfCubeOfFactors(factors));

	        sc.close();
	}
	// Method to find factors of a number and return as array
    public static int[] findFactors(int num) {

        // First loop: count factors
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }

        // Create array of required size
        int[] factors = new int[count];

        // Second loop: store factors
        int index = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    // Method to find greatest factor
    public static int greatestFactor(int[] factors) {
        int max = factors[0];
        for (int f : factors) {
            if (f > max) {
                max = f;
            }
        }
        return max;
    }

    // Method to find sum of factors
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) {
            sum += f;
        }
        return sum;
    }

    // Method to find product of factors
    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors) {
            product *= f;
        }
        return product;
    }

    // Method to find product of cube of factors
    public static double productOfCubeOfFactors(int[] factors) {
        double product = 1;
        for (int f : factors) {
            product *= Math.pow(f, 3);
        }
        return product;
    }

}
