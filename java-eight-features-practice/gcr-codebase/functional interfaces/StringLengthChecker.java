package functional_interface;
import java.util.function.Function;

public class StringLengthChecker {

    public static void main(String[] args) {

        int limit = 20;

        // Function to calculate string length
        Function<String, Integer> stringLength =
                msg -> msg.length();

        // Test messages
        checkMessage("Hello Java", limit, stringLength);
        checkMessage("This message is too long for SMS", limit, stringLength);
    }

    // Method using Function
    static void checkMessage(String message,
                             int limit,
                             Function<String, Integer> lengthFunction) {

        int length = lengthFunction.apply(message);

        if (length > limit) {
            System.out.println("Message exceeds limit (" + length + " characters)");
        } else {
            System.out.println("Message within limit (" + length + " characters)");
        }
    }
}
