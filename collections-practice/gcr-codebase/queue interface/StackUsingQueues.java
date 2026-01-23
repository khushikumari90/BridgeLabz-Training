package queue_interface;
import java.util.*;

public class StackUsingQueues {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push element into stack
    void push(int x) {
        q1.add(x);
    }

    // Pop element from stack
    int pop() {

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int popped = q1.remove();

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return popped;
    }

    public static void main(String[] args) {

        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
