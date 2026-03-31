//Maximum of Three Numbers
package BuiltInFunction;
import java.util.Scanner;
public class MaximumOfThreeNumbers {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println("Maximum number is: " + getMax(a, b, c));
        sc.close();
	}
    static int getMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

}
