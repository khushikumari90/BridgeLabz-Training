//Write a program for Euclidean distance between two points as well as the equation of the line using those two points. Use Math functions Math.pow() and Math.sqrt()
package methods;
import java.util.Scanner;
public class Euclidean {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        // Taking input for first point
	        System.out.print("Enter x1 y1: ");
	        double x1 = sc.nextDouble();
	        double y1 = sc.nextDouble();

	        // Taking input for second point
	        System.out.print("Enter x2 y2: ");
	        double x2 = sc.nextDouble();
	        double y2 = sc.nextDouble();

	        // Calculate distance
	        double distance = calculateDistance(x1, y1, x2, y2);
	        System.out.printf("Euclidean Distance = %.2f\n", distance);

	        // Find equation of line
	        double[] line = findLineEquation(x1, y1, x2, y2);
	        System.out.printf("Equation of line: y = %.2fx + %.2f\n",
	                line[0], line[1]);

	        sc.close();
	}
	// Method to calculate Euclidean distance
    public static double calculateDistance(double x1, double y1,
                                             double x2, double y2) {

        double distance = Math.sqrt(
                Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)
        );
        return distance;
    }

    // Method to calculate slope and y-intercept
    // Returns array: [0] = slope (m), [1] = y-intercept (b)
    public static double[] findLineEquation(double x1, double y1,
                                            double x2, double y2) {

        double m = (y2 - y1) / (x2 - x1);   // slope
        double b = y1 - m * x1;            // y-intercept

        return new double[]{m, b};
    }
}
