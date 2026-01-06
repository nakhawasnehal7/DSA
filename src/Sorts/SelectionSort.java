package Sorts;

public class SelectionSort {


    static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[max]) {
                    max = j;

                }
            }
            if (max != i) {
                int tmp = arr[max];
                arr[max] = arr[i];
                arr[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {4, 7, 3, 0, 6, 87, 24, 12, 3, 8};
        selectionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }
}
