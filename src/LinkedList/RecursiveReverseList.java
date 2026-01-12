package LinkedList;

public class RecursiveReverseList {

    public Node recursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newNode = recursive(head);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}
