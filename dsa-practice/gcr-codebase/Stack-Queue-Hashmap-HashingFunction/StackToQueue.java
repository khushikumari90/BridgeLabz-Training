package Stack_Queue_Hashmap_HashingFunction;
import java.util.Stack;

public class StackToQueue {

    private Stack<Integer> stackEnqueue;
    private Stack<Integer> stackDequeue;

    public StackToQueue() {
        stackEnqueue = new Stack<>();
        stackDequeue = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int data) {
        stackEnqueue.push(data);
        System.out.println("Enqueued: " + data);
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        // Transfer elements if dequeue stack is empty
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }

        return stackDequeue.pop();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
    }

    // Peek front element
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }

        return stackDequeue.peek();
    }

    // Main method for testing
    public static void main(String[] args) {
    	StackToQueue queue = new StackToQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front element: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
    }
}

