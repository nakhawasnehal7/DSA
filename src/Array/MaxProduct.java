package Array;

public class MaxProduct {
    // Max Product
    public static String maxProduct(int[] intArray) {
        int maxProduct = 0;
        String pairs = "";
        for (int i = 0; i<intArray.length; i++) {
            for (int j = i+1; j<intArray.length; j++) {
                if (intArray[i]*intArray[j]>maxProduct) {
                    maxProduct = intArray[i]*intArray[j];
                    pairs = Integer.toString(intArray[i]) + "," + Integer.toString(intArray[j]);
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] intArray = {10,60,30,40,50};
        String pairs = maxProduct(intArray);
        System.out.println(pairs);

    }
}
