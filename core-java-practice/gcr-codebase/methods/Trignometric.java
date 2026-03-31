//Write a program to calculate various trigonometric functions using Math class given an angle in degrees
package methods;
import java.util.Scanner;
public class Trignometric {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Take input for the angle in degrees
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();

        // Call the method
        double[] trigValues = calculateTrigonometricFunctions(angle);

        // Display the results without formatting
        System.out.println("Sine of " + angle + " degrees = " + trigValues[0]);
        System.out.println("Cosine of " + angle + " degrees = " + trigValues[1]);
        System.out.println("Tangent of " + angle + " degrees = " + trigValues[2]);

        sc.close();

	}
    // Method to calculate sine, cosine, and tangent of an angle in degrees
    // Returns an array: index 0 = sine, index 1 = cosine, index 2 = tangent
    public static double[] calculateTrigonometricFunctions(double angleInDegrees) {
        // Convert angle from degrees to radians
        double angleInRadians = Math.toRadians(angleInDegrees);

        // Calculate trigonometric functions
        double sine = Math.sin(angleInRadians);
        double cosine = Math.cos(angleInRadians);
        double tangent = Math.tan(angleInRadians);

        return new double[] {sine, cosine, tangent};
    }
}
