//Create a program that analyzes a given paragraph of text.
package oopsscenariobased;
import java.util.Scanner;

public class TextAnalyzer {

    private String paragraph;

    // Constructor
    public TextAnalyzer(String paragraph) {
        this.paragraph = paragraph;
    }

    public int countWords() {

        if (paragraph == null || paragraph.trim().isEmpty()) {
            return 0;
        }

        String[] words = paragraph.trim().split("\\s+");
        return words.length;
    }

    public String findLongestWord() {

        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "No words found";
        }

        String[] words = paragraph.replaceAll("[^a-zA-Z ]", "").split("\\s+");
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public String replaceWord(String oldWord, String newWord) {

        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "Empty paragraph!";
        }

        return paragraph.replaceAll("(?i)\\b" + oldWord + "\\b", newWord);
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a paragraph:");
        String input = sc.nextLine();

        TextAnalyzer analyzer = new TextAnalyzer(input);

        System.out.println("\nWord Count: " + analyzer.countWords());
        System.out.println("Longest Word: " + analyzer.findLongestWord());

        System.out.print("\nEnter word to replace: ");
        String oldWord = sc.next();

        System.out.print("Enter new word: ");
        String newWord = sc.next();

        System.out.println("\nUpdated Paragraph:");
        System.out.println(analyzer.replaceWord(oldWord, newWord));

        sc.close();
    }
}
