
import java.util.*;

public class InsertionSort {

    static Scanner in = new Scanner(System.in);
    static boolean takeCustomInputsFlag = false;
    static int lenOfArr;
    // static int[] arr = { 7, 5, 6, 7, 2, 3, 4, 6 };
    static int[] arr = { 7, 5, 6, 7, 2, 3, 4, 6, 2 };
    // answer =

    public static void main(String[] args) {
        System.out.print("Want to give custom inputs? (0/1/2) : ");
        int customInputsFlag = in.nextInt();
        if (customInputsFlag == 0) {
            execInsertionSort(arr);
        } else if (customInputsFlag == 1) {
            arr = takeInputs();
            execInsertionSort(arr);
        } else if (customInputsFlag == 2) {
            PH.skipPrinting();
            int numOfTests = 10000;
            for (int i = 0; i < numOfTests; i++) {
                int[] a = AH.getRandomArray(100);
                a = execInsertionSort(a);
                boolean checkSorted = AH.testForDescSorted(a);
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

    public static int[] execInsertionSort(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            int temp = ar[i];
            int j = 0;
            while (i - j - 1 >= 0 && ar[i - j - 1] < temp) {
                ar[i - j] = ar[i - j - 1];
                j++;
            }
            ar[i - j] = temp;
            PH.printArrAndHighlight(ar, new Integer[] { i, i - j });
        }
        return ar;
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
