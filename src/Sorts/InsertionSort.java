package Sorts;

public class InsertionSort {

    static void insertion(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;

            while (j > 0 && arr[j - 1] > tmp) {
                arr[j] = arr[j - 1];
                j--;

            }

            arr[j] = tmp;
        }

    }


    public static void main(String[] args) {

        int a[] = {4, 7, 3, 0, 6, 87, 24, 12, 3, 8};
        insertion(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");

        }
    }
}
