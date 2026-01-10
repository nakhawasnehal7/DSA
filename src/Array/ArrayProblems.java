package Array;

public class ArrayProblems {
    public static int findMissingNumberInArray(int[] array) {

        int n = array.length + 1;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int number : array) {
            actualSum += number;
        }
        System.out.println(expectedSum + " " + actualSum);
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5};
        System.out.println(findMissingNumberInArray(arr));


    }
}
