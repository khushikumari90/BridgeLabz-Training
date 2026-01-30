package regex;
import java.util.regex.*;

public class FindRepeatingWords {
    public static void main(String[] args) {

        String input = "This is is a repeated repeated word test.";

        Pattern pattern = Pattern.compile("\\b(\\w+)\\s+\\1\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
