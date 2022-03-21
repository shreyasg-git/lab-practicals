import java.util.*;

/**
 * Arrays Helper Class
 */
public class AH {
    static Scanner in = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static Random rd = new Random();

    public static boolean testForDescSorted(int[] arr) {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                isSorted = false;
                System.out.println(ANSI_RED + Arrays.toString(arr) + ANSI_RESET);
                break;
            }
        }
        return isSorted;
    }

    public static boolean testForAscSorted(int[] arr) {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isSorted = false;
                System.out.println(ANSI_RED + Arrays.toString(arr) + ANSI_RESET);
                break;
            }
        }
        if (!isSorted) {
            System.out.println(PH.ANSI_RED + "Test Failed For - " + PH.printArr(arr) + PH.ANSI_RESET);
        }
        return isSorted;
    }

    public static int[] getRandomArray(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(200);
        }
        return arr;
    }

    public static int[] getRandomArray(int len, int upperBound) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(upperBound);
        }
        return arr;
    }

    public static int[] takeInputs() {
        System.out.print("Enter the length of given array : ");
        int lenOfArr = in.nextInt();
        int[] arr = new int[lenOfArr];
        System.out.println("Please enter the numbers one by one followed by Enter key:");
        for (int i = 0; i < lenOfArr; i++) {
            System.out.print("Enter element at position - " + i + ": ");
            arr[i] = in.nextInt();
        }
        return arr;
    }
}
