package regex;

import java.util.regex.*;
import java.util.Scanner;

public class ValidateUsername {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String input = sc.nextLine();

        Pattern pattern = Pattern.compile("^[A-Za-z][A-Za-z0-9_]{4,14}$");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println("Valid Username");
        } else {
            System.out.println("Invalid Username");
        }
        
        sc.close();
    }
}
