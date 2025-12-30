package oop;

public class PalindromeChecker {
	// Attribute
    String text;

    // Method to check palindrome
    boolean isPalindrome() {
        String cleanedText = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String reverse = "";

        for (int i = cleanedText.length() - 1; i >= 0; i--) {
            reverse = reverse + cleanedText.charAt(i);
        }

        return cleanedText.equals(reverse);
    }

    // Method to display result
    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }

    public static void main(String[] args) {
        // First text
        PalindromeChecker p1 = new PalindromeChecker();
        p1.text = "A man a plan a canal Panama";
        p1.displayResult();

        // Second text
        PalindromeChecker p2 = new PalindromeChecker();
        p2.text = "Hello";
        p2.displayResult();
    }

}
