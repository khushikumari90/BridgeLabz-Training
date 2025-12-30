//Basic Calculator
package BuiltInFunction;
import java.util.Scanner;
public class BasicCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide");
        System.out.print("Choose operation: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> System.out.println("Result: " + add(x, y));
            case 2 -> System.out.println("Result: " + subtract(x, y));
            case 3 -> System.out.println("Result: " + multiply(x, y));
            case 4 -> System.out.println("Result: " + divide(x, y));
            default -> System.out.println("Invalid Choice");
        }
        sc.close();
	}
    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }

    static double divide(int a, int b) {
        return (double) a / b;
    }
}
