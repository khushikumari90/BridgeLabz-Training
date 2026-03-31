package lambda_expressions;
import java.util.Arrays;
import java.util.List;

public class HRLetter {
    public static void main(String[] args) {

        List<String> employeeNames = Arrays.asList(
                "khushi",
                "rahul",
                "neha"
        );

        employeeNames.stream()
                .map(String::toUpperCase)   // method reference
                .forEach(System.out::println);
    }
}

