package Graph;

import Application.AppDefs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.ListenableDirectedGraph;

public class DataReader {
	private File datafile;
	private Scanner scan;
	private DirectedGraph<String, DefaultEdge> digraph;

	public DataReader(final String filename) throws FileNotFoundException {
		datafile = new File(filename);
		scan = new Scanner(new BufferedReader(new FileReader(datafile)));
		if (AppDefs.DEBUG) {
			System.out.format("%s: DataReader Object initialized\n",
					  this.getClass().toString());
		}
	}

	public DataReader(final File filename) throws FileNotFoundException {
		digraph = new ListenableDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		datafile = filename;
		scan = new Scanner(new BufferedReader(new FileReader(datafile)));
		if (AppDefs.DEBUG) {
			System.out.format("%s: DataReader Object initialized\n",
					  this.getClass().toString());
		}
	}

	public boolean readFile() {//DirectedGraph<String, DefaultEdge> directedGraph) {
		boolean success = true;
		while (scan.hasNextInt()) {
			String[] vertex = scan.nextLine().split("\\s");
			if (vertex.length != 2) {
				System.err.format("%s: Wrong File Format for file: %s\n",
						  this.getClass().toString(), datafile.getName());
				success = false;
			} else {
				digraph.addVertex(vertex[0]);
				digraph.addVertex(vertex[1]);
				digraph.addEdge(vertex[0], vertex[1]);
			}
		}
		scan.close();
		if (AppDefs.DEBUG) {
			System.out.format("%s: Read File Contents: %s\n",
					  this.getClass().toString(), datafile.getName());
		}
		return success;
	}

	public DirectedGraph<String, DefaultEdge> getDigraph() {
		return digraph;
	}

}
