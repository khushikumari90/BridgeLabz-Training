package list_interface;
import java.util.LinkedList;
import java.util.Arrays;

public class ReverseLinkedlist {
    public static void main(String[] args) {
        LinkedList<Integer> list =
                new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        LinkedList<Integer> reversedList = new LinkedList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }

        System.out.println(reversedList);
    }
}

