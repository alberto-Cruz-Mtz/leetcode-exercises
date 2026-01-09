package leet.code;

import java.util.Arrays;

public class LongestCommonPrefix {
    //Write a function to find the longest common prefix string amongst an array of strings.
    //If there is no common prefix, return an empty string "".

    /**
     * Solución al problema Longest Common Prefix.
     * Utiliza un StringBuilder para construir el prefijo común.
     * Ordena el arreglo `strs` y compara únicamente la primera y la última cadena,
     * lo que permite determinar el prefijo común mínimo entre todas las entradas.
     * Si no existe prefijo común entre la primera y la última cadena, retorna una cadena vacía.
     *
     * @param strs arreglo de cadenas de entrada
     * @return el prefijo común más largo, o una cadena vacía si no existe
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        StringBuilder prefixBuilder = new StringBuilder();

        Arrays.sort(strs, String::compareTo);
        char[] firstChars = strs[0].toCharArray();
        char[] lastChars = strs[strs.length - 1].toCharArray();
        int charIndex = 0;
        int compareLength = Math.min(firstChars.length, lastChars.length);

        while (charIndex < compareLength && firstChars[charIndex] == lastChars[charIndex]) {
            prefixBuilder.append(firstChars[charIndex]);
            charIndex++;
        }

        return prefixBuilder.toString();
    }

    public static void main(String[] args) {
        String[] case1 = {"flower", "flow", "flight"};
        String[] case2 = {"dog", "racecar", "car"};
        String[] case3 = {"call", "called", "case", "car", "c"};

        String expected1 = "fl";
        String expected2 = "";
        String expected3 = "c";

        String result1 = longestCommonPrefix(case1);
        String result2 = longestCommonPrefix(case2);
        String result3 = longestCommonPrefix(case3);

        if (result1.equals(expected1)) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 FAILED: expected " + expected1 + " but got " + result1);
        }

        if (result2.equals(expected2)) {
            System.out.println("Test 2 passed");
        } else {
            System.out.println("Test 2 FAILED: expected " + expected2 + " but got " + result2);
        }

        if (result3.equals(expected3)) {
            System.out.println("Test 3 passed");
        } else {
            System.out.println("Test 3 FAILED: expected " + expected3 + " but got " + result3);
        }
    }
}
