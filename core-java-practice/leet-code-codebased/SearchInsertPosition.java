//Leetcode problem 35
package leetcodecorejava;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;   // avoids overflow

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;   // correct insert position
    }

    // Testing the method
    public static void main(String[] args) {
        SearchInsertPosition sol = new SearchInsertPosition();

        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println(sol.searchInsert(nums1, target1)); // Output: 2

        int target2 = 2;
        System.out.println(sol.searchInsert(nums1, target2)); // Output: 1

        int target3 = 7;
        System.out.println(sol.searchInsert(nums1, target3)); // Output: 4

        int target4 = 0;
        System.out.println(sol.searchInsert(nums1, target4)); // Output: 0
    }
}
