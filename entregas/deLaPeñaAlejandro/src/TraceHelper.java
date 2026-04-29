public class TraceHelper {
    // Para controlar la profundidad de la recursión
    private static int depth = 0;

    public static void indent() {
        for (int i = 0; i < depth; i++) System.out.print("  ");
    }

    public static void enterRecursiveCall(String msg) {
        indent();
        System.out.println("-> Entrando: " + msg);
        depth++;
    }

    public static void exitRecursiveCall(String msg) {
        depth--;
        indent();
        System.out.println("<- Saliendo: " + msg);
    }

    public static String format(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.size; i++) { // Dependiendo de si es array completo o sub-array
            // Implementación simple de print
        }
        return java.util.Arrays.toString(arr);
    }
}