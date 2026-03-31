//An athlete runs in a triangular park with sides provided as input by the user in meters. If the athlete wants to complete a 5 km run, then how many rounds must the athlete complete
package methods;
import java.util.Scanner;
public class TriangularPark {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        // Taking input for sides of the triangular park
        System.out.print("Enter side 1 (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter side 2 (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter side 3 (in meters): ");
        double side3 = scanner.nextDouble();

        // Calling method
        double rounds = calculateRounds(side1, side2, side3);

        // Display result
        System.out.println("The athlete needs to complete "
                + rounds + " rounds to complete a 5 km run.");

        scanner.close();

	}

    // Method to calculate number of rounds
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;   // perimeter of triangle
        double totalDistance = 5000;                 // 5 km = 5000 meters
        return totalDistance / perimeter;
    }

}
