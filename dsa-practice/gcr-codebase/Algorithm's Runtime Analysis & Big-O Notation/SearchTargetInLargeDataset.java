package algorithms_runtimeanalysis_and_bigOnotation;
import java.util.Arrays;

public class SearchTargetInLargeDataset {

    // Linear Search Method
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search Method
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] datasetSizes = {1000, 10000, 1_000_000};
        int target = -1;

        for (int size : datasetSizes) {

            int[] data = new int[size];

            for (int i = 0; i < size; i++) {
                data[i] = i + 1;
            }

            target = size;

            long startTime = System.nanoTime();
            linearSearch(data, target);
            long endTime = System.nanoTime();
            long linearTime = endTime - startTime;

            Arrays.sort(data);

            startTime = System.nanoTime();
            binarySearch(data, target);
            endTime = System.nanoTime();
            long binaryTime = endTime - startTime;

            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearTime / 1_000_000.0 + " ms");
            System.out.println("Binary Search Time: " + binaryTime / 1_000_000.0 + " ms");
            System.out.println("-----------------------------------");
        }
    }
}
