package linearsearch_binarysearch_stringbuilder_stringbuffer_bufferedreader_filereader_inputstreamreader;
import java.util.Arrays;

public class LinearBinaryChallenge {

    // Linear Search: Find first missing positive integer
    public static int firstMissingPositive(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // Binary Search: Find index of target in sorted array
    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr); // sort array first
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int target = 4;

        int missing = firstMissingPositive(arr.clone()); // use clone to preserve original array
        int index = binarySearch(arr.clone(), target);

        System.out.println("First missing positive integer: " + missing);
        System.out.println("Index of target " + target + " after sorting: " + index);
    }
}
