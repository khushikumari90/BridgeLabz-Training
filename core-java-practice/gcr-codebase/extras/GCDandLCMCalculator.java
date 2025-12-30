//GCD and LCM Calculator
package BuiltInFunction;
import java.util.Scanner;
public class GCDandLCMCalculator {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println("GCD: " + gcd(x, y));
        System.out.println("LCM: " + lcm(x, y));
        sc.close();
	}
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
