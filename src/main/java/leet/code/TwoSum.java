package leet.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Elimina el for anidado reduciendo la complejidad a O(n)
     * Agrega un map donde se guarda como key el resultado de la resta entre el target
     * y como value el valor del índice
     * Se optimiza la búsqueda al buscar el valor del índice siguiente en la key y no recorriendo
     * el arreglo varias veces por índice
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> combined = new HashMap<>();
        int[] result = new int[2];
        int n;

        for (int i = 0; i < nums.length; i++) {
            if (combined.containsKey(nums[i])) {
                result[0] = combined.get(nums[i]);
                result[1] = i;
                return result;
            }

            n = target - nums[i];
            combined.put(n, i);
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

        if (Arrays.equals(result1, expected1)) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 FAILED: expected " + Arrays.toString(expected1) + " but got " + Arrays.toString(result1));
        }

        if (Arrays.equals(result2, expected2)) {
            System.out.println("Test 2 passed");
        } else {
            System.out.println("Test 2 FAILED: expected " + Arrays.toString(expected2) + " but got " + Arrays.toString(result2));
        }

        if (Arrays.equals(result3, expected1)) {
            System.out.println("Test 3 passed");
        } else {
            System.out.println("Test 3 FAILED: expected " + Arrays.toString(expected2) + " but got " + Arrays.toString(result3));
        }
    }
}