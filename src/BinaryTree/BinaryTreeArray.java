package BinaryTree;

public class BinaryTreeArray {


    int arr[];
    int lastIndex;

    public BinaryTreeArray(int size) {
        arr = new int[size + 1];
        this.lastIndex = 0;

    }


    public boolean isFull() {
        if (arr.length == lastIndex) {
            System.out.println("BT is full");
            return true;
        }
        return false;
    }

    public void insert(int value) {
        if (!isFull()) {

            arr[lastIndex + 1] = value;
            lastIndex++;
        } else {
            System.out.println("BT is full!");
        }
    }


    public void preOrderTravesal(int index) {
        if (index > lastIndex) {
            return;
        }
        System.out.println(arr[index] + "");
        preOrderTravesal(2 * index);
        preOrderTravesal(2 + index + 1);
    }

    public void postOrderTravesal(int index) {
        if (index > lastIndex) {
            return;
        }
        postOrderTravesal(2 * index);
        postOrderTravesal(2 + index + 1);
        System.out.println(arr[index] + "");

    }

    public void LevelOrder() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int search(int val) {
        for (int i = 0; i <= lastIndex; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int val) {
        int location = search(val);
        if (location == -1) {
            return;
        } else {
            arr[location] = arr[lastIndex];
            lastIndex--;

        }
    }

    public void delete() {
        arr = null;
    }
}