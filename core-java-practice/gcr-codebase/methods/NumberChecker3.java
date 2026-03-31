//Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
package methods;
import java.util.Scanner;
public class NumberChecker3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = storeDigits(number);
        int[] reversedDigits = reverseDigits(digits);

        System.out.println("\nCount of digits: " + countDigits(number));

        System.out.print("Digits Array: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }

        System.out.print("\nReversed Digits Array: ");
        for (int d : reversedDigits) {
            System.out.print(d + " ");
        }

        System.out.println("\nArrays are equal: " +
                compareArrays(digits, reversedDigits));

        if (isPalindrome(digits)) {
            System.out.println(number + " is a Palindrome Number");
        } else {
            System.out.println(number + " is NOT a Palindrome Number");
        }

        if (isDuckNumber(digits)) {
            System.out.println(number + " is a Duck Number");
        } else {
            System.out.println(number + " is NOT a Duck Number");
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

    // Method to store digits in an array
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

    // Method to reverse digits array
    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    // Method to compare two arrays
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    // Method to check palindrome number
    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseDigits(digits);
        return compareArrays(digits, reversed);
    }

    // Method to check Duck Number
    // Duck number contains at least one zero
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d == 0) {
                return false;
            }
        }
        return true;
    }

}
