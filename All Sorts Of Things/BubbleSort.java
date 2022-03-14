import java.util.*;

public class BubbleSort {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    static Scanner in = new Scanner(System.in);
    static boolean takeCustomInputsFlag = false;
    static int lenOfArr;
    static int[] arr = { 2, 5, 7, 3, 4, 9, 5 };

    public static void main(String[] args) {
        execBubble();
    }

    private static void execBubble() {
        int counter = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                } else {
                    printArr(arr);
                }
                System.out.println(counter);
                counter++;
            }
        }
    }

    public static void swap(int src, int target) {
        int temp = arr[src];
        arr[src] = arr[target];
        arr[target] = temp;
        printArrAndHighlight(arr, new Integer[] { src, target });
    }

    public static void printArrAndHighlight(int[] arr, Integer[] highlightIndices) {
        List<Integer> highlight = Arrays.asList(highlightIndices.clone());
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            if (highlight.contains(i)) {
                System.out.print(ANSI_RED + arr[i] + ANSI_RESET + ", ");
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }

    public static void printArr(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }
}
