package Algos;

import Graph.Node;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.alg.StrongConnectivityInspector;
import org.jgrapht.graph.DirectedSubgraph;
import org.jgrapht.graph.ListenableDirectedGraph;

public class SccFinder {
	private List<DirectedSubgraph<Node, DefaultEdge>> StronglyConnectedSubgraphs;
	private List<Set<Node>> StronglyConnectedSets;
	private int sccSize;
	private int[] sccSizes;

	public SccFinder(ListenableDirectedGraph<Node, DefaultEdge> directedGraph) {
		StrongConnectivityInspector<Node, DefaultEdge> sci = new StrongConnectivityInspector<Node, DefaultEdge>(directedGraph);
		StronglyConnectedSubgraphs = sci.stronglyConnectedSubgraphs();
		StronglyConnectedSets = sci.stronglyConnectedSets();
		calcSCCSizePerSubgraph();
	}

	public List<DirectedSubgraph<Node, DefaultEdge>> getStronglyConnectedSubgraphs() {
		return Collections.unmodifiableList(StronglyConnectedSubgraphs);
	}

	public List<Set<Node>> getStronglyConnectedSets() {
		return Collections.unmodifiableList(StronglyConnectedSets);
	}

	public int getSCCSize() {
		return sccSize;
	}

	public int[] getSCCSizePerSubgraph() {
		return sccSizes;
	}

	private void calcSCCSizePerSubgraph() {
		sccSize = StronglyConnectedSets.size();
		sccSizes = new int[sccSize];
		for (int pos = 0; pos < sccSize; pos++) {
			sccSizes[pos] = StronglyConnectedSubgraphs.get(pos).vertexSet().size();
		}
//			// sizes as in edge count
//			sccSizes[pos] = StronglyConnectedSubgraphs.get(pos).edgeSet().size();
	}

}
