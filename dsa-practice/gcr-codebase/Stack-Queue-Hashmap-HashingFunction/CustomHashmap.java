package Stack_Queue_Hashmap_HashingFunction;
public class CustomHashmap {
    private static class Node {
        int key, value;
        Node next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int SIZE = 10;
    private Node[] table = new Node[SIZE];

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = table[index];

        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    public int get(int key) {
        int index = hash(key);
        Node head = table[index];

        while (head != null) {
            if (head.key == key) return head.value;
            head = head.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node head = table[index], prev = null;

        while (head != null) {
            if (head.key == key) {
                if (prev == null) table[index] = head.next;
                else prev.next = head.next;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public static void main(String[] args) {
    	CustomHashmap map = new CustomHashmap();
        map.put(1, 10);
        map.put(2, 20);
        System.out.println(map.get(1));
        map.remove(1);
        System.out.println(map.get(1));
    }
}
