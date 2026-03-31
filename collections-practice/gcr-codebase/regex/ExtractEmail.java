package regex;

import java.util.regex.*;
import java.util.Scanner;

public class ExtractEmail {
    public static void main(String[] args) {

        System.out.println("Enter text:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Pattern pattern = Pattern.compile(
            "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}"
        );

        Matcher matcher = pattern.matcher(input);

        boolean found = false;

        while (matcher.find()) {
            System.out.println("Email found: " + matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("No email addresses found");
        }

        sc.close();
    }
}

