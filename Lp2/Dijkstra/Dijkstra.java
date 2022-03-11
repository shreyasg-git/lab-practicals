import java.util.*;

public class Dijkstra {
    private static class KeyVal implements Comparable {
        private int node;
        private int distance;
        private int viaNode;

        KeyVal(int n, int d) {
            node = n;
            distance = d;
        }

        Integer getDistance() {
            return this.distance;
        }

        Integer getViaNode() {
            return this.viaNode;
        }

        Integer getNode() {
            return this.node;
        }

        @Override
        public int compareTo(Object o) {
            KeyVal kv = (KeyVal) o;
            return this.getDistance().compareTo(kv.getDistance());
        }

        @Override
        public String toString() {
            String str = '{' + getNode().toString() + "," + getDistance().toString() + ", " + getViaNode().toString()
                    + '}';
            return str;
        }
    }

    static PriorityQueue<KeyVal> priQue = new PriorityQueue<>();
    static int[] distances = { -1, -1, -1, -1, -1 }; // -1 = Infinity
    static int numOfNodes = 7;
    static int initialState = 0;
    static int goalState = 6;
    static boolean[] visited = { false, false, false, false, false, false, false };

    static int[][] matrix = {
            { 0, 0, 1, 2, 0, 0, 0 },
            { 0, 0, 2, 0, 0, 3, 0 },
            { 1, 2, 0, 1, 3, 0, 0 },
            { 2, 0, 1, 0, 0, 0, 1 },
            { 0, 0, 3, 0, 0, 2, 0 },
            { 0, 3, 0, 0, 2, 0, 1 },
            { 0, 0, 0, 1, 0, 1, 0 } };

    static public void main(String[] args) {
        execDijkstra(initialState, goalState);
    }

    static private void execDijkstra(int start, int goal) {
        distances[start] = 0;
        priQue.add(new KeyVal(0, 0));

        while (!priQue.isEmpty()) {
            KeyVal current = priQue.remove();
            visited[current.node] = true;

            // get neighbours
            for (int i = 0; i < matrix[current.node].length; i++) {
                if (matrix[current.node][i] >= 1) {
                    priQue.add(new KeyVal(i, matrix[current.node][i]));
                }

            }
        }

    }
}
