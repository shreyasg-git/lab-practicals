import java.util.*;

// best representation is Adjacency Matrix, but 2nd best is Adjacency List
// comparison can be done later

public class DFS {
    static boolean takeCustomInputsFlag = false;
    static Scanner in = new Scanner(System.in);
    static int numOfNodes;
    static int numOfEdges;
    static int dest;
    static int[][] matrix = {
            { 0, 0, 1, 0, 1 },
            { 0, 0, 1, 1, 1 },
            { 1, 1, 0, 1, 0 },
            { 0, 1, 1, 0, 0 },
            { 1, 1, 0, 0, 0 }
    };
    static boolean[] visited;
    static boolean isFound = false;

    public static void main(String[] args) {
        if (args[0].equals("true")) {
            takeCustomInputsFlag = true;
        } else {
            takeCustomInputsFlag = false;
        }
        if (takeCustomInputsFlag) {
            takeDimensionInputs();
            visited = new boolean[numOfNodes];
            ensureVisited();
            takeGoalStateInput();
            matrix = new int[numOfNodes][numOfNodes];
            takeMatrixInput();
            runDFS(0);
        } else {
            numOfEdges = 7;
            numOfNodes = 5;
            visited = new boolean[numOfNodes];
            ensureVisited();
            dest = 4;
            runDFS(0);
        }
        System.out.print("\nVisited Nodes -> ");
        printArray(visited);
    }

    public static void runDFS(int at) {
        if (isFound) {
            return;
        }
        if (at == dest) {
            isFound = true;
        }
        if (visited[at]) {
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

        System.out.print(at + "-> ");
        for (int i = 0; i < neighborNodes.size(); i++) {
            runDFS(neighborNodes.get(i));
        }
    }

    public static void takeMatrixInput() {
        System.out.println("taking edges input...Enter edges one by one");
        for (int i = 0; i < numOfEdges; i++) {
            System.out.print("Enter start point of Edge " + i + " : ");
            int tempStart = in.nextInt();
            System.out.print("Enter End point of Edge " + i + " : ");
            int tempEnd = in.nextInt();
            matrix[tempStart][tempEnd] = 1;
            matrix[tempEnd][tempStart] = 1;
        }
        System.out.println("taking edges input FINISHED.");
    }

    private static void takeGoalStateInput() {
        System.out.print("Enter the Goal State : ");
        dest = in.nextInt();
    }

    private static void takeDimensionInputs() {
        System.out.print("Enter no. of nodes : ");
        numOfNodes = in.nextInt();
        System.out.print("Enter no. of edges : ");
        numOfEdges = in.nextInt();
    }

    private static void ensureVisited() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
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