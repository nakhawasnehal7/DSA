package Queue;

public class Queue {

    static int arr[];
    static int size;
    static int rear = -1;
    static int front = 1;

    Queue(int n) {
        arr = new int[n];
        this.size = n;
    }

    public static boolean isEmpty() {
        return rear == -1;

    }

    public static void add(int data) {
        if (rear == -1) {
            return;
        }
        rear++;
        arr[rear] = data;

    }

    public static int peek() {
        return arr[0];
    }

    public static int remove() {
        if (isEmpty()) {
            return -1;
        }

        int font = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
            rear--;
        }
        return font;
    }
}
