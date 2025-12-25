//Create a program to find the youngest friends among 3 Amar, Akbar, and Anthony based on their ages and the tallest among the friends based on their heights
package arrays;
import java.util.Scanner;
public class YoungestFriend {

	public static void main(String[] args) {
		
		// Scanner class is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Array to store names of friends
        String[] names = {"Amar", "Akbar", "Anthony"};

        // Arrays to store ages and heights of the friends
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Take user input for age and height of each friend
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for " + names[i]);

            System.out.print("Enter age: ");
            ages[i] = sc.nextInt();

            System.out.print("Enter height (in cm): ");
            heights[i] = sc.nextDouble();
        }

        int youngestIndex = 0;
        int tallestIndex = 0;

        // Loop through the arrays to find youngest and tallest friend
        for (int i = 1; i < 3; i++) {

            // Check for youngest friend
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }

            // Check for tallest friend
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Display the results
        System.out.println("\n===== Result =====");
        System.out.println("Youngest Friend : " + names[youngestIndex] +
                           " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest Friend  : " + names[tallestIndex] +
                           " (Height: " + heights[tallestIndex] + " cm)");

        // Close the scanner
        sc.close();

	}

}
