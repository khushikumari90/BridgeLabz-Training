//Leetcode problem 242
package leetcodecorejava;
import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        // If lengths are not equal, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency arrays for 26 lowercase letters
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        // Count character frequencies
        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) - 'a']++;
            arr2[t.charAt(i) - 'a']++;
        }

        // Compare both frequency arrays
        return Arrays.equals(arr1, arr2);
    }

    // Main method for testing
    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();

        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(obj.isAnagram(s1, t1)); // true

        String s2 = "rat";
        String t2 = "car";
        System.out.println(obj.isAnagram(s2, t2)); // false
    }
}

