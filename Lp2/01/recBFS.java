import java.util.*;

class recBFS {
	static boolean takeCustomInputsFlag = false;
	static Scanner in = new Scanner(System.in);
	static int numOfNodes;
	static int numOfEdges;
	static int goalState;
	static int[][] matrix = {
			{ 0, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0 },
			{ 1, 1, 0, 1, 1 },
			{ 0, 1, 1, 0, 0 },
			{ 1, 0, 1, 0, 0 } };
	static Queue<Integer> que = new LinkedList<Integer>();
	static boolean[] visitedArr = { false, false, false, false, false };
	static boolean isFound = false;

	public static void main(String[] args) {
		que.add(0);
		execBFS();
		printArr(visitedArr);
	}

	public static void execBFS() {
		System.out.println(que);
		int currentTemp = que.remove();
		visitedArr[currentTemp] = true;
		System.out.print(currentTemp + "->");
		ArrayList<Integer> neighs = new ArrayList<Integer>(0);

		for (int i = 0; i < matrix[currentTemp].length; i++) {
			if (matrix[currentTemp][i] == 1) {
				neighs.add(i);
			}
		}

		for (int i = 0; i < neighs.size(); i++) {
			if (!visitedArr[neighs.get(i)]) {
				que.add(neighs.get(i));
			}
		}

		if (!que.isEmpty()) {
			execBFS();
		}
	}

	public static void printArr(boolean[] arr) {
		System.out.print("[ ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("]");
	}

}
