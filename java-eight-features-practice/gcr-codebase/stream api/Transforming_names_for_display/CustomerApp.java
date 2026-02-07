package Transforming_names_for_display;
import java.util.*;

public class CustomerApp {
    public static void main(String[] args) {

        List<String> customerNames = Arrays.asList(
            "khushi",
            "Amit",
            "neha",
            "Rahul",
            "sneha"
        );

        customerNames.stream()
                     .map(String::toUpperCase) // convert to uppercase
                     .sorted()                 // sort alphabetically
                     .forEach(System.out::println);
    }
}
