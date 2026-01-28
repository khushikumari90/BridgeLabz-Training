package scenario_based;

import java.util.*;

public class LexicalTwist {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word");
        String firstWord = sc.nextLine();

        if (!isValidWord(firstWord)) {
            System.out.println(firstWord + " is an invalid word");
            sc.close();
            return;
        }

        System.out.println("Enter the second word");
        String secondWord = sc.nextLine();

        if (!isValidWord(secondWord)) {
            System.out.println(secondWord + " is an invalid word");
            sc.close();
            return;
        }

        if (isReverse(firstWord, secondWord)) {
            String result = transformReversedWord(firstWord);
            System.out.println(result);
        } else {
            processCombinedWords(firstWord, secondWord);
        }
        
        sc.close();
    }

    // Validation: checks if input contains only one word
    static boolean isValidWord(String word) {
        return !word.trim().contains(" ");
    }

    // Check if second word is reverse of first (case-insensitive)
    static boolean isReverse(String first, String second) {
        String reversed = new StringBuilder(first).reverse().toString();
        return reversed.equalsIgnoreCase(second);
    }

    // Reverse first word, lowercase it, replace vowels with '@'
    static String transformReversedWord(String word) {
        String reversed = new StringBuilder(word).reverse().toString().toLowerCase();
        StringBuilder result = new StringBuilder();

        for (char ch : reversed.toCharArray()) {
            if (isVowel(ch)) {
                result.append('@');
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // Combine words, convert to uppercase and process vowels/consonants
    static void processCombinedWords(String first, String second) {

        String combined = (first + second).toUpperCase();

        int vowels = 0, consonants = 0;

        for (char ch : combined.toCharArray()) {
            if (isVowel(ch)) {
                vowels++;
            } else {
                consonants++;
            }
        }

        if (vowels == consonants) {
            System.out.println("Vowels and consonants are equal");
        } else if (vowels > consonants) {
            printFirstTwoUniqueVowels(combined);
        } else {
            printFirstTwoUniqueConsonants(combined);
        }
    }

    // Print first 2 unique vowels
    static void printFirstTwoUniqueVowels(String word) {
        Set<Character> set = new LinkedHashSet<>();

        for (char ch : word.toCharArray()) {
            if (isVowel(ch)) {
                set.add(ch);
            }
            if (set.size() == 2) break;
        }

        for (char ch : set) {
            System.out.print(ch);
        }
        System.out.println();
    }

    // Print first 2 unique consonants
    static void printFirstTwoUniqueConsonants(String word) {
        Set<Character> set = new LinkedHashSet<>();

        for (char ch : word.toCharArray()) {
            if (!isVowel(ch)) {
                set.add(ch);
            }
            if (set.size() == 2) break;
        }

        for (char ch : set) {
            System.out.print(ch);
        }
        System.out.println();
    }

    // Vowel check
    static boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
}
