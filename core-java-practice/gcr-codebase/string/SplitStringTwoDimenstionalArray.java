//Write a program to split the text into words and return the words along with their lengths in a 2D array
package strings;
import java.util.Scanner;
public class SplitStringTwoDimenstionalArray {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        // Method calls
        String[] words = splitText(text);
        String[][] result = createWordLengthArray(words);

        // Display result in tabular format
        System.out.println("\nWord\tLength");
   

        for (int i = 0; i < result.length; i++) {
            int length = Integer.parseInt(result[i][1]);
            System.out.println(result[i][0] + "\t" + length);
        }
		 
        sc.close();
	}
	
	// Method to find length of a string without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // End of string reached
        }
        return count;
    }

    // Method to split text into words using charAt()
    public static String[] splitText(String text) {

        int wordCount = 0;
        boolean inWord = false;

        // Count words
        for (int i = 0; i < findLength(text); i++) {
            char ch = text.charAt(i);
            if (ch != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (ch == ' ') {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        int index = 0;
        String word = "";

        // Extract words
        for (int i = 0; i < findLength(text); i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                word += ch;
            } else if (!word.equals("")) {
                words[index++] = word;
                word = "";
            }
        }

        if (!word.equals("")) {
            words[index] = word;
        }

        return words;
    }

    // Method to create 2D array of word and its length
    public static String[][] createWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

}
