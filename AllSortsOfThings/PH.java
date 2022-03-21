import java.util.*;

/**
 * Printing Helper Class
 */
public class PH {
    private static boolean _skipPrinting = false;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static String printArr(int[] arr) {
        if (_skipPrinting) {
            return "";
        }
        System.out.println(Arrays.toString(arr));
        return Arrays.toString(arr);
    }

    public static void skipPrinting() {
        _skipPrinting = true;
    }

    public static void revivePrinting() {
        _skipPrinting = false;
    }

    public static void printArrAndHighlight(int[] arr, Integer[] highlightIndices) {
        if (_skipPrinting) {
            return;
        }
        List<Integer> highlight = Arrays.asList(highlightIndices.clone());
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (highlight.contains(i)) {
                if (i == arr.length - 1) {
                    System.out.print(ANSI_RED + arr[i] + ANSI_RESET);
                } else {
                    System.out.print(ANSI_RED + arr[i] + ANSI_RESET + ", ");
                }
            } else {
                if (i == arr.length - 1) {
                    System.out.print(arr[i]);
                } else {
                    System.out.print(arr[i] + ", ");
                }
            }
        }
        System.out.println("]");
    }
}