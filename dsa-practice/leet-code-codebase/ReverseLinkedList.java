//Problem no 206
package dsa_leetcode;
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }

    // Helper method to print list
    static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1,
                            new ListNode(2,
                            new ListNode(3,
                            new ListNode(4,
                            new ListNode(5)))));

        System.out.print("Original List: ");
        printList(head);

        ReverseLinkedList sol = new ReverseLinkedList();
        head = sol.reverseList(head);

        System.out.print("Reversed List: ");
        printList(head);
    }
}
