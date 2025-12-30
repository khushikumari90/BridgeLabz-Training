//Write a program to take user input for 5 numbers and check whether a number is positive or negative. Further for positive numbers check if the number is even or odd. Finally compare the first and last elements of the array and display if they are equal, greater, or less
package methods;
import java.util.Scanner;

public class CheckNumberPositive {

    // Method to check whether a number is positive
    public static boolean isPositive(int number) {
        return number >= 0;
    }

    // Method to check whether a number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Method to compare two numbers
     * @return 1 if num1 > num2, 0 if equal, -1 if num1 < num2
     */
    public static int compare(int num1, int num2) {
        if (num1 > num2) {
            return 1;
        } else if (num1 == num2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        // Taking input
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("\nNumber Analysis:");

        // Loop through array and analyze numbers
        for (int i = 0; i < numbers.length; i++) {

            if (isPositive(numbers[i])) {
                System.out.print(numbers[i] + " is Positive and ");

                if (isEven(numbers[i])) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            } else {
                System.out.println(numbers[i] + " is Negative");
            }
        }

        // Compare first and last elements
        int result = compare(numbers[0], numbers[numbers.length - 1]);

        System.out.println("\nComparison of First and Last Elements:");
        if (result == 1) {
            System.out.println("First element is greater than last element");
        } else if (result == 0) {
            System.out.println("First element is equal to last element");
        } else {
            System.out.println("First element is less than last element");
        }

        sc.close();
    }
}
