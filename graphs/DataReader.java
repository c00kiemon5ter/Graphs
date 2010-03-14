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

	public DataReader(final String filename) throws FileNotFoundException {
		scan = new Scanner(new BufferedReader(new FileReader(datafile)));
		adjacencyList = new Vector<Node>();
		if (AppDefs.DEBUG) {
			System.out.format("%s: DataReader Object initialized\n",
					  this.getClass().toString());
		}
	}

	public boolean readFile() {
		int greatest = 0;
		while (scan.hasNextInt()) {
			String edge = scan.nextLine();
			if (edge.matches("\\d+\\t\\d+")) {
				String[] vertex = edge.split("\\t");
				int source = Integer.parseInt(vertex[0]);
				int sink = Integer.parseInt(vertex[1]);
				boolean found = false;
				for (Node node : adjacencyList)
					if (node.getNodeName() == source) {
						node.addNode(sink);
						found = true;
						break;
					}
				if (!found) {
					Node newnode = new Node(source);
					newnode.addNode(sink);
					adjacencyList.add(newnode);
				}
				int tmpgreat = source > sink ? source : sink;
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
		return true;
	}

	public Vector<Node> getAdjacencyList() {
		return adjacencyList;
	}

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
			} else {
				System.err.println("Error Reading File");
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("Wrong file! Please try again with different file");
			fnfe.printStackTrace();
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

	private static void printAdjacemcyList(DataReader dr) {
		long startTime = System.currentTimeMillis();
		for (Node node : dr.getAdjacencyList())
			System.out.println(node.toString());
		System.out.println("===> printAdjacemcyList Runtime is: " + (System.currentTimeMillis() - startTime) + "ms");
	}

}
