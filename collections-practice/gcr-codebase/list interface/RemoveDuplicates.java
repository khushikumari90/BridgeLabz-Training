package list_interface;
import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args) {

        List<Integer> list =
                Arrays.asList(3, 1, 2, 2, 3, 4);

        Set<Integer> set = new LinkedHashSet<>(list);

        List<Integer> result = new ArrayList<>(set);

        System.out.println(result);
    }
}
