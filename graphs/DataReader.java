package graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author	Ivan Kanakarakis
 */
public class DataReader {
	private File datafile;
	private Scanner scan;
	private Vector<Node> adjacencyList;
//	private int[][] adjacencyMatrix;

	public DataReader(final String filename) throws FileNotFoundException {
		datafile = new File(filename);
		scan = new Scanner(new BufferedReader(new FileReader(datafile)));
		adjacencyList = new Vector<Node>();
		if (AppDefs.DEBUG) {
			System.out.format("%s: DataReader Object initialized\n",
					  this.getClass().toString());
		}
	}

	public boolean readFile() {
		//TODO: Fill in the missing nodes?
		int greatest = 0;
		while (scan.hasNextInt()) {
			String line = scan.nextLine();
			if (line.matches("\\d+\\t\\d+")) {
				String[] vertex = line.split("\\t");
				int fromNode = Integer.parseInt(vertex[0]);
				int toNode = Integer.parseInt(vertex[1]);
				boolean found = false;
				for (Node node : adjacencyList)
					if (node.getNodeName() == fromNode) {
						node.addNode(toNode);
						found = true;
						break;
					}
				if (!found) {
					Node newnode = new Node(fromNode);
					newnode.addNode(toNode);
					adjacencyList.add(newnode);
				}
				int tmpgreat = fromNode > toNode ? fromNode : toNode;
				greatest = tmpgreat > greatest ? tmpgreat : greatest;
			} else {
				System.err.format("%s: Wrong File Format for file: %s\n",
						  this.getClass().toString(), datafile.getName());
				return false;
			}
		}
		scan.close();
		if (AppDefs.DEBUG) {
			System.out.format("%s: Read File Contents: %s\n",
					  this.getClass().toString(), datafile.getName());
		}
		adjacencyList.trimToSize();
//		/**
//		 * TODO: Is matrix needed? Condition to create the matrix?
//		 * Adjacency List is created during file scanning so matrix seems redundant.
//		 * The matrix code below and else works, but won't use it till there's some reason to
//		 */
//		 adjacencyMatrix = new int[greatest][greatest];
//		 for (Node node : adjacencyList) {
//		 	int row = node.getNodeName();
//		 	Vector<Integer> connections = node.getConnections();
//		 	row = row == greatest ? 0 : row;
//		 for (int connectedWith = 1; connectedWith <= greatest; connectedWith++) {
//		 		int col = connectedWith == greatest ? 0 : connectedWith;
//		 		if (connections.contains(connectedWith)) {
//		 			adjacencyMatrix[row][col] = 1;
//		 		} else {
//		 			adjacencyMatrix[row][col] = 0;
//		 		}
//		 	}
//		 }
//
//		 if (AppDefs.DEBUG) {
//		 	System.out.format("%s: Filled Matrix\n", this.getClass().toString());
//		 }
		return true;
	}

	public Vector<Node> getAdjacencyList() {
		return adjacencyList;
	}

//	public int[][] getAdjacencyMatrix() {
//		return adjacencyMatrix;
//	}

	/**
	 * Test this class
	 */
	public static void main(String[] args) {
		System.out.println("----------- START OF TEST -----------");
		AppDefs.DEBUG = true;
		long startTime = System.currentTimeMillis();
		try {
			DataReader dr = new DataReader("data/graph1.txt");
			if (readFile(dr)) {
				printAdjacemcyList(dr);
//				printAdjacencyMatrix(dr);
			} else {
				System.err.println("Error Reading File");
			}
		} catch (FileNotFoundException ex) {
			System.err.println("Wrong file! Please try again with different file");
			return;
		}
		System.out.println("------------ END OF TEST ------------");
		System.out.println("===> Test Runtime is: " + (System.currentTimeMillis() - startTime) + "ms");
	}

	private static boolean readFile(DataReader dr) {
		long startTime = System.currentTimeMillis();
		boolean b = dr.readFile();
		System.out.println("===> readFile Runtime is: " + (System.currentTimeMillis() - startTime) + "ms");
		return b;
	}

//	private static void printAdjacencyMatrix(DataReader dr) {
//		long startTime = System.currentTimeMillis();
//		for (int row = 0; row < dr.getAdjacencyMatrix().length; row++) {
//			for (int col = 0; col < dr.getAdjacencyMatrix()[row].length; col++)
//				System.out.print(dr.getAdjacencyMatrix()[row][col]);
//			System.out.println();
//		}
//		System.out.println("===> printAdjacencyMatrix Runtime is: " + (System.currentTimeMillis() - startTime) + "ms");
//	}

	private static void printAdjacemcyList(DataReader dr) {
		long startTime = System.currentTimeMillis();
		for (Node node : dr.getAdjacencyList())
			System.out.println(node.toString());
		System.out.println("===> printAdjacemcyList Runtime is: " + (System.currentTimeMillis() - startTime) + "ms");
	}

}
