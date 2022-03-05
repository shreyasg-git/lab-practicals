import java.util.*;
 
// take inputs 
// 	take no. of nodes
// 	take no. of edges
// 	root node
// 	goal node
// 	build adjacency matrix by taking one by one inputs

class BFS {
	static Scanner in= new Scanner(System.in); 
	static int numOfNodes;
	static int numOfEdges;
	static int[][] matrix = {{0, 1, 1, 0, 1}, {1, 0, 1, 1, 0}, {1, 1, 0, 1, 1}, {0, 1, 1, 0, 0}, {1, 0, 1, 0, 0}};
	;
	static Queue<Integer> que = new LinkedList<Integer>();
	static boolean[] visitedArr;
	
	public static void main (String[] args) {
		takeDimensionInputs();
		
		// matrix = new int[numOfNodes][numOfNodes];
		
		visitedArr = new boolean[numOfNodes];

		// just making sure that visited is all false
		for (int i = 0; i < numOfNodes; i++) {
			visitedArr[i] = false;
		}

		// printArr(matrix);
		// takeMatrixInput();
		printArr(matrix);

		executeBFS(0, 4);
		
	}

	public static void executeBFS (int startNode, int goalState) {
		que.add(0);
		while (!que.isEmpty()) {
			int currentTemp = que.remove();
			visitedArr[currentTemp] = true;
			System.out.print(currentTemp + "->");

			// add neighbours
			int[] neighs = matrix[currentTemp].clone();

			for (int i = 0; i < neighs.length; i++) {
				// if(goalState == neighs[i]) {
				// 	break;
				// }
				System.out.print();
				if (!visitedArr[neighs[i]]) {
					que.add(i);
				}	
			}

			// printArr(neighs);		
			

		}
	}
	
	private static void takeDimensionInputs () {
		System.out.print("Enter no. of nodes : ");	
		numOfNodes = in.nextInt();
		System.out.print("Enter no. of edges : ");
		numOfEdges = in.nextInt();
	}
	
	public static void takeMatrixInput() {
		System.out.println("taking edges input...Enter edges one by one");
		for(int i = 0; i<numOfEdges; i++) {
			System.out.print("Enter start point of Edge "+i+" : ");
			int tempStart = in.nextInt();
			System.out.print("Enter End point of Edge "+i+" : ");			
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
}






















