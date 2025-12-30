package extrascenariobased;
import java.util.Scanner;

public class LineComparisonProblem {

    // Method to calculate length of a line
    public static double calculateLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Line Comparison Computation Program");

        // UC1: Calculate length of two lines
        System.out.println("\n--- Enter coordinates for Line 1 ---");
        System.out.print("Enter x1, y1, x2, y2: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double length1 = calculateLength(x1, y1, x2, y2);
        System.out.println("Length of Line 1: " + length1);

        System.out.println("\n--- Enter coordinates for Line 2 ---");
        System.out.print("Enter x1, y1, x2, y2: ");
        double a1 = sc.nextDouble();
        double b1 = sc.nextDouble();
        double a2 = sc.nextDouble();
        double b2 = sc.nextDouble();
        double length2 = calculateLength(a1, b1, a2, b2);
        System.out.println("Length of Line 2: " + length2);

        // UC2: Check equality of two lines
        if (Double.valueOf(length1).equals(Double.valueOf(length2))) {
            System.out.println("\nBoth lines are equal in length.");
        } else {
            System.out.println("\nLines are not equal in length.");
        }

        // UC3: Compare two lines
        int comparison = Double.valueOf(length1).compareTo(Double.valueOf(length2));
        if (comparison == 0) {
            System.out.println("Both lines are equal in length.");
        } else if (comparison > 0) {
            System.out.println("Line 1 is longer than Line 2.");
        } else {
            System.out.println("Line 1 is shorter than Line 2.");
        }

        sc.close();
        System.out.println("\nThank You!");
    }
}