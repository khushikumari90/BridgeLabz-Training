package set_interface;
import java.util.*;

public class SymmetricDifference {
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> result = new HashSet<>(set1);
        result.removeAll(set2);   // A - B

        Set<Integer> temp = new HashSet<>(set2);
        temp.removeAll(set1);     // B - A

        result.addAll(temp);      // (A - B) ∪ (B - A)

        System.out.println(result);
    }
}
