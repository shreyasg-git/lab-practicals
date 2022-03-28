import java.util.*;

public class ShellSort {
    static int numOfTests = 1000;
    static Scanner in = new Scanner(System.in);
    static boolean takeCustomInputsFlag = false;
    static int lenOfArr;
    static int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

    public static void main(String[] args) {
        System.out.print("Want to give custom inputs? (0/1/2 - random 1000 tests) : ");
        int customInputsFlag = in.nextInt();
        if (customInputsFlag == 0) {
            execShellSort(arr);
        } else if (customInputsFlag == 1) {
            arr = takeInputs();
            execShellSort(arr);
        } else if (customInputsFlag == 2) {
            PH.skipPrinting();
            int numOfTests = 1000;
            for (int i = 0; i < numOfTests; i++) {
                int[] a = AH.getRandomArray(100);
                a = execShellSort(a);
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

    public static int[] execShellSort(int[] arr) {
        System.out.println(Arrays.toString(arr));

        // first gap will be n/2 , then n/2 again

        return arr;
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