//Write a program to split the text into words and find the shortest and longest strings in a given text
package strings;
import java.util.Scanner;
public class ShortestAndLongestString {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter the text: ");
	        String text = sc.nextLine();

	        String[] words = splitWords(text);
	        String[][] wordLenArray = wordLengthArray(words);
	        int[] result = findShortestLongest(wordLenArray);

	        System.out.println("\nWord and Length:");
	        for (int i = 0; i < wordLenArray.length; i++) {
	            System.out.println(wordLenArray[i][0] + " - " + wordLenArray[i][1]);
	        }

	        System.out.println("\nShortest word length: " + result[0]);
	        System.out.println("Longest word length: " + result[1]);

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
            // End of string
        }
        return count;
    }

    // Method to split text into words using charAt()
    public static String[] splitWords(String text) {

        int wordCount = 0;
        boolean isWord = false;

        // Count number of words
        for (int i = 0; i < findLength(text); i++) {
            if (text.charAt(i) != ' ' && !isWord) {
                wordCount++;
                isWord = true;
            } else if (text.charAt(i) == ' ') {
                isWord = false;
            }
        }

        String[] words = new String[wordCount];
        String word = "";
        int index = 0;

        // Extract words
        for (int i = 0; i < findLength(text); i++) {
            if (text.charAt(i) != ' ') {
                word = word + text.charAt(i);
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

    // Method to create 2D array of word and length
    public static String[][] wordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    // Method to find shortest and longest word
    public static int[] findShortestLongest(String[][] arr) {

        int min = Integer.parseInt(arr[0][1]);
        int max = Integer.parseInt(arr[0][1]);

        for (int i = 1; i < arr.length; i++) {
            int len = Integer.parseInt(arr[i][1]);
            if (len < min) {
                min = len;
            }
            if (len > max) {
                max = len;
            }
        }

        return new int[]{min, max};
    }


}
