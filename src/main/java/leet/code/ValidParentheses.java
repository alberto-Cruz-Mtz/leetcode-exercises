package leet.code;

import java.util.Stack;

public class ValidParentheses {
    //Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    /**
     * Solución al problema "Valid Parentheses".
     * Determina si la cadena de entrada contiene una secuencia válida de paréntesis.
     * Devuelve false si la cadena es nula o tiene longitud menor a 2.
     * Emplea una pila: se apilan los caracteres de apertura '(', '[', '{'.
     * Al procesar un carácter de cierre, verifica que la cima de la pila sea su
     * apertura correspondiente y, si es así, la desapila; en caso contrario la entrada
     * se considera inválida.
     * @param s cadena que contiene solo '(', ')', '{', '}', '[' y ']'
     * @return true si todos los paréntesis coinciden y están correctamente anidados; false en caso contrario
     */
    public static boolean isValid(String s) {
        if (s == null || s.length() < 2) return false;

        char[] characters = s.toCharArray();
        Stack<Character> parentheses = new Stack<>();

        for (char character : characters) {
            if (character == '(' || character == '[' || character == '{') {
                parentheses.push(character);
                continue;
            }

            if (parentheses.isEmpty()) {
                parentheses.push(character);
                continue;
            }

            if (character == ')' && parentheses.peek() == '(') {
                parentheses.pop();
                continue;
            }

            if (character == ']' && parentheses.peek() == '[') {
                parentheses.pop();
                continue;
            }

            if (character == '}' && parentheses.peek() == '{') {
                parentheses.pop();
                continue;
            }

            parentheses.push(character);
        }

        return parentheses.isEmpty();
    }

    public static void main(String[] args) {
        String case1 = "()";
        String case2 = "()[]{}";
        String case3 = "(]";
        String case4 = "([])";
        String case5 = "([)]";
        String case6 = ")}";
        String case7 = "(])";

        boolean expected1 = isValid(case1);
        boolean expected2 = isValid(case2);
        boolean expected3 = isValid(case3);
        boolean expected4 = isValid(case4);
        boolean expected5 = isValid(case5);
        boolean expected6 = isValid(case6);
        boolean expected7 = isValid(case7);

        System.out.println("Test case1: " + (expected1 ? "PASSED" : "FAILED"));
        System.out.println("Test case2: " + (expected2 ? "PASSED" : "FAILED"));
        System.out.println("Test case3: " + (!expected3 ? "PASSED" : "FAILED"));
        System.out.println("Test case4: " + (expected4 ? "PASSED" : "FAILED"));
        System.out.println("Test case5: " + (!expected5 ? "PASSED" : "FAILED"));
        System.out.println("Test case6: " + (!expected6 ? "PASSED" : "FAILED"));
        System.out.println("Test case7: " + (!expected7 ? "PASSED" : "FAILED"));
    }
}
