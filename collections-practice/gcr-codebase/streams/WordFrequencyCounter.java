package streams;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        String filePath = "src/streams/input.txt";
        Map<String, Integer> wordCountMap = new HashMap<>();
        int totalWords = 0;

        // Reading the file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = br.readLine()) != null) {

                // Remove punctuation and convert to lowercase
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        totalWords++;
                        wordCountMap.put(word,
                                wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort words by frequency
        List<Map.Entry<String, Integer>> sortedList =
                new ArrayList<>(wordCountMap.entrySet());

        sortedList.sort((a, b) -> b.getValue() - a.getValue());

        // Display results
        System.out.println("Total number of words: " + totalWords);
        System.out.println("Top 5 most frequent words:");

        for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
            Map.Entry<String, Integer> entry = sortedList.get(i);
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

