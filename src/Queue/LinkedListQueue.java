package Queue;

public class LinkedListQueue {
    public static Node head;
    public static Node tail;

    public static boolean isEmpty() {
        return head == null;
    }


    public static void add(int data) {
        Node n = new Node(data);
        if (tail == null) {
            tail = head = n;
            return;
        }
        tail.next = n;
        tail = n;
    }

    public static int remove() {
        if (isEmpty()) {
            return -1;
        }
        int font = head.data;
        if (head == tail) {
            tail = null;
        }
        head = head.next;
        return font;
    }
}
