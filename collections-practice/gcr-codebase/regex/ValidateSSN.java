package regex;
public class ValidateSSN {
    public static void main(String[] args) {

        String text = "My SSN is 123-45-6789.";
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";

        if (text.matches(".*" + regex + ".*")) {
            System.out.println("123-45-6789 is valid");
        } else {
            System.out.println("Invalid SSN");
        }
    }
}

