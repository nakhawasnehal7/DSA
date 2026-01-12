package Queue;

import Stack.Stack;

public class QueueUsingStack {
    Stack s1 = new Stack(5);
    Stack s2 = new Stack(5);

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public void add(int data) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(data);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int remove() {
        return s1.pop();
    }

}
