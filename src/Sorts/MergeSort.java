package Sorts;

public class MergeSort {

    public static void merge(int a[], int l, int m, int r) {

        int[] leftArray = new int[m - l + 2];
        int[] rightArray = new int[r - m + 1];

        for (int i = 0; i <= m - l; i++) {
            leftArray[i] = a[l + i];
        }

        for (int i = 0; i < r - m; i++) {
            rightArray[i] = a[m + 1 + i];
        }

        leftArray[m - l + 1] = Integer.MAX_VALUE;
        rightArray[r - m] = Integer.MAX_VALUE;


        int i = 0, j = 0;

        for (int k = l; k <= r; k++) {
            if (leftArray[i] < rightArray[j]) {
                a[k] = leftArray[i];
                i++;
            } else {
                a[k] = rightArray[j];
                j++;
            }

        }

    }

    public static void mergeSort(int a[], int l, int r) {
        if (r > l) {
            int m = (r + l) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public static void main(String[] args) {
        int a[] = {4, 7, 3, 0, 6, 87, 24, 12, 3, 8};
        mergeSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }
}
