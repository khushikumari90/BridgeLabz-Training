//Create a program to find the youngest friends among 3 Amar, Akbar and Anthony based on their ages and tallest among the friends based on their heights and display it
package methods;
import java.util.Scanner;
public class YoungestFriend {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        // Friend names
        String[] names = {"Amar", "Akbar", "Anthony"};

        // Arrays to store ages and heights
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Taking user input
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();

            System.out.print("Enter height of " + names[i] + " (in cm): ");
            heights[i] = sc.nextDouble();
        }

        // Finding youngest and tallest
        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);

        // Displaying result
        System.out.println("\nYoungest Friend: " + names[youngestIndex] +
                " (Age: " + ages[youngestIndex] + ")");

        System.out.println("Tallest Friend: " + names[tallestIndex] +
                " (Height: " + heights[tallestIndex] + " cm)");

        sc.close();

	}
	// Method to find the youngest friend
    public static int findYoungest(int[] ages) {
        int youngestIndex = 0;

        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }

    // Method to find the tallest friend
    public static int findTallest(double[] heights) {
        int tallestIndex = 0;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }

}
