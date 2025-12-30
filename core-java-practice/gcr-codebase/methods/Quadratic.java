//Write a program Quadratic to find the roots of the equation ax2+ bx + c. Use Math functions Math.pow() and Math.sqrt()
package methods;
import java.util.Scanner;
public class Quadratic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Taking input values
        System.out.print("Enter value of a: ");
        double a = sc.nextDouble();

        System.out.print("Enter value of b: ");
        double b = sc.nextDouble();

        System.out.print("Enter value of c: ");
        double c = sc.nextDouble();

        // Calling method
        double[] roots = findRoots(a, b, c);

        // Displaying result
        if (roots.length == 2) {
            System.out.println("Two roots of the equation are:");
            System.out.println("Root 1 = " + roots[0]);
            System.out.println("Root 2 = " + roots[1]);
        } 
        else if (roots.length == 1) {
            System.out.println("Only one root of the equation:");
            System.out.println("Root = " + roots[0]);
        } 
        else {
            System.out.println("No real roots exist (delta is negative).");
        }

        sc.close();

	}
	// Method to calculate roots of quadratic equation
    public static double[] findRoots(double a, double b, double c) {

        // Calculate discriminant (delta)
        double delta = Math.pow(b, 2) - 4 * a * c;

        // If delta is positive, return two roots
        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        }

        // If delta is zero, return one root
        else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        }

        // If delta is negative, return empty array
        else {
            return new double[]{};
        }
    }


}
