package map_interface;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {

        String input = "Hello world, hello Java!";

        // Step 1: Convert to lowercase
        input = input.toLowerCase();

        // Step 2: Remove special characters without regex
        String cleaned = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // keep only letters and space
            if ((ch >= 'a' && ch <= 'z') || ch == ' ') {
                cleaned = cleaned + ch;
            }
        }

        // Step 3: Split words using space
        String[] words = cleaned.split(" ");

        // Step 4: Count word frequency
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (!word.equals("")) {   // avoid empty words
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // Step 5: Print result
        System.out.println(wordCount);
    }
}
