//Write a program to find vowels and consonants in a string and display the count of  Vowels and Consonants in the string
package strings;
import java.util.Scanner;
public class findVowelAndConsonants {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        int[] counts = countVowelsConsonants(text);

        System.out.println("\nNumber of vowels: " + counts[0]);
        System.out.println("Number of consonants: " + counts[1]);
     
        sc.close();

	}
	
    // Method to check if a character is vowel, consonant, or not a letter
    public static String checkChar(char ch) {
        // Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') { // it's a letter
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "NotLetter";
        }
    }

    // Method to count vowels and consonants in a string
    public static int[] countVowelsConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            String result = checkChar(text.charAt(i));
            if (result.equals("Vowel")) {
                vowels++;
            } else if (result.equals("Consonant")) {
                consonants++;
            }
        }

        return new int[]{vowels, consonants};
    }



}
