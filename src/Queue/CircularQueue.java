package Queue;

public class CircularQueue {
    static int arr[];
    static int rear = -1;
    static int front = -1;
    static int size;

    public CircularQueue(int n) {
        arr = new int[n];
        this.size = n;
    }

    public static boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public static boolean isFull() {
        return (rear + 1) % size == front;
    }


    public static void add(int data) {
        if (isFull()) {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }
    }


    public static int remove() {
        if (isEmpty()) {
            return -1;
        }
        int result = arr[front];

        if (rear == front) {
            rear = front = -1;
        } else {
            front = (front + 1) % 100;
        }

        return result;
    }

    public int peek() {
        return arr[front];
    }
}
