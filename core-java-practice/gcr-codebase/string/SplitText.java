//Write a program to split the text into words, compare the result with the split() method and display the result 
package strings;
import java.util.Scanner;
public class SplitText {

	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);

	        // Take complete text input
	        System.out.print("Enter the text: ");
	        String text = sc.nextLine();

	        // Split using user-defined method
	        String[] manualSplit = splitUsingCharAt(text);

	        // Split using built-in split() method
	        String[] builtInSplit = text.split(" ");

	        // Compare both arrays
	        boolean result = compareStringArrays(manualSplit, builtInSplit);

	        // Display results
	        System.out.println("\nWords using user-defined method:");
	        for (String word : manualSplit) {
	            System.out.println(word);
	        }

	        System.out.println("\nWords using split() method:");
	        for (String word : builtInSplit) {
	            System.out.println(word);
	        }

	        System.out.println("\nAre both results equal? " + result);

	        sc.close();

	}
	
	// Method to find length of string WITHOUT using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    // Method to split text into words using charAt() (without split())
    public static String[] splitUsingCharAt(String text) {

        int length = findLength(text);

        // Step 1: Count number of words
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Step 2: Store space indexes
        int[] spaceIndex = new int[wordCount - 1];
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[index++] = i;
            }
        }

        // Step 3: Extract words using indexes
        String[] words = new String[wordCount];

        int start = 0;
        for (int i = 0; i < spaceIndex.length; i++) {
            words[i] = text.substring(start, spaceIndex[i]);
            start = spaceIndex[i] + 1;
        }

        // Last word
        words[wordCount - 1] = text.substring(start);

        return words;
    }

    // Method to compare two String arrays
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        return true;
    }


}
