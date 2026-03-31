package queue_interface;
import java.util.*;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {

        int n = 5;
        Queue<String> queue = new LinkedList<>();

        // Add first binary number
        queue.add("1");

        for (int i = 0; i < n; i++) {

            String current = queue.remove();
            System.out.println(current);

            // Generate next binary numbers
            queue.add(current + "0");
            queue.add(current + "1");
        }
    }
}
