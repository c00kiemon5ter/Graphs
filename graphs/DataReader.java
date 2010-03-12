package graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Ivan Kanakarakis
 */
public class DataReader {
	private File datafile;
	private Scanner scan;
	private Vector<Node> nodes;

	public DataReader(final String filename) {
		datafile = new File(filename);
		nodes = new Vector<Node>();
	}

	public void readFile() throws FileNotFoundException {
		//TODO: add missing nodes
		scan = new Scanner(new BufferedReader(new FileReader(datafile)));
		Vector<String> connectedTo = new Vector<String>();
		Vector<String> lookupnodes = new Vector<String>();
		String nodename = "";
		boolean firstCol = true;
		while (scan.hasNext()) {
			String current = scan.next();
			if (nodename.isEmpty()) {
				nodename = current;
			} else if (!firstCol) {
				connectedTo.add(current);
			} else if (!nodename.equals(current)) {
				if (!lookupnodes.contains(nodename)) {
					nodes.add(new Node(nodename, connectedTo));
					lookupnodes.add(nodename);
				} else {
					for (Node node : nodes)
						if (node.getName().equals(nodename)) {
							node.addNodes(connectedTo);
						}
				}
				connectedTo.clear();
				nodename = current;
			}
			firstCol = !firstCol;
		}
		scan.close();
	}

	public Vector<Node> getNodes() {
		return nodes;
	}

	public void setDataFile(String file) {
		this.datafile = new File(file);
	}

	public static void main(String[] args) {
		try {
			DataReader dr = new DataReader("data/graph1.txt");
			dr.readFile();
			System.out.println(dr.getNodes().toString());
		} catch (FileNotFoundException ex) {
			System.err.println("Ooops! Something went wrong");
		}
	}

}
