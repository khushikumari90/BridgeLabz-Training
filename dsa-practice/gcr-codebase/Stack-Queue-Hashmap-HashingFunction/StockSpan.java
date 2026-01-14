package Stack_Queue_Hashmap_HashingFunction;
import java.util.Stack;

public class StockSpan {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        // First day span is always 1
        span[0] = 1;
        stack.push(0);

        for (int i = 1; i < n; i++) {
            // Pop while current price is higher than stack top price
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }

            // Calculate span
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current index
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] result = calculateSpan(prices);

        System.out.print("Stock Span: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
