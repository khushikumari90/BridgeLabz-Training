//Factorial Using Recursion
package BuiltInFunction;
import java.util.Scanner;
public class FactorialUsingRecursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("Factorial: " + factorial(number));
        sc.close();
	}
    static long factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
