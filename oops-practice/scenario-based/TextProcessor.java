//A text editing tool receives poorly formatted input from users. Your task is to auto-correct formatting by fixing spacing and capitalizing the first letter of each sentence. Problem:
package oopsscenariobased;
import java.util.Scanner;

public class TextProcessor {

    private String paragraph;

    // Constructor
    public TextProcessor(String paragraph) {
        this.paragraph = paragraph;
    }

    public String formatParagraph() {

        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "Empty or invalid paragraph!";
        }

        // Remove extra spaces
        String formatted = paragraph.trim().replaceAll("\\s+", " ");

        // Ensure single space after punctuation
        formatted = formatted.replaceAll("([.!?])\\s*", "$1 ");

        // Capitalize first letter of each sentence
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (char ch : formatted.toCharArray()) {
            if (capitalizeNext && Character.isLetter(ch)) {
                result.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                result.append(ch);
            }

            if (ch == '.' || ch == '!' || ch == '?') {
                capitalizeNext = true;
            }
        }

        return result.toString().trim();
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String input = sc.nextLine();

        TextProcessor formatter = new TextProcessor(input);

        System.out.println("\nFormatted Paragraph:");
        System.out.println(formatter.formatParagraph());

        sc.close();
    }
}


   