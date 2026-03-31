//Leetcode problem 344
package leetcodecorejava;
import java.util.Arrays;

public class ReverseString {

    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        // Two-pointer swap
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

        // Correct way to convert char[] to String
        String str = new String(s);
        System.out.println(str);
    }

    // Main method for testing
    public static void main(String[] args) {
        ReverseString obj = new ReverseString();

        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        obj.reverseString(arr);   // Output: olleh

        // To verify array is modified in-place
        System.out.println(Arrays.toString(arr)); // [o, l, l, e, h]
    }
}
