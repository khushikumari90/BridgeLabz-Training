//Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
package methods;
import java.util.Scanner;
public class NumberChecker4 {

	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a number: ");
	        int number = sc.nextInt();

	        System.out.println("\nNumber Analysis Results:");
	        System.out.println("Prime Number      : " + isPrime(number));
	        System.out.println("Neon Number       : " + isNeon(number));
	        System.out.println("Spy Number        : " + isSpy(number));
	        System.out.println("Automorphic Number: " + isAutomorphic(number));
	        System.out.println("Buzz Number       : " + isBuzz(number));

	        sc.close();
	}
	// Method to check if number is Prime
    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    // Method to check if number is Neon
    public static boolean isNeon(int num) {
        int square = num * num;
        int sum = 0;

        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == num;
    }

    // Method to check if number is Spy
    public static boolean isSpy(int num) {
        int sum = 0;
        int product = 1;
        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    // Method to check if number is Automorphic
    public static boolean isAutomorphic(int num) {
        int square = num * num;
        return String.valueOf(square).endsWith(String.valueOf(num));
    }

    // Method to check if number is Buzz
    public static boolean isBuzz(int num) {
        return (num % 7 == 0 || num % 10 == 7);
    }


}
