import java.util.Arrays;

public class MergeSort {

    private static void printArray(int[] array, String mensaje) {
        System.out.println(mensaje + " " + Arrays.toString(array));
    }

    private static void printIndented(int nivel, String mensaje) {
        System.out.print("    ".repeat(nivel));
        System.out.println(mensaje);
    }

    public static void ordenarRecursivo(int[] array) {
        printArray(array, "=== INICIO Merge Sort Recursivo ===");
        ordenar(array, 0, array.length - 1);
        printArray(array, "=== FIN Merge Sort Recursivo (ORDENADO) ===");
    }

    public static void ordenar(int[] array, int izquierda, int derecha) {
        printIndented(izquierda, "→ Llamada: ordenar([" + izquierda + ".." + derecha + "])");

        if (izquierda >= derecha) {
            printIndented(izquierda, "   Caso base alcanzado (izquierda >= derecha)");
            return;
        }

        int medio = izquierda + (derecha - izquierda) / 2;
        printIndented(izquierda, "   Dividiendo en [" + izquierda + ".." + medio + "] y [" + (medio + 1) + ".." + derecha + "]");

        ordenar(array, izquierda, medio);
        ordenar(array, medio + 1, derecha);

        printIndented(izquierda, "   → Procediendo a fusionar [" + izquierda + ".." + derecha + "]");
        fusionar(array, izquierda, medio, derecha);
    }

    private static void fusionar(int[] array, int izquierda, int medio, int derecha) {
        int tamanoIzquierda = medio - izquierda + 1;
        int tamanoDerecha = derecha - medio;

        int[] mitadIzquierda = new int[tamanoIzquierda];
        int[] mitadDerecha = new int[tamanoDerecha];

        // Copiar datos a arrays temporales
        for (int i = 0; i < tamanoIzquierda; i++) {
            mitadIzquierda[i] = array[izquierda + i];
        }
        for (int i = 0; i < tamanoDerecha; i++) {
            mitadDerecha[i] = array[medio + 1 + i];
        }

        printIndented(izquierda, "     Arrays temporales creados → L:" 
                + Arrays.toString(mitadIzquierda) + "  R:" + Arrays.toString(mitadDerecha));

        int i = 0, j = 0, k = izquierda;

        while (i < tamanoIzquierda && j < tamanoDerecha) {
            System.out.print("    ".repeat(izquierda + 1));
            System.out.println("Comparando: " + mitadIzquierda[i] + " <= " + mitadDerecha[j] + " ?");

            if (mitadIzquierda[i] <= mitadDerecha[j]) {
                array[k] = mitadIzquierda[i];
                i++;
                System.out.print("    ".repeat(izquierda + 1));
                System.out.println("→ Tomado de izquierda");
            } else {
                array[k] = mitadDerecha[j];
                j++;
                System.out.print("    ".repeat(izquierda + 1));
                System.out.println("→ Tomado de derecha");
            }
            printArray(array, "       Array actual:", izquierda + 1);
            k++;
        }

        // Copiar elementos restantes de mitadIzquierda
        while (i < tamanoIzquierda) {
            array[k] = mitadIzquierda[i];
            System.out.print("    ".repeat(izquierda + 1));
            System.out.println("→ Copiando resto de izquierda en pos " + k);
            printArray(array, "       Array actual:", izquierda + 1);
            i++;
            k++;
        }

        // Copiar elementos restantes de mitadDerecha
        while (j < tamanoDerecha) {
            array[k] = mitadDerecha[j];
            System.out.print("    ".repeat(izquierda + 1));
            System.out.println("→ Copiando resto de derecha en pos " + k);
            printArray(array, "       Array actual:", izquierda + 1);
            j++;
            k++;
        }

        printIndented(izquierda, "   Fusion completada → subarray [" + izquierda + ".." + derecha + "] ordenado");
    }

    public static void ordenarIterativo(int[] array) {
        printArray(array, "=== INICIO Merge Sort Iterativo (Bottom-Up) ===");

        int n = array.length;

        for (int tamano = 1; tamano < n; tamano *= 2) {
            System.out.println("\n=== Nueva pasada: Subarrays de tamaño " + tamano + " ===");

            for (int izquierda = 0; izquierda < n - tamano; izquierda += 2 * tamano) {
                int medio = izquierda + tamano - 1;
                int derecha = Math.min(izquierda + 2 * tamano - 1, n - 1);

                System.out.println("   Fusionando [" + izquierda + ".." + medio + "] con [" 
                                 + (medio + 1) + ".." + derecha + "]");
                
                fusionar(array, izquierda, medio, derecha);
            }
        }

        printArray(array, "=== FIN Merge Sort Iterativo (ORDENADO) ===");
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        
        System.out.println("=== PRUEBA MERGE SORT ===\n");

        int[] arr1 = array.clone();
        ordenarRecursivo(arr1);

        System.out.println("\n" + "=".repeat(90) + "\n");

        int[] arr2 = array.clone();
        ordenarIterativo(arr2);
    }
}