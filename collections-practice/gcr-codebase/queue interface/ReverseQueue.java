package queue_interface;
import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        reverseQueue(queue);

        System.out.println(queue);
    }

    // Method to reverse queue
    static void reverseQueue(Queue<Integer> queue) {

        // Base condition
        if (queue.isEmpty()) {
            return;
        }

        // Remove front element
        int data = queue.remove();

        // Reverse remaining queue
        reverseQueue(queue);

        // Add removed element at end
        queue.add(data);
    }
}
