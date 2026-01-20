package algorithms_runtimeanalysis_and_bigOnotation;
import java.util.HashSet;
import java.util.TreeSet;

public class CompareDataStructuresForSearching {

    // Array Linear Search O(N)
    public static boolean arraySearch(int[] arr, int target) {
        for (int value : arr) {
            if (value == target)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] datasetSizes = {1_000, 100_000, 1_000_000};

        for (int size : datasetSizes) {

            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                array[i] = i;
                hashSet.add(i);
                treeSet.add(i);
            }

            int target = size - 1;

            System.out.println("Dataset Size: " + size);

            // Array Search
            long start = System.nanoTime();
            arraySearch(array, target);
            long end = System.nanoTime();
            System.out.println("Array Search Time: "
                    + (end - start) / 1_000_000.0 + " ms");

            // HashSet Search
            start = System.nanoTime();
            hashSet.contains(target);
            end = System.nanoTime();
            System.out.println("HashSet Search Time: "
                    + (end - start) / 1_000_000.0 + " ms");

            // TreeSet Search
            start = System.nanoTime();
            treeSet.contains(target);
            end = System.nanoTime();
            System.out.println("TreeSet Search Time: "
                    + (end - start) / 1_000_000.0 + " ms");

            System.out.println("------------------------------------");
        }
    }
}
