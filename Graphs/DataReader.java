package Graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.graph.ListenableDirectedGraph;

/**
 *
 * @author	Ivan Kanakarakis
 */
public class DataReader {
	private File datafile;
	private Scanner scan;

	public DataReader(final String filename) throws FileNotFoundException {
		datafile = new File(filename);
		scan = new Scanner(new BufferedReader(new FileReader(datafile)));
		if (AppDefs.DEBUG) {
			System.out.format("%s: DataReader Object initialized\n",
					  this.getClass().toString());
		}
	}

	public DataReader(final File filename) throws FileNotFoundException {
		datafile = filename;
		scan = new Scanner(new BufferedReader(new FileReader(datafile)));
		if (AppDefs.DEBUG) {
			System.out.format("%s: DataReader Object initialized\n",
					  this.getClass().toString());
		}
	}

	public boolean readFile(ListenableDirectedGraph<String, DefaultEdge> directedGraph) {
		while (scan.hasNextInt()) {
			String edge = scan.nextLine();
			String[] vertex = edge.split("\\s");
			if (vertex.length != 2) {
				System.err.format("%s: Wrong File Format for file: %s\n",
						  this.getClass().toString(), datafile.getName());
				return false;
			} else {
				directedGraph.addVertex(vertex[0]);
				directedGraph.addVertex(vertex[1]);
				directedGraph.addEdge(vertex[0], vertex[1]);
			}
		}
		scan.close();
		if (AppDefs.DEBUG) {
			System.out.format("%s: Read File Contents: %s\n",
					  this.getClass().toString(), datafile.getName());
		}
		return true;
	}

}
