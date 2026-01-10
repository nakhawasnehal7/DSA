package Array;

import java.util.Arrays;

public class TwoSum {
    // Two Sum
    public  static int[]  twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            for (int j = i+1; j<nums.length; j++) {
                if (nums[i]+nums[j]==target) {
                    return new int[] { i, j};
                }
            }
        }
        throw new IllegalArgumentException("No solution found");
    }

    public static void main(String[] args) {
        int[] intArray = {2,7,13,15};
        int[] result = twoSum(intArray, 20);
        System.out.println(Arrays.toString(result));
    }


}
