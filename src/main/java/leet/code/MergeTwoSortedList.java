package leet.code;

/**
 * LeetCode Problem 21: Merge Two Sorted Lists
 *
 * Problema:
 * Dadas las cabezas de dos listas enlazadas ordenadas (list1 y list2),
 * fusionarlas en una sola lista ordenada. La lista debe formarse empalmando
 * los nodos de las dos primeras listas.
 *
 * Ejemplo 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Ejemplo 2:
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Ejemplo 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * Restricciones:
 * - El número de nodos en ambas listas está en el rango [0, 50]
 * - -100 <= Node.val <= 100
 * - Ambas listas están ordenadas en orden no decreciente
 */
public class MergeTwoSortedList {

    /**
     * Fusiona dos listas enlazadas ordenadas en una sola lista ordenada usando recursión.
     *
     * Estrategia de Solución:
     * - Usa un enfoque recursivo para comparar los valores de los nodos actuales
     * - En cada llamada recursiva, selecciona el nodo más pequeño y avanza en esa lista
     * - Los casos base manejan cuando alguna de las listas está vacía
     *
     * Complejidad Temporal: O(n + m) donde n y m son las longitudes de list1 y list2
     * - Cada nodo es visitado exactamente una vez
     *
     * Complejidad Espacial: O(n + m) por la pila de recursión
     * - La profundidad de recursión es igual al número total de nodos
     *
     * @param list1 Cabeza de la primera lista enlazada ordenada
     * @param list2 Cabeza de la segunda lista enlazada ordenada
     * @return Cabeza de la lista enlazada fusionada y ordenada
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Caso base: si list1 está vacía, retornar list2
        if (list1 == null) return list2;
        // Caso base: si list2 está vacía, retornar list1
        if (list2 == null) return list1;

        // Comparar valores actuales y recursivamente fusionar el resto
        if (list1.val < list2.val) {
            // El nodo de list1 es menor, anexar el resultado de fusionar list1.next con list2
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            // El nodo de list2 es menor o igual, anexar el resultado de fusionar list1 con list2.next
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    /**
     * Método principal para probar la solución con ejemplos
     */
    public static void main(String[] args) {
        //list1 = [1,2,4], list2 = [1,3,4]
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList = mergeTwoLists(list1, list2);

        System.out.println(mergedList); // Output esperado: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null
    }
}

/**
 * Definición de un nodo de lista enlazada simple
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * Representación en String de la lista enlazada para facilitar debugging
     * @return String con formato "val1 -> val2 -> ... -> null"
     */
    @Override
    public String toString() {
        return this.val + " -> " + (this.next != null ? this.next.toString() : "null");
    }
}
