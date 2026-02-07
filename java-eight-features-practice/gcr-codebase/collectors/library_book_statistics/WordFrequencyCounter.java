package library_book_statistics;
import java.util.*;
import java.util.stream.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {

        String paragraph = "Java streams make java powerful and streams make code clean";

        Map<String, Integer> wordCount =
                Arrays.stream(paragraph.toLowerCase().split("\\s+"))
                      .collect(Collectors.toMap(
                          word -> word,        // key
                          word -> 1,           // initial count
                          Integer::sum         // merge function
                      ));

        wordCount.forEach((word, count) ->
                System.out.println(word + " : " + count));
    }
}
