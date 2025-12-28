//Write a program to find vowels and consonants in a string and display the character type - Vowel, Consonant, or Not a Letter
package strings;
import java.util.Scanner;
public class VowelConsonantCharacterType {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Process the string
        String[][] result = findVowelsAndConsonants(input);

        // Display result
        displayTable(result);

        sc.close();

	}
	// Method to check whether a character is Vowel, Consonant or Not a Letter
    public static String checkCharacterType(char ch) {

        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if character is a letter
        if (ch >= 'a' && ch <= 'z') {

            // Check for vowels
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }

        } else {
            return "Not a Letter";
        }
    }

    // Method to create a 2D array of characters and their types
    public static String[][] findVowelsAndConsonants(String text) {

        int length = text.length();
        String[][] result = new String[length][2];

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacterType(ch);
        }

        return result;
    }

    // Method to display the 2D array in tabular format
    public static void displayTable(String[][] data) {

        System.out.println("\nCharacter\tType");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }


	

}
