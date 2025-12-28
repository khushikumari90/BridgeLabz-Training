//Write a program to find the frequency of characters in a string using unique characters and display the result
package strings;
import java.util.Scanner;
public class FrequencyUniqueCharacters {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a string: ");
	        String text = sc.nextLine();

	        // Call user-defined method
	        String[][] frequencyResult = findFrequencyUsingUnique(text);

	        // Display result
	        System.out.println("\nCharacter Frequency (Using Unique Characters)");

	        for (int i = 0; i < frequencyResult.length; i++) {
	            System.out.printf("%-10s %-10s%n",
	                    frequencyResult[i][0],
	                    frequencyResult[i][1]);
	        }

	        sc.close();
		
	}
	// Method to find unique characters using charAt() and nested loops
    public static char[] findUniqueCharacters(String text) {

        int length = text.length();

        // Temporary array to store unique characters
        char[] temp = new char[length];
        int uniqueCount = 0;

        // Outer loop to pick each character
        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;

            // Inner loop to compare with previous characters
            for (int j = 0; j < i; j++) {
                if (currentChar == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            // Store unique character
            if (isUnique) {
                temp[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        // Create exact-sized array for unique characters
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = temp[i];
        }

        return uniqueChars;
    }

    // Method to find frequency using unique characters
    // Returns 2D array -> [Character, Frequency]
    public static String[][] findFrequencyUsingUnique(String text) {

        // Step 1: Frequency array for ASCII characters
        int[] freq = new int[256];

        // Step 2: Count frequency of characters
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Step 3: Get unique characters
        char[] uniqueChars = findUniqueCharacters(text);

        // Step 4: Create 2D array for result
        String[][] result = new String[uniqueChars.length][2];

        // Step 5: Store character and its frequency
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }

        return result;
    }


}
