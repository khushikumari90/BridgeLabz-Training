//Write a program to find the 3 points that are collinear using the slope formulae and area of triangle formulae. check  A (2, 4), B (4, 6) and C (6, 8) are Collinear for sampling. 
package methods;
import java.util.Scanner;
public class CollinearPoints {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Taking input for three points
        System.out.print("Enter x1 y1: ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        System.out.print("Enter x2 y2: ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        System.out.print("Enter x3 y3: ");
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        // Check using slope method
        if (isCollinearBySlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear using slope method.");
        } else {
            System.out.println("Points are NOT collinear using slope method.");
        }

        // Check using area method
        if (isCollinearByArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Points are collinear using area method.");
        } else {
            System.out.println("Points are NOT collinear using area method.");
        }

        sc.close();
	}
    // Method to check collinearity using slope formula
    public static boolean isCollinearBySlope(
            int x1, int y1, int x2, int y2, int x3, int y3) {

        // To avoid division, cross-multiply slopes
        return (y2 - y1) * (x3 - x2) ==
               (y3 - y2) * (x2 - x1);
    }

    // Method to check collinearity using area of triangle formula
    public static boolean isCollinearByArea(
            int x1, int y1, int x2, int y2, int x3, int y3) {

        double area = 0.5 * (x1 * (y2 - y3)
                           + x2 * (y3 - y1)
                           + x3 * (y1 - y2));

        return area == 0;
    }


}
