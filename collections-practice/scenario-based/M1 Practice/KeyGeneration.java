package m1_questions;
import java.util.*;

public class KeyGeneration {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(generateKey(arr[i]));
        }

        sc.close();
    }

    public static String generateKey(String str) {
        if (str.length() == 0) {
            return "Invalid Input (empty string)";
        }

        if (str.length() < 6) {
            return "Invalid Input (length < 6)";
        }

        if (str.contains(" ")) {
            return "Invalid Input (contains space)";
        }

        if (str.matches(".*\\d.*")) {
            return "Invalid Input (contains digits)";
        }

        if (!str.matches("[a-zA-Z]+")) {
            return "Invalid Input (contains special character)";
        }

        str = str.toLowerCase();

        StringBuilder temp = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch % 2 != 0) {
                temp.append(ch);
            }
        }

        temp.reverse();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < temp.length(); i++) {
            char ch = temp.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(ch);
            }
        }

        return "The generated key is - " + result.toString();
    }
}