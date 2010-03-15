package Graphs;

import java.io.FileNotFoundException;
import java.util.List;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;

/**
 *
 * @author  Ivan Kanakarakis
 */
public class TestMain {
	public static void main(String[] args) {
		DirectedGraph<String, DefaultEdge> directedGraph = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		testDataReader(directedGraph);
		testSCCFind(directedGraph);
	}

	private static void testDataReader(DirectedGraph<String, DefaultEdge> directedGraph) {
		// read file contents
		try {
			DataReader dr = new DataReader("data/graph1.txt");
			if (dr.readFile(directedGraph)) {
				System.out.println("Read File - Graph is ready");
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("Wrong file! Please try again with different file");
			fnfe.printStackTrace();
			return;
		}
	}

	private static void testSCCFind(DirectedGraph<String, DefaultEdge> directedGraph) {
		// computes all the strongly connected components of the directed graph
		SCCFinder scc = new SCCFinder(directedGraph);
		List stronglyConnectedSubgraphs = scc.findStringlyConnectedSubgraphs();
		// prints the strongly connected components
		System.out.println("Strongly connected components:");
		for (int i = 0; i < stronglyConnectedSubgraphs.size(); i++)
			System.out.println(stronglyConnectedSubgraphs.get(i));
		System.out.println();
	}

}
