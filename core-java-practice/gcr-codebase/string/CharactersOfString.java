//Write a program to return all the characters in a string using the user-defined method,  compare the result with the String built-in toCharArray() method, and display the result
package strings;
import java.util.Scanner;
public class CharactersOfString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        // Take input string
        System.out.print("Enter the string: ");
        String text = sc.next();

        // Get characters using user-defined method
        char[] manualArray = getCharsUsingCharAt(text);

        // Get characters using built-in toCharArray() method
        char[] builtInArray = text.toCharArray();

        // Compare both char arrays
        boolean result = compareCharArrays(manualArray, builtInArray);

        // Display the characters
        System.out.print("\nCharacters using user-defined method: ");
        for (char ch : manualArray) {
            System.out.print(ch + " ");
        }

        System.out.print("\nCharacters using toCharArray(): ");
        for (char ch : builtInArray) {
            System.out.print(ch + " ");
        }

        // Display comparison result
        System.out.println("\n\nAre both character arrays equal? " + result);

        sc.close();

	}
	
	 // Method to return characters of a string WITHOUT using toCharArray()
    public static char[] getCharsUsingCharAt(String text) {

        // Create a char array of same length as string
        char[] chars = new char[text.length()];

        // Copy each character using charAt()
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }

        return chars;
    }

    // Method to compare two char arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {

        // If lengths are different, arrays are not equal
        if (arr1.length != arr2.length) {
            return false;
        }

        // Compare each character
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true; // All characters matched
    }

}
