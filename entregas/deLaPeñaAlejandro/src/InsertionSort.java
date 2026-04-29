import java.util.Arrays;

public class OrdenaciónIterativa {

    private static void printArray(int[] array, String mensaje) {
        System.out.println(mensaje + " " + Arrays.toString(array));
    }

    private static void printIndented(int nivel, String mensaje) {
        System.out.print("    ".repeat(nivel));
        System.out.println(mensaje);
    }

    public static void ordenarIterativo(int[] array) {
        printArray(array, "=== INICIO Insertion Sort Iterativo ===");

        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;

            printArray(array, "   Pasada i=" + i + " → Elemento a insertar:", 1);
            System.out.println("      actual = " + actual);

            while (j >= 0 && array[j] > actual) {
                System.out.println("      Comparación: array[" + j + "] = " + array[j] 
                                 + " > " + actual + " → true");
                
                array[j + 1] = array[j];
                j--;
                
                printArray(array, "         → Desplazamiento realizado:", 2);
            }

            if (j == i - 1) {
                System.out.println("      No se necesita mover (ya está en posición correcta)");
            } else {
                System.out.println("      Insertando " + actual + " en posición " + (j + 1));
            }

            array[j + 1] = actual;
            printArray(array, "   Array después de la pasada " + i + ":", 1);
        }

        printArray(array, "=== FIN Insertion Sort Iterativo (ORDENADO) ===");
    }
}