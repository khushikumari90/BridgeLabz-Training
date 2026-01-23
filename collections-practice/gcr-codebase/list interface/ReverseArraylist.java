package list_interface;
import java.util.ArrayList;
import java.util.Arrays;

public class ReverseArraylist {
    public static void main(String[] args) {
        ArrayList<Integer> list =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);

            start++;
            end--;
        }

        System.out.println(list);
    }
}
