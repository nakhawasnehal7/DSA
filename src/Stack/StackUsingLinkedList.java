package Stack;

public class StackUsingLinkedList {

    public static Node head;

    public static boolean isEmpty() {
        return head == null;
    }

    public static void push(String value) {
        Node n = new Node();
        n.value = value;
        if (isEmpty()) {
            head = n;
            return;
        }
        n.next = head;
        head = n;
    }

    public static String pop() {
        String top = head.value;
        head = head.next;
        return top;
    }

    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return head.value;
    }

}
