package Graphs;

import java.io.FileNotFoundException;
import java.util.List;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.graph.ListenableDirectedGraph;

/**
 *
 * @author  Ivan Kanakarakis
 */
public class TestMain {
	public static void main(String[] args) {
		ListenableDirectedGraph<String, DefaultEdge> directedGraph = new ListenableDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		testDataReader(directedGraph);
		testSCCFind(directedGraph);
	}

	private static void testDataReader(ListenableDirectedGraph<String, DefaultEdge> directedGraph) {
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

	private static void testSCCFind(ListenableDirectedGraph<String, DefaultEdge> directedGraph) {
		// computes all the strongly connected components of the directed graph
		SCCFinder scc = new SCCFinder(directedGraph);
		List stronglyConnectedSubgraphs = scc.findStronglyConnectedSubgraphs();
                //Other Data
                System.out.println("--------Other Data--------");
                System.out.println("SSC number: "+scc.getSCCSize());
                System.out.println("SCC numbers!");
                for(int i=0;i<scc.getSCCSize();i++)
                {
                    System.out.println(i+" SCC number: "+scc.getSCCSizePerSubgraph()[i]);
                }
                System.out.println("Diameter: "+(new GraphFinder(directedGraph)).getGreatestDiameter());
		// prints the strongly connected components
		System.out.println("Strongly connected components:");
		for (int i = 0; i < stronglyConnectedSubgraphs.size(); i++)
			System.out.println(stronglyConnectedSubgraphs.get(i));
		System.out.println();
	}

}
