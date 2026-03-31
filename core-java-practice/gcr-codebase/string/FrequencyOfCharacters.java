//Write a program to find the frequency of characters in a string using the charAt() method and display the result
package strings;
import java.util.Scanner;
public class FrequencyOfCharacters {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Call user-defined method
        String[][] frequencyResult = findCharacterFrequency(text);

        // Display result
        System.out.println("\nCharacter Frequency:");
        System.out.println("---------------------");
        

        for (int i = 0; i < frequencyResult.length; i++) {
            System.out.printf("%-10s %-10s%n",
                    frequencyResult[i][0],
                    frequencyResult[i][1]);
        }

        sc.close();

	}
	// Method to find frequency of characters using charAt()
    // Returns a 2D array where:
    // Column 0 -> Character
    // Column 1 -> Frequency
    public static String[][] findCharacterFrequency(String text) {

        // Step 1: Frequency array for ASCII characters
        int[] freq = new int[256];

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;   // ASCII value used as index
        }

        // Step 2: Count number of unique characters
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                uniqueCount++;
            }
        }

        // Step 3: Create 2D array to store character and frequency
        String[][] result = new String[uniqueCount][2];
        int index = 0;

        // Step 4: Store characters and their frequencies
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Store only first occurrence
            if (freq[ch] != -1) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                index++;

                // Mark as processed
                freq[ch] = -1;
            }
        }

        return result;
    }



}
