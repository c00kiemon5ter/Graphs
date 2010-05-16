
package IO.file;

import Graph.Node;
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
	private DirectedGraph<Node, DefaultEdge> digraph;

	public DataReader(final String filename) throws FileNotFoundException {
		this(new File(filename));
		//if (AppDefs.isDEBUG()) {
		//	System.out.format("%s: DataReader Object initialized\n",
		//			  this.getClass().toString());
		//}
	}

	public DataReader(final File filename) throws FileNotFoundException {
		datafile = filename;
		digraph = new ListenableDirectedGraph<Node, DefaultEdge>(DefaultEdge.class);
		scan = new Scanner(new BufferedReader(new FileReader(datafile)));
		//if (AppDefs.isDEBUG()) {
		//	System.out.format("%s: DataReader Object initialized\n",
		//			  this.getClass().toString());
		//}
	}

	public boolean readFile() {
		//DirectedGraph<String, DefaultEdge> directedGraph) {
		boolean success = true;
		while (scan.hasNextInt()) {
			String[] vertex = scan.nextLine().split("\\s");
			if (vertex.length != 2) {
				//System.err.format("%s: Wrong File Format for file: %s\n",
				//		  this.getClass().toString(), datafile.getName());
				success = false;
			} else {
				Node source = new Node(vertex[0]);
				Node target = new Node(vertex[1]);
				digraph.addVertex(source);
				digraph.addVertex(target);
				digraph.addEdge(source, target);
			}
		}
		scan.close();
		//if (AppDefs.isDEBUG()) {
		//	System.out.format("%s: Read File Contents: %s\n",
		//			  this.getClass().toString(), datafile.getName());
		//}
		return success;
	}

	public DirectedGraph<Node, DefaultEdge> getDigraph() {
		return digraph;
	}

}
