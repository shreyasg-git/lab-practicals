import java.util.*;

// Sort all the edges by weight
// start from leawst weight
class KruskalsMST {
    static Scanner in = new Scanner(System.in);
    static int numOfNodes;
    static int numOfEdges;
    static int dest;
    static int[][] matrix = {
            /* ______0__1__2__3__4__5__6__7__8 */
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

    static class Edge implements Comparable<Edge> {
        int node1;
        int node2;
        int weight;

        public Edge(int n1, int n2, int wt) {
            this.node1 = n1;
            this.node2 = n2;
            this.weight = wt;
        }

        @Override
        public String toString() {
            return "{" + node1 + ", " + node2 + ", " + weight + "}";
        }

        @Override
        public int compareTo(Edge that) {
            if (that == this) {
                return 0;
            } else if (!(that instanceof Edge)) {
                throw new IllegalArgumentException("Edge Type Expected");
            }
            // only because we want to sort it in increasing order... not the right way to
            // achieve that but it works !
            // right way - Collections.sort(listOfEdges, Collections.reverseOrder());
            return this.weight - that.weight;
        }
    }

    static ArrayList<Edge> listOfEdges = new ArrayList<Edge>();

    public static void main(String[] args) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                if (matrix[i][j] >= 1) {
                    listOfEdges.add(new Edge(i, j, matrix[i][j]));
                }
            }
        }

        listOfEdges.sort(null);

        for (Edge e : listOfEdges) {
            if (!checkForCycle(ansMST, e.node1, e.node2)) {
                ansMST[e.node1][e.node2] = e.weight;
                ansMST[e.node2][e.node1] = e.weight;
            }
        }

        System.out.println(listOfEdges.toString());
        System.out.println(Arrays.deepToString(ansMST));

    }

    public static boolean checkForCycle(int[][] tree, int node1, int node2) {
        boolean[] visited = new boolean[tree.length];
        int currentNode = node1;
        int destination = node2;
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        boolean isConnectedAlready = checkUsingDFS(tree, visited, currentNode, destination);
        return isConnectedAlready;
    }

    private static boolean checkUsingDFS(int[][] tree, boolean[] vis, int crnt, int dest) {
        vis[crnt] = true;

        boolean isConnected = false;
        // System.out.println("current is " + crnt);
        if (vis[dest] == true || crnt == dest) {
            return true;
        }

        for (int i = 0; i < tree[crnt].length; i++) {
            if (tree[crnt][i] >= 1 && !vis[i]) {
                isConnected = checkUsingDFS(tree, vis, i, dest);
            }
        }
        return isConnected;
    }
}
