package graphs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.StrongConnectivityInspector;
import org.jgrapht.graph.DefaultDirectedGraph;

/**
 *
 * @author	Ivan Kanakarakis
 */
public class Main {
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//TODO: change debug status via main's args
//		AppDefs.DEBUG = true;
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				new MainWindow().setVisible(true);
//			}//run
//
//		});
		test();
	}

	private static void test() {
		DirectedGraph<String, DefaultEdge> directedGraph = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
//		directedGraph.addVertex("a");
//		directedGraph.addVertex("b");
//		directedGraph.addVertex("c");
//		directedGraph.addVertex("d");
//		directedGraph.addVertex("e");
//		directedGraph.addVertex("f");
//		directedGraph.addVertex("g");
//		directedGraph.addVertex("h");
//		directedGraph.addVertex("i");
//		directedGraph.addEdge("a", "b");
//		directedGraph.addEdge("b", "d");
//		directedGraph.addEdge("d", "c");
//		directedGraph.addEdge("c", "a");
//		directedGraph.addEdge("e", "d");
//		directedGraph.addEdge("e", "f");
//		directedGraph.addEdge("f", "g");
//		directedGraph.addEdge("g", "e");
//		directedGraph.addEdge("h", "e");
//		directedGraph.addEdge("i", "h");
		try {
			Scanner scan = new Scanner(new BufferedReader(new FileReader("data/graph1.txt")));
			while (scan.hasNextInt()) {
				String edge = scan.nextLine();
				if (edge.matches("\\d+\\s\\d+")) {
					String[] vertex = edge.split("\\s");
					directedGraph.addVertex(vertex[0]);
					directedGraph.addVertex(vertex[1]);
					directedGraph.addEdge(vertex[0], vertex[1]);
				} else {
					System.err.format("Wrong File Format for file\n");
					return;
				}
			}
			scan.close();
		} catch (FileNotFoundException fnfe) {
			System.err.println("Wrong file! Please try again with different file");
			fnfe.printStackTrace();
			return;
		}

		// computes all the strongly connected components of the directed graph
		StrongConnectivityInspector sci = new StrongConnectivityInspector(directedGraph);
		List stronglyConnectedSubgraphs = sci.stronglyConnectedSubgraphs();

		// prints the strongly connected components
		System.out.println("Strongly connected components:");
		for (int i = 0; i < stronglyConnectedSubgraphs.size(); i++)
			System.out.println(stronglyConnectedSubgraphs.get(i));
		System.out.println();

//		// Prints the shortest path from vertex i to vertex c. This certainly
//		// exists for our particular directed graph.
//		System.out.println("Shortest path from i to c:");
//		List path = DijkstraShortestPath.findPathBetween(directedGraph, "i", "c");
//		System.out.println(path + "\n");
//
//		// Prints the shortest path from vertex c to vertex i. This path does
//		// NOT exist for our particular directed graph. Hence the path is
//		// empty and the variable "path" must be null.
//		System.out.println("Shortest path from c to i:");
//		path = DijkstraShortestPath.findPathBetween(directedGraph, "c", "i");
//		System.out.println(path);
	}

}
