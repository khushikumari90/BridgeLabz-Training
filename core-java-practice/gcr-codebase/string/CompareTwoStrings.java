//Write a program to compare two strings using the charAt() method and check the result with the built-in String equals() method
package strings;
import java.util.Scanner;
public class CompareTwoStrings {

	public static void main(String[] args) {
		
		 // Scanner class for user input
        Scanner sc = new Scanner(System.in);

        // Take input for first string
        System.out.print("Enter first string: ");
        String str1 = sc.next();

        // Take input for second string
        System.out.print("Enter second string: ");
        String str2 = sc.next();

        // Compare strings using charAt() method
        boolean charAtResult = compareUsingCharAt(str1, str2);

        // Compare strings using built-in equals() method
        boolean equalsResult = str1.equals(str2);

        // Display results
        System.out.println("Result using charAt() method: " + charAtResult);
        System.out.println("Result using equals() method: " + equalsResult);

        // Check if both results are same
        if (charAtResult == equalsResult) {
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println("Both methods give different results.");
        }

        // Close scanner
        sc.close();

	}
	
	 // Method to compare two strings using charAt()
    public static boolean compareUsingCharAt(String s1, String s2) {

        // If lengths are different, strings cannot be equal
        if (s1.length() != s2.length()) {
            return false;
        }

        // Compare each character of both strings
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false; // characters do not match
            }
        }

        // All characters matched
        return true;
    }
}
