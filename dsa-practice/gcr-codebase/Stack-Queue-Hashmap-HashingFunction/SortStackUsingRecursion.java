package Stack_Queue_Hashmap_HashingFunction;
import java.util.Stack;

public class SortStackUsingRecursion {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        // Base case
        if (stack.isEmpty()) {
            return;
        }

        // Step 1: Pop top element
        int top = stack.pop();

        // Step 2: Sort remaining stack
        sortStack(stack);

        // Step 3: Insert element in sorted order
        insertSorted(stack, top);
    }

    // Helper function to insert element at correct position
    private static void insertSorted(Stack<Integer> stack, int value) {
        // Base case: correct position found
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        // Remove top and recur
        int top = stack.pop();
        insertSorted(stack, value);

        // Put back the removed element
        stack.push(top);
    }

    // Test the program
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
