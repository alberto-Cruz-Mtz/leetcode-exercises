package leet.code;

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int a, b;
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                b = nums[j];
                if ((a + b) == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] case1 = {2, 7, 11, 15};
        int[] case2 = {3, 2, 4};
        int[] case3 = {3, 3};

        int[] result1 = twoSum(case1, 9);
        int[] result2 = twoSum(case2, 6);
        int[] result3 = twoSum(case3, 6);

        int[] expected1 = {0, 1};
        int[] expected2 = {1, 2};

        assert Arrays.equals(result1, expected1);
        assert Arrays.equals(result2, expected2);
        assert Arrays.equals(result3, expected1);
    }
}