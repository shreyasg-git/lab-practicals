import java.util.*;

/**
 * Sorts in Ascending Order
 */
public class BubbleSort {
    static int numOfTests = 1000;
    static Scanner in = new Scanner(System.in);
    static boolean takeCustomInputsFlag = false;
    static int lenOfArr;
    static int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

    public static void main(String[] args) {
        System.out.print("Want to give custom inputs? (0/1/2 - " + numOfTests + "  random tests) : ");
        int customInputsFlag = in.nextInt();
        if (customInputsFlag == 0) {
            execBubble(arr);
        } else if (customInputsFlag == 1) {
            int[] b = AH.takeInputs();
            b = execBubble(b);
            AH.testForAscSorted(b);
        } else if (customInputsFlag == 2) {
            PH.skipPrinting();
            int numOfTests = 1000;
            for (int i = 0; i < numOfTests; i++) {
                int[] a = AH.getRandomArray(100);
                a = execBubble(a);
                boolean checkSorted = AH.testForAscSorted(a);
                if (checkSorted) {
                    System.out.println("TEST " + i + " PASSED");
                } else {
                    System.out.println("TEST " + i + " FAILED");
                }
            }
            PH.revivePrinting();
        } else {
            System.out.println(PH.ANSI_YELLOW + "Invalid Argument" + PH.ANSI_RESET);
        }
    }

    private static int[] execBubble(int[] arr) {
        // int counter = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                } else {
                    PH.printArr(arr);
                }
                // System.out.println(counter);
                // counter++;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int src, int target) {
        int temp = arr[src];
        arr[src] = arr[target];
        arr[target] = temp;
        PH.printArrAndHighlight(arr, new Integer[] { src, target });
    }

    public static int[] takeInputs() {
        System.out.print("Enter the length of given array : ");
        lenOfArr = in.nextInt();
        arr = new int[lenOfArr];
        System.out.println("Please enter the numbers one by one followed by Enter key:");
        for (int i = 0; i < lenOfArr; i++) {
            System.out.print("Enter element at position - " + i + ": ");
            arr[i] = in.nextInt();
        }
        return arr;
    }

}
