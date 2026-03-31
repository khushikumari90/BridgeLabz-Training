//Leetcode Problem 1
package leetcodeOOPS;
import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        // Array to store result indices
        int[] result = new int[2];

        // Loop through the array
        for (int i = 0; i < nums.length; i++) {

            // Inner loop to check next elements
            for (int j = i + 1; j < nums.length; j++) {

                // Check if sum matches the target
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result; // return immediately once found
                }
            }
        }

        // Safety return (LeetCode guarantees one solution)
        return result;
    }

    // Main method to test the code
    public static void main(String[] args) {
        TwoSum obj = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] output = obj.twoSum(nums, target);

        System.out.println("Output Indices: " + Arrays.toString(output));
    }
}
