//Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
package methods;
import java.util.Scanner;
public class NumberChecker5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("\nNumber Analysis Results:");
        System.out.println("Perfect Number  : " + isPerfect(number));
        System.out.println("Abundant Number : " + isAbundant(number));
        System.out.println("Deficient Number: " + isDeficient(number));
        System.out.println("Strong Number   : " + isStrong(number));

        sc.close();

	}
	 // Method to find sum of proper divisors
    public static int sumOfProperDivisors(int num) {
        int sum = 0;

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // Method to check Perfect Number
    public static boolean isPerfect(int num) {
        return sumOfProperDivisors(num) == num;
    }

    // Method to check Abundant Number
    public static boolean isAbundant(int num) {
        return sumOfProperDivisors(num) > num;
    }

    // Method to check Deficient Number
    public static boolean isDeficient(int num) {
        return sumOfProperDivisors(num) < num;
    }

    // Method to calculate factorial of a digit
    public static int factorial(int digit) {
        int fact = 1;
        for (int i = 1; i <= digit; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to check Strong Number
    public static boolean isStrong(int num) {
        int temp = num;
        int sum = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == num;
    }

}
