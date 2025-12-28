//Write a program to trim the leading and trailing spaces from a string using the charAt() method 
package strings;
import java.util.Scanner;
public class TrimSpaces {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);

	        // Take user input
	        System.out.print("Enter a string with leading and trailing spaces: ");
	        String input = sc.nextLine();

	        // Find trim indexes
	        int[] indexes = findTrimIndexes(input);

	        // Create trimmed string using charAt()
	        String trimmedUsingCharAt = createSubstring(input, indexes[0], indexes[1]);

	        // Trim using built-in method
	        String trimmedUsingBuiltIn = input.trim();

	        // Compare both strings
	        boolean isSame = compareStrings(trimmedUsingCharAt, trimmedUsingBuiltIn);

	        // Display results
	        System.out.println("\nTrimmed String (Using charAt): '" + trimmedUsingCharAt + "'");
	        System.out.println("Trimmed String (Using trim()): '" + trimmedUsingBuiltIn + "'");
	        System.out.println("Are both strings equal? " + isSame);

	        sc.close();

	}

	 // Method to find start and end index without leading/trailing spaces
    public static int[] findTrimIndexes(String text) {

        int start = 0;
        int end = text.length() - 1;

        // Trim leading spaces
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    // Method to create substring using charAt()
    public static String createSubstring(String text, int start, int end) {

        String result = "";

        for (int i = start; i <= end; i++) {
            result = result + text.charAt(i);
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }
	
}
