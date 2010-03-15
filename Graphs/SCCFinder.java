package Graphs;

import java.util.List;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.StrongConnectivityInspector;

/**
 *
 * @author  Ivan Kanakarakis
 */
public class SCCFinder {
	private DirectedGraph<String, DefaultEdge> directedGraph;
	private StrongConnectivityInspector sci;

	public SCCFinder(DirectedGraph<String, DefaultEdge> directedGraph) {
		this.directedGraph = directedGraph;
		sci = new StrongConnectivityInspector(this.directedGraph);
	}

	public List findStringlyConnectedSubgraphs() {
		return sci.stronglyConnectedSubgraphs();
	}

}
