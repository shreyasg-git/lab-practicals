import java.util.ArrayList;

// best representation is Adjacency Matrix, but 2nd best is Adjacency List
// comparison can be done later

public class Main {

    static int numOfNodes = 5;
    static int[][] matrix = {
            { 0, 0, 1, 0, 1 },
            { 0, 0, 1, 1, 1 },
            { 1, 1, 0, 1, 0 },
            { 0, 1, 1, 0, 0 },
            { 1, 1, 0, 0, 0 }
    };
    static int dest = 4;
    static boolean isFound = false;
    static boolean[] visited = new boolean[numOfNodes];

    public static void main(String[] args) {
        // just for ensuring that all the elements are false already.
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        // printArray(visited);
        DFS(0);
    }

    public static void DFS(int at) {
        if (isFound) {
            return;
        }
        // System.out.println("have reached - " + at);
        if (at == dest) {
            isFound = true;
        }
        if (visited[at]) {
            // System.out.println("reached " + at + " already isliye me out hu");
            return;
        }
        visited[at] = true;

        // find neighbors
        ArrayList<Integer> neighborNodes = new ArrayList<Integer>();
        for (int i = 0; i < matrix[at].length; i++) {
            if (matrix[at][i] == 1) {

                neighborNodes.add(i);
            }
        }
        if (at == 3) {
            printArray(neighborNodes);
        }
        System.out.print(at + "-> ");
        for (int i = 0; i < neighborNodes.size(); i++) {
            DFS(neighborNodes.get(i));
        }
    }

    public static void printArray(boolean[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }

    public static void printArray(ArrayList<Integer> arr) {
        arr.forEach((n) -> System.out.print(n));
    }

    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }

    public static void printArray(int[][] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println("], ");
        }
        System.out.println("]");
    }

}