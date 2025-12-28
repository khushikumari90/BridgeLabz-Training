//Write a program to check if two texts are anagrams and display the result
package strings;
import java.util.Scanner;
public class Anagrams {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter first text: ");
	        String text1 = sc.nextLine();

	        System.out.print("Enter second text: ");
	        String text2 = sc.nextLine();

	        // Call user-defined method
	        boolean result = isAnagram(text1, text2);

	        // Display result
	        if (result) {
	            System.out.println("\nThe given texts are ANAGRAMS.");
	        } else {
	            System.out.println("\nThe given texts are NOT ANAGRAMS.");
	        }

	        sc.close();

	}
	// Method to check whether two texts are anagrams
    public static boolean isAnagram(String text1, String text2) {

        // Step 1: Check length equality
        if (text1.length() != text2.length()) {
            return false;
        }

        // Step 2: Frequency arrays for ASCII characters
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        // Step 3: Find frequency of characters in both texts
        for (int i = 0; i < text1.length(); i++) {
            char ch1 = text1.charAt(i);
            char ch2 = text2.charAt(i);

            freq1[ch1]++;
            freq2[ch2]++;
        }

        // Step 4: Compare frequencies
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;   // Frequencies do not match
            }
        }

        return true;    // Anagram
    }

}
