package Sorts;

public class QuickSort {


    public static int pivot(int a[], int start, int end) {
        int pivot = end;
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if (a[j] <= a[pivot]) {
                i++;
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }
        return i;
    }

    public static void quickSort(int a[], int start, int end) {
        if (start < end) {
            int p = pivot(a, start, end);
            quickSort(a, start, p - 1);
            quickSort(a, p + 1, end);
        }


    }


    public static void main(String[] args) {
        int a[] = {4, 7, 3, 0, 6, 87, 24, 12, 3, 8};
        quickSort(a, 0, a.length-1 );
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");

        }
    }
}
