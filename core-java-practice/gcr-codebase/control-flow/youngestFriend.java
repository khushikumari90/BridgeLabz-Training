//Create a program to find the youngest friends among 3 Amar, Akbar, and Anthony based on their ages and the tallest among the friends based on their heights
package controlflows;
import java.util.*;
public class youngestFriend {

	public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Input age and height for Amar
        System.out.print("Enter Amar's age: ");
        int amarAge = scanner.nextInt();
        System.out.print("Enter Amar's height (in cm): ");
        double amarHeight = scanner.nextDouble();

        // Input age and height for Akbar
        System.out.print("Enter Akbar's age: ");
        int akbarAge = scanner.nextInt();
        System.out.print("Enter Akbar's height (in cm): ");
        double akbarHeight = scanner.nextDouble();

        // Input age and height for Anthony
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = scanner.nextInt();
        System.out.print("Enter Anthony's height (in cm): ");
        double anthonyHeight = scanner.nextDouble();

        // Find the youngest friend
        int youngestAge = amarAge;
        String youngestFriend = "Amar";

        if (akbarAge < youngestAge) {
            youngestAge = akbarAge;
            youngestFriend = "Akbar";
        }
        if (anthonyAge < youngestAge) {
            youngestAge = anthonyAge;
            youngestFriend = "Anthony";
        }

        // Find the tallest friend
        double tallestHeight = amarHeight;
        String tallestFriend = "Amar";

        if (akbarHeight > tallestHeight) {
            tallestHeight = akbarHeight;
            tallestFriend = "Akbar";
        }
        if (anthonyHeight > tallestHeight) {
            tallestHeight = anthonyHeight;
            tallestFriend = "Anthony";
        }

        // Display the results
        System.out.println("\nYoungest Friend: " + youngestFriend + 
                           " (Age: " + youngestAge + ")");
        System.out.println("Tallest Friend: " + tallestFriend + 
                           " (Height: " + tallestHeight + " cm)");

        // Close the scanner
        scanner.close();
		

	}

}
