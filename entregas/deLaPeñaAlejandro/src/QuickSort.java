import java.util.Arrays;

public class QuickSort {

    private static void printArray(int[] array, String mensaje) {
        System.out.println(mensaje + " " + Arrays.toString(array));
    }

    private static void printIndented(int nivel, String mensaje) {
        System.out.print("    ".repeat(nivel));
        System.out.println(mensaje);
    }

    public static void ordenarRecursivo(int[] array) {
        printArray(array, "=== INICIO Quick Sort Recursivo ===");
        ordenar(array, 0, array.length - 1);
        printArray(array, "=== FIN Quick Sort Recursivo (ORDENADO) ===");
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        printIndented(izquierda, "→ Llamada: quickSort([" + izquierda + ".." + derecha + "])");

        if (izquierda >= derecha) {
            printIndented(izquierda, "   Caso base: subarray vacío o de 1 elemento → ya ordenado");
            return;
        }

        printIndented(izquierda, "   Pivote seleccionado: array[" + derecha + "] = " + array[derecha]);

        int indicePivote = particionar(array, izquierda, derecha);

        printIndented(izquierda, "   Pivote colocado en posición " + indicePivote 
                               + " → Valor: " + array[indicePivote]);

        printArray(array, "   Array después de particionar:", izquierda);

        ordenar(array, izquierda, indicePivote - 1);
        ordenar(array, indicePivote + 1, derecha);
    }

    private static int particionar(int[] array, int izquierda, int derecha) {
        int pivote = array[derecha];
        int i = izquierda - 1;

        printIndented(izquierda, "     Iniciando partición con pivote = " + pivote);

        for (int j = izquierda; j < derecha; j++) {
            System.out.print("    ".repeat(izquierda + 1));
            System.out.println("Comparando: array[" + j + "]=" + array[j] 
                             + " <= " + pivote + " ?");

            if (array[j] <= pivote) {
                i++;
                if (i != j) {
                    int temporal = array[i];
                    array[i] = array[j];
                    array[j] = temporal;
                    printArray(array, "       → Intercambio realizado (i=" + i + ", j=" + j + "):", izquierda + 1);
                } else {
                    System.out.print("    ".repeat(izquierda + 1));
                    System.out.println("       → Elemento ya en posición correcta");
                }
            } else {
                System.out.print("    ".repeat(izquierda + 1));
                System.out.println("       → Elemento mayor que pivote, se queda a la derecha");
            }
        }

        // Colocar el pivote en su posición final
        int temporal = array[i + 1];
        array[i + 1] = array[derecha];
        array[derecha] = temporal;

        printArray(array, "     → Pivote colocado en posición " + (i + 1) + ":", izquierda + 1);

        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        
        System.out.println("=== PRUEBA QUICK SORT ===\n");
        
        int[] arr1 = array.clone();
        ordenarRecursivo(arr1);
    }
}