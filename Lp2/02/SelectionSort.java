import java.util.*;

class SelectionSort {
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    // Declaring the color
    // Custom declaration
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    static int lenOfArr;
    static int[] arr = { 2, 5, 7, 3, 4, 9, 5 };
    static int[] ARR_FOR_HIGHLIGHTING;

    public static void main(String[] args) {
        execSort();

    }

    public static void execSort() {
        for (int i = 0; i < arr.length; i++) {
            int smallest = arr[i];
            int smallestIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < smallest) {
                    smallest = arr[j];
                    smallestIndex = j;
                }
            }
            swap(i, smallestIndex);

        }
        // printArr(arr);
    }

    public static void swap(int src, int target) {
        int temp = arr[src];
        arr[src] = arr[target];
        arr[target] = temp;
        printArrAndHighlight(arr, new Integer[] { src, target });
        // printArr(arr);
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
}
