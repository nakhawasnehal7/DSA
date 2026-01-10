package Stack;

public class Stack {

    int[] arr;
    int top;

    public Stack(int size) {
        arr = new int[size];
        top = 0;
    }


    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == arr.length;
    }

    public void push(int val) {
        if (isFull()) {
            return;

        }
        arr[top++] = val;
        //top++;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;

        }
        int val = arr[--top];
        //top--;
        return val;
    }

    public static void pushAtBottom(int data, Stack s) {

        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();

        System.out.println("pop"+top);

        pushAtBottom(data, s);
        System.out.println("push"+top);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack s = new Stack(6);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        pushAtBottom(5, s);

        while (!s.isEmpty()) {
            System.out.println("va" + s.pop());
        }


    }
}
