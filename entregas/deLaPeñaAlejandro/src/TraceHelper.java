public class TraceHelper {
    public static void printArray(int[] array, String mensaje) {
        System.out.println(mensaje + " " + java.util.Arrays.toString(array));
    }

    public static void printArray(int[] array, String mensaje, int nivel) {
        System.out.print("    ".repeat(nivel));
        System.out.println(mensaje + " " + java.util.Arrays.toString(array));
    }
}