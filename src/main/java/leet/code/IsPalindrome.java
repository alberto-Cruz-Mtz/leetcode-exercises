package leet.code;

import java.util.Arrays;

public class IsPalindrome {

    // Given an integer x, return true if x is a palindrome, and false otherwise.

    /**
     * Esta solución utiliza la clase StringBuilder aprovechando su metodo
     * reverse(), siendo esta la forma de resolver este problema de la manera más fácil
     */
    public static boolean isPalindrome(int x) {
        String word = String.valueOf(x);
        StringBuilder build = new StringBuilder(word);
        return build.reverse().toString().equals(word);
    }

    public static void main(String[] args) {
        int case1 = 121, case2 = -121, case3 = 10;

        boolean result1 = isPalindrome(case1);
        boolean result2 = isPalindrome(case2);
        boolean result3 = isPalindrome(case3);

        if (result1) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 FAILED: expected TRUE");
        }


        if (!result2) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 FAILED: expected FALSE");
        }

        if (!result3) {
            System.out.println("Test 3 passed");
        } else {
            System.out.println("Test 3 FAILED: expected FALSE");
        }
    }
}
