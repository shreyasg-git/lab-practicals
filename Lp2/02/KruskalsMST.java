import java.util.*;

// Sort all the edges by weight
// start from leawst weight
class KruskalMST {
    static Scanner in = new Scanner(System.in);
    static int numOfNodes;
    static int numOfEdges;
    static int dest;
    static int[][] matrix = {
            /* 0 */{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            /* 1 */{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            /* 2 */{ 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            /* 3 */{ 0, 0, 7, 0, 3, 14, 0, 0, 0 },
            /* 4 */{ 0, 0, 0, 3, 0, 10, 0, 0, 0 },
            /* 5 */{ 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            /* 6 */{ 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            /* 7 */{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            /* 8 */{ 0, 0, 2, 0, 0, 0, 6, 7, 0 }
    };

    static int[][] ansMST = new int[9][9];

    // DFS implementation for cycle detection

    public static void main(String[] args) {

    }

    public static void checkForCycle(int[][] tree, int node1, int node2) {
        boolean[] visited = new boolean[tree.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        boolean isConnectedAlready = checkUsingDFS(visited);

    }

    private static boolean checkUsingDFS(boolean[] vis) {
        
        vis[]
    }
}
