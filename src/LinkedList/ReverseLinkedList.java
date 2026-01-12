package LinkedList;

import java.util.LinkedList;

public class ReverseLinkedList {
    public static void reverse(Node head){
        if(head==null){
            return;
        }

        Node prev = head;
        Node current = head.next;
        while(current.next!= null){

            Node next = current.next;
            current.next=prev;
            prev=current;
            current=next;


        }
        head.next=null;
        head=prev;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


    }
}
