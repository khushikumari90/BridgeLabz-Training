package Stack_Queue_Hashmap_HashingFunction;
import java.util.*;

public class PairWithGivenSum {
    public static boolean hasPair(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            if (map.containsKey(target - num)) {
                return true;
            }
            map.put(num, 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3};
        int target = 10;
        System.out.println(hasPair(arr, target));
    }
}

