//Write a program to find the frequency of characters in a string using nested loops and display the result
package strings;
import java.util.Scanner;
public class FrequencyNestedLoops {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Call user-defined method
        String[] frequencyResult = findCharacterFrequency(text);

        // Display result
        System.out.println("\nCharacter Frequency:");
        System.out.println("--------------------");
        for (int i = 0; i < frequencyResult.length; i++) {
            System.out.println(frequencyResult[i]);
        }

        sc.close();

	}
	// Method to find character frequency using nested loops
    // Returns a 1D String array in the format: "character : frequency"
    public static String[] findCharacterFrequency(String text) {

        // Convert string to character array
        char[] chars = text.toCharArray();

        // Frequency array to store count of each character
        int[] freq = new int[chars.length];

        // Step 1: Find frequency using nested loops
        for (int i = 0; i < chars.length; i++) {

            // Skip already processed characters
            if (chars[i] == '0') {
                continue;
            }

            freq[i] = 1; // Initialize frequency to 1

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;        // Increment frequency
                    chars[j] = '0';   // Mark duplicate as processed
                }
            }
        }

        // Step 2: Count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                uniqueCount++;
            }
        }

        // Step 3: Create 1D String array for result
        String[] result = new String[uniqueCount];
        int index = 0;

        // Step 4: Store character and frequency
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " : " + freq[i];
                index++;
            }
        }

        return result;
    }

}
