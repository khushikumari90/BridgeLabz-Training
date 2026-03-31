//Similarly, write the DoubleOpt program by taking double values and doing the same operations
package programmingelements;
import java.util.*;
public class doubleOpt {

	public static void main(String[] args) {
		  // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Take double input values
        System.out.print("Enter value of a: ");
        double a = sc.nextDouble();

        System.out.print("Enter value of b: ");
        double b = sc.nextDouble();

        System.out.print("Enter value of c: ");
        double c = sc.nextDouble();

        // Perform double operations
        double result1 = a + b * c;   // Multiplication first
        double result2 = a * b + c;   // Multiplication first
        double result3 = c + a / b;   // Division first
        double result4 = a % b + c;   // Modulus first

        // Print results
        System.out.println("The results of Double Operations are " + result1 + ", " + result2 + ", " + result3 + ", " + result4);

        // Close scanner
        sc.close();

	}

}
