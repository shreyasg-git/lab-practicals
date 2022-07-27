import java.util.*;

public class SelectionSort {

    static Scanner in = new Scanner(System.in);
    static boolean takeCustomInputsFlag = false;
    static int lenOfArr;
    static int[] arr = { 7, 5, 6, 7, 2, 3, 4, 6 };

    public static void main(String[] args) {
        System.out.print("Want to give custom inputs? (0/1/2 - random 1000 tests) : ");
        int customInputsFlag = in.nextInt();
        if (customInputsFlag == 0) {
            execSelectionSort(arr, false);
        } else if (customInputsFlag == 1) {
            arr = takeInputs();
            execSelectionSort(arr);
        } else if (customInputsFlag == 2) {
            PH.skipPrinting();
            int numOfTests = 1000;
            for (int i = 0; i < numOfTests; i++) {
                int[] a = AH.getRandomArray(100);
                a = execSelectionSort(a);
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

    public static int[] execSelectionSort(int[] ar, boolean reverse) {
        PH.printArr(ar);
        for (int i = 0; i < ar.length; i++) {
            int swapIndex = i;
            for (int j = i + 1; j < ar.length; j++) {
                if (reverse) {
                    if (ar[j] < ar[swapIndex]) {
                        swapIndex = j;
                    }
                } else {
                    if (ar[j] > ar[swapIndex]) {
                        swapIndex = j;
                    }
                }
            }
            swap(ar, i, swapIndex);
        }
        return ar;
    }

    public static int[] execSelectionSort(int[] ar) {
        PH.printArr(ar);
        for (int i = 0; i < ar.length - 1; i++) {
            int swapIndex = i;
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[j] > ar[swapIndex]) {
                    swapIndex = j;
                }
            }
            swap(ar, i, swapIndex);
        }
        return ar;
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
