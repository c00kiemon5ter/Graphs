
package IO.file;

import Graph.Node;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultDirectedGraph;

public class DataReader {
	private File datafile;
	private Scanner scan;
	private DirectedGraph<Node, DefaultEdge> graph;

	public DataReader(final String filename) throws FileNotFoundException {
		this(new File(filename));
	}

	public DataReader(final File file) throws FileNotFoundException {
		datafile = file;
		scan = new Scanner(new BufferedReader(new FileReader(datafile)));
		this.graph = new DefaultDirectedGraph<Node, DefaultEdge>(DefaultEdge.class);
		//if (AppDefs.isDEBUG()) {
		//	System.out.format("%s: DataReader Object initialized\n",
		//			  this.getClass().toString());
		//}
	}

	public boolean readFile() {
		boolean success = true;
		while (scan.hasNextInt()) {
			String[] vertex = scan.nextLine().split("\\s");
			// 2 elements means unweighted graph, 3rd element is weight
			if (vertex.length != 2) {
				//System.err.format("%s: Wrong File Format for file: %s\n",
				//		  this.getClass().toString(), datafile.getName());
				success = false;
				break;
			} else {
				Node source = new Node(vertex[0]);
				Node target = new Node(vertex[1]);
				graph.addVertex(source);
				graph.addVertex(target);
				graph.addEdge(source, target);
			}
		}
		scan.close();
		//if (AppDefs.isDEBUG()) {
		//	System.out.format("%s: Read File Contents: %s\n",
		//			  this.getClass().toString(), datafile.getName());
		//}
		return success;
	}

	public DirectedGraph<Node, DefaultEdge> getDirectedGraph() {
		return graph;
	}

}
