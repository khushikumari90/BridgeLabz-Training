//Write a program to convert the complete text to lowercase and compare the results
package strings;
import java.util.Scanner;
public class TextToLowerCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        // Take complete text input
        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        // Convert using user-defined method
        String manualLower = toLowerCaseUsingCharAt(text);

        // Convert using built-in toLowerCase() method
        String builtInLower = text.toLowerCase();

        // Compare both strings
        boolean result = compareStringsUsingCharAt(manualLower, builtInLower);

        // Display results
        System.out.println("\nLowercase using charAt(): " + manualLower);
        System.out.println("Lowercase using toLowerCase(): " + builtInLower);
        System.out.println("Are both results equal? " + result);

        sc.close();

	}
	
	 // Method to convert string to lowercase using charAt() and ASCII logic
    public static String toLowerCaseUsingCharAt(String text) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            // Check if character is uppercase (A–Z)
            if (ch >= 'A' && ch <= 'Z') {
                // Convert to lowercase using ASCII difference (32)
                ch = (char) (ch + 32);
            }

            result = result + ch;
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStringsUsingCharAt(String s1, String s2) {

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
