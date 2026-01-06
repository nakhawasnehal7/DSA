package Sorts;

public class BubbleSort {


    static void bubbleSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }

            }
        }
    }

    public static void main(String[] args) {
        int a[] = {4, 7, 3, 0, 6, 87, 24, 12, 3, 8};
        bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");

        }
    }
}
