//Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
package methods;
import java.util.Scanner;
public class NumberChecker2 {

	public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a number: ");
	        int number = sc.nextInt();

	        int[] digits = storeDigits(number);

	        System.out.println("\nCount of digits: " + countDigits(number));
	        System.out.println("Sum of digits: " + sumOfDigits(digits));
	        System.out.println("Sum of squares of digits: " + sumOfSquares(digits));

	        if (isHarshadNumber(number, digits)) {
	            System.out.println(number + " is a Harshad Number");
	        } else {
	            System.out.println(number + " is NOT a Harshad Number");
	        }

	        System.out.println("\nDigit Frequency:");
	        System.out.println("------------------");

	        int[][] frequency = digitFrequency(digits);
	        for (int i = 0; i < frequency.length; i++) {
	            if (frequency[i][1] > 0) {
	                System.out.println("  " + frequency[i][0] + "   |    " + frequency[i][1]);
	            }
	        }

	        sc.close();

	}
    // Method to count digits in a number
    public static int countDigits(int number) {
        int count = 0;
        number = Math.abs(number);

        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    // Method to store digits of number into an array
    public static int[] storeDigits(int number) {
        number = Math.abs(number);
        int count = countDigits(number);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    // Method to find sum of digits using digits array
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    // Method to find sum of squares of digits
    public static double sumOfSquares(int[] digits) {
        double sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    // Method to check if number is Harshad number
    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    // Method to find frequency of each digit using 2D array
    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];

        // Initialize digits
        for (int i = 0; i < 10; i++) {
            freq[i][0] = i; // digit
            freq[i][1] = 0; // frequency
        }

        // Count frequency
        for (int d : digits) {
            freq[d][1]++;
        }
        return freq;
    }


}
