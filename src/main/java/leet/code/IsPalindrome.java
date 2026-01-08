package leet.code;

public class IsPalindrome {

    // Given an integer x, return true if x is a palindrome, and false otherwise.

    /**
     * Anteriormente, se agrega como restricción el uso de métodos nativos para invertir cadenas
     * Entonces se usó un String para concatenar cada carácter del parámetro, pero esa solución
     * agregaba 3ms más de runtime según el medidor de leetcode, pero si se cambia el String por
     * StringBuilder el tiempo de runtime vuelve a 8ms esto se debe a que al usar un
     * String y concatenarle no estás usando el mismo espacio en memoria si no creas uno nuevo
     * por cada concatenación a diferencia de StringBuilder que no crea nuevos espacios en memoria
     */
    public static boolean isPalindrome(int x) {
        String originally = String.valueOf(x);
        StringBuilder reverse = new StringBuilder();
        char[] characters = originally.toCharArray();

        for (int i = originally.length() - 1; i >= 0; i--) {
            reverse.append(characters[i]);
        }

        return reverse.toString().equals(originally);
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
