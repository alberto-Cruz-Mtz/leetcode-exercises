package leet.code;

import java.util.Map;

public class RomanToInteger {
    //Given a roman numeral, convert it to an integer.

    private static final Map<Character, Integer> romanMaps = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    /**
     * Convierte un número romano a su valor entero.
     * <p>
     * Recorre los caracteres de la cadena comparando cada símbolo con el siguiente:
     * - si el valor actual es mayor o igual que el siguiente, se suma;
     * - si es menor, se resta.
     * El último símbolo se añade al resultado al terminar el bucle.
     *
     * @param s número romano válido (por ejemplo "MCMXCIV")
     * @return el valor entero correspondiente
     */
    public static int romanToInt(String s) {
        char[] numbers = s.toCharArray();
        int number, next, index = 0, result = 0;

        while (index < numbers.length - 1) {
            number = romanMaps.get(numbers[index]);
            next = romanMaps.get(numbers[++index]);

            if (number >= next) {
                result += number;
                continue;
            }

            result -= number;
        }

        result += romanMaps.get(numbers[index]);
        return result;
    }

    public static void main(String[] args) {
        String case1 = "III", case2 = "LVIII", case3 = "MCMXCIV";
        int expected1 = 3, expected2 = 58, expected3 = 1994;

        int result1 = romanToInt(case1);
        int result2 = romanToInt(case2);
        int result3 = romanToInt(case3);

        if (expected1 == result1) {
            System.out.println("Test 1 passed");
        } else {
            System.out.println("Test 1 FAILED: expected " + expected1 + " but got " + result1);
        }

        if (expected2 == result2) {
            System.out.println("Test 2 passed");
        } else {
            System.out.println("Test 2 FAILED: expected " + expected2 + " but got " + result2);
        }

        if (expected3 == result3) {
            System.out.println("Test 3 passed");
        } else {
            System.out.println("Test 3 FAILED: expected " + expected3 + " but got " + result3);
        }
    }
}
