import java.util.*;

class BFS {
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
			{ 1, 0, 1, 0, 0 } };;
	static Queue<Integer> que = new LinkedList<Integer>();
	static boolean[] visitedArr;
	static boolean isFound = false;

	public static void main(String[] args) {
		if (takeCustomInputsFlag) {
			takeDimensionInputs();
			visitedArr = new boolean[numOfNodes];
			ensureVisited();
			takeGoalStateInput();
			matrix = new int[numOfNodes][numOfNodes];
			takeMatrixInput();
			executeBFS(0, goalState);
		} else {

		}

		printArr(matrix);
		executeBFS(0, 4);
	}

	public static void executeBFS(int startNode, int goalState) {
		que.add(0);
		while (!que.isEmpty()) {
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
		}

		printArr(visitedArr);
	}

	private static void ensureVisited() {
		for (int i = 0; i < visitedArr.length; i++) {
			visitedArr[i] = false;
		}
	}

	private static void takeGoalStateInput() {
		System.out.print("Enter the Goal State : ");
		goalState = in.nextInt();
	}

	private static void takeDimensionInputs() {
		System.out.print("Enter no. of nodes : ");
		numOfNodes = in.nextInt();
		System.out.print("Enter no. of edges : ");
		numOfEdges = in.nextInt();
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

	public static void printArr(int[][] arr) {
		System.out.print("[ ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print("\t[ ");
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + ", ");
			}
			System.out.println("], ");
		}
		System.out.println("]");
	}

	public static void printArr(int[] arr) {
		System.out.print("[ ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("]");
	}

	public static void printArr(boolean[] arr) {
		System.out.print("[ ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("]");
	}
}
