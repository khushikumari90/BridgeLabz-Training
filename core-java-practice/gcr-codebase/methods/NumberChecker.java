//Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
package methods;
import java.util.Scanner;
public class NumberChecker {

	public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a number: ");
	        int number = sc.nextInt();

	        int digitCount = countDigits(number);
	        int[] digits = storeDigits(number);

	        System.out.println("\nDigits in the number:");
	        for (int d : digits) {
	            System.out.print(d + " ");
	        }

	        System.out.println("\n\nCount of digits = " + digitCount);
	        System.out.println("Is Duck Number = " + isDuckNumber(digits));
	        System.out.println("Is Armstrong Number = " + isArmstrongNumber(number, digits));

	        int[] maxValues = findLargestAndSecondLargest(digits);
	        System.out.println("Largest Digit = " + maxValues[0]);
	        System.out.println("Second Largest Digit = " + maxValues[1]);

	        int[] minValues = findSmallestAndSecondSmallest(digits);
	        System.out.println("Smallest Digit = " + minValues[0]);
	        System.out.println("Second Smallest Digit = " + minValues[1]);

	        sc.close();

	}
	// Method to find count of digits in a number
    public static int countDigits(int number) {
        int count = 0;
        int temp = number;

        while (temp != 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    // Method to store digits of the number in an array
    public static int[] storeDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];

        int temp = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    // Method to check if the number is a Duck number
    // Duck number: contains at least one non-zero digit
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) {
                return true;
            }
        }
        return false;
    }

    // Method to check if the number is an Armstrong number
    public static boolean isArmstrongNumber(int number, int[] digits) {
        int power = digits.length;
        int sum = 0;

        for (int d : digits) {
            sum += Math.pow(d, power);
        }
        return sum == number;
    }

    // Method to find largest and second largest digit
    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }
        return new int[]{largest, secondLargest};
    }

    // Method to find smallest and second smallest digit
    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }
        return new int[]{smallest, secondSmallest};
    }



}
