//Write a program to find and return the length of a string without using the length() method 
package strings;
import java.util.Scanner;
public class LengthOfString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String text = sc.next();

        // Find length using user-defined method
        int manualLength = findLengthUsingCharAt(text);

        // Find length using built-in length() method
        int builtInLength = text.length();

        // Display results
        System.out.println("\nLength without using length(): " + manualLength);
        System.out.println("Length using length(): " + builtInLength);

        sc.close();

	}

    // Method to find length of string WITHOUT using length()
    public static int findLengthUsingCharAt(String text) {

        int count = 0;

        try {
            // Infinite loop to access characters
            while (true) {
                text.charAt(count); // Will throw exception when index is out of range
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception occurs when index exceeds string length
            return count;
        }
    }


}
