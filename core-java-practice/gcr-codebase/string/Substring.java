//Write a program to create a substring from a String using the charAt() method. Also, use the String built-in method substring() to find the substring of the text. Finally Compare the the two strings and display the results
package strings;
import java.util.Scanner;
public class Substring {

	public static void main(String[] args) {
		

        Scanner sc = new Scanner(System.in);

        // Take input string
        System.out.print("Enter the string: ");
        String text = sc.next();

        // Take start index
        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        // Take end index
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        // Create substring using charAt()
        String manualSubstring = substringUsingCharAt(text, start, end);

        // Create substring using built-in substring() method
        String builtInSubstring = text.substring(start, end);

        // Compare both substrings using charAt()
        boolean comparisonResult = compareStringsUsingCharAt(manualSubstring, builtInSubstring);

        // Display results
        System.out.println("\nSubstring using charAt(): " + manualSubstring);
        System.out.println("Substring using substring(): " + builtInSubstring);
        System.out.println("Are both substrings equal? " + comparisonResult);

        sc.close();

	}
	
	 // Method to create substring using charAt()
    public static String substringUsingCharAt(String text, int start, int end) {

        String result = "";

        // Loop from start index to end index - 1
        for (int i = start; i < end; i++) {
            result = result + text.charAt(i);
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStringsUsingCharAt(String s1, String s2) {

        // If lengths are different, strings are not equal
        if (s1.length() != s2.length()) {
            return false;
        }

        // Compare each character
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true; // All characters matched
    }

}
