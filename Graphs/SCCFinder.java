package Graphs;

import java.util.List;
import java.util.Set;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.StrongConnectivityInspector;
import org.jgrapht.graph.DirectedSubgraph;

/**
 *
 * @author  Ivan Kanakarakis
 */
public class SCCFinder {
	private DirectedGraph<String, DefaultEdge> directedGraph;
	private StrongConnectivityInspector<String, DefaultEdge> sci;
	private List<DirectedSubgraph<String, DefaultEdge>> StronglyConnectedSubgraphs;
	private List<Set<String>> StronglyConnectedSets;
	private int sccSize;
	private int[] sccSizes;

	public SCCFinder(DirectedGraph<String, DefaultEdge> directedGraph) {
		this.directedGraph = directedGraph;
		sci = new StrongConnectivityInspector<String, DefaultEdge>(this.directedGraph);
		StronglyConnectedSubgraphs = sci.stronglyConnectedSubgraphs();
		StronglyConnectedSets = sci.stronglyConnectedSets();
		sccSize = StronglyConnectedSets.size();
		calcSCCSizePerSubgraph();
	}

	public List<DirectedSubgraph<String, DefaultEdge>> findStronglyConnectedSubgraphs() {
		return StronglyConnectedSubgraphs;
	}

	public List<Set<String>> findStronglyConnectedSets() {
		return StronglyConnectedSets;
	}

	public int getSCCSize() {
		return sccSize;
	}

	public int[] getSCCSizePerSubgraph() {
		return sccSizes;
	}

	private void calcSCCSizePerSubgraph() {
		sccSizes = new int[sccSize];
		for (int pos = 0; pos < sccSize; pos++)
			sccSizes[pos] = StronglyConnectedSubgraphs.get(pos).vertexSet().size();
	}

}
