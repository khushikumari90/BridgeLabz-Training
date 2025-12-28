//Write a program to to check if a text is palindrome and display the result
package strings;
import java.util.Scanner;
public class Palindrome {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a text: ");
	        String text = sc.nextLine();

	        // Logic 1 Result
	        boolean result1 = isPalindromeIterative(text);

	        // Logic 2 Result
	        boolean result2 = isPalindromeRecursive(text, 0, text.length() - 1);

	        // Logic 3 Result
	        boolean result3 = isPalindromeUsingArray(text);

	        // Display Results
	        System.out.println("\nPalindrome Check Results:");
	        System.out.println("--------------------------");
	        System.out.println("Logic 1 (Iterative): " + result1);
	        System.out.println("Logic 2 (Recursive): " + result2);
	        System.out.println("Logic 3 (Array):     " + result3);

	        sc.close();

	}
	
    // ---------------- LOGIC 1 ----------------
    // Method to check palindrome using start and end index (Iterative)
    public static boolean isPalindromeIterative(String text) {

        int start = 0;
        int end = text.length() - 1;

        // Compare characters from start and end
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;   // Characters mismatch
            }
            start++;
            end--;
        }
        return true;    // Palindrome
    }

    // ---------------- LOGIC 2 ----------------
    // Recursive method to check palindrome
    public static boolean isPalindromeRecursive(String text, int start, int end) {

        // Base condition: all characters checked
        if (start >= end) {
            return true;
        }

        // If characters do not match
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // ---------------- LOGIC 3 ----------------
    // Method to reverse string using charAt()
    public static char[] reverseString(String text) {

        int length = text.length();
        char[] reverse = new char[length];

        int index = 0;
        for (int i = length - 1; i >= 0; i--) {
            reverse[index] = text.charAt(i);
            index++;
        }

        return reverse;
    }

    // Method to check palindrome using character arrays
    public static boolean isPalindromeUsingArray(String text) {

        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        // Compare original and reverse arrays
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }


}
