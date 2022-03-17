import java.util.*;

public class Playground {
    public static void main(String[] args) {
        int[] arr = new int[] { 4, 5, 6 };
        changeArr(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void changeArr(int[] ar) {
        ar[0] = 2;
    }
}
