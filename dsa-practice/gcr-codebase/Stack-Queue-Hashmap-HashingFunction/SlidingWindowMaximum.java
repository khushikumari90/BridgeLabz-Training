package Stack_Queue_Hashmap_HashingFunction;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            // Remove elements out of this window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove all smaller elements
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Store result when window is complete
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] output = maxSlidingWindow(nums, k);

        System.out.print("Sliding Window Maximum: ");
        for (int val : output) {
            System.out.print(val + " ");
        }
    }
}
