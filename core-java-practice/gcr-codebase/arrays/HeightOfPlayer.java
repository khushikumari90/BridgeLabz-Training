//Create a program to find the mean height of players present in a football team.
package arrays;
import java.util.Scanner;
public class HeightOfPlayer {

	public static void main(String[] args) {
		
        // Create Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Create a double array to store heights of 11 players
        double[] heights = new double[11];

        // Variable to store the sum of heights
        double sum = 0.0;

        // Get height input for each player
        System.out.println("Enter the heights of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            heights[i] = sc.nextDouble();
        }

        // Calculate the sum of all heights
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }

        // Calculate mean height
        double mean = sum / heights.length;

        // Display the mean height
        System.out.println("\nMean height of the football team = " + mean);

        // Close the scanner
        sc.close();

	}

}
