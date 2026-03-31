package list_interface;
import java.util.LinkedList;

public class NthFromEnd {
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int n = 2;

        String result = findNthFromEnd(list, n);
        System.out.println(result);
    }

    public static String findNthFromEnd(LinkedList<String> list, int n) {

        var fast = list.listIterator();
        var slow = list.listIterator();

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (!fast.hasNext()) {
                return null; // n is greater than list length
            }
            fast.next();
        }

        // Move both pointers until fast reaches the end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next();
    }
}
