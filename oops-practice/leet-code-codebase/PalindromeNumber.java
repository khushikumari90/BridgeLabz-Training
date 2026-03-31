//Leetcode problem 9
package leetcodeOOPS;
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        // Negative numbers are not palindrome
        if (x < 0) return false;

        int original = x;
        int reversed = 0;

        while (x > 0) {
            int rem = x % 10;
            reversed = reversed * 10 + rem;
            x = x / 10;
        }

        return original == reversed;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        PalindromeNumber sol = new PalindromeNumber();

        System.out.println(sol.isPalindrome(121));   // true
        System.out.println(sol.isPalindrome(-121));  // false
        System.out.println(sol.isPalindrome(10));    // false
        System.out.println(sol.isPalindrome(12321)); // true
    }
}

