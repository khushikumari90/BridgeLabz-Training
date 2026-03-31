//Write a program to find the first non-repeating character in a string and show the result
package strings;
import java.util.Scanner;
public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Call user-defined method
        char result = findFirstNonRepeatingChar(text);

        // Display result
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        sc.close();
        
	}
	// Method to find the first non-repeating character using charAt()
    public static char findFirstNonRepeatingChar(String text) {

        // Frequency array for all ASCII characters (0–255)
        int[] freq = new int[256];

        // Step 1: Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;   // ASCII value of char used as index
        }

        // Step 2: Find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;   // First non-repeating character found
            }
        }

        // If no non-repeating character exists
        return '\0';
    }

}
