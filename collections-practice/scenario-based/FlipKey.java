package scenario_based;
import java.util.*;

public class FlipKey {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word");
        String str = sc.nextLine();

        FlipKey obj = new FlipKey();
        String result = obj.CleanseAndInvert(str);

        if (result.equals("")) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - " + result);
        }
        sc.close();
    }

    public String CleanseAndInvert(String input) {

        // Condition 1: null or length less than 6
        if (input == null || input.length() < 6) {
            return "";
        }

        // Condition 2: no space, digit, or special character
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isLetter(ch)) {
                return "";
            }
        }

        // Convert to lowercase
        input = input.toLowerCase();

        // Remove characters with even ASCII values
        String filtered = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if ((int) ch % 2 != 0) {
                filtered += ch;
            }
        }

        // Reverse the string
        String reversed = "";
        for (int i = filtered.length() - 1; i >= 0; i--) {
            reversed += filtered.charAt(i);
        }

        // Convert even index characters to uppercase
        String result = "";
        for (int i = 0; i < reversed.length(); i++) {
            char ch = reversed.charAt(i);
            if (i % 2 == 0) {
                result += Character.toUpperCase(ch);
            } else {
                result += ch;
            }
        }

        return result;
    }
}
