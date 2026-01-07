package leet.code;

import java.util.Arrays;

public class IsPalindrome {

    // Given an integer x, return true if x is a palindrome, and false otherwise.

    /**
     * Refactoriza la solución anterior agregando como restricción no usar métodos nativos
     * para invertir la cadena, esta forma de resolver el problema implica convertir el parámetro
     * en una cadena y de ahi obtenerlo como un arreglo de caracteres y recorrerlo desde el final al inicio
     * pero aumenta el tiempo de runtime de 8ms con StringBuilder a 10ms con la forma actual
     */
    public static boolean isPalindrome(int x) {
        String originally = String.valueOf(x);
        String reverse = "";
        char[] characters = originally.toCharArray();

        for (int i = originally.length() - 1; i >= 0; i--) {
            reverse += characters[i];
        }

        return reverse.equals(originally);
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
