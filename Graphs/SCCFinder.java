package Graphs;

import java.util.Iterator;
import java.util.List;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.StrongConnectivityInspector;
import org.jgrapht.graph.Subgraph;

/**
 *
 * @author  Ivan Kanakarakis
 */
public class SCCFinder {
	private DirectedGraph<String, DefaultEdge> directedGraph;
	private StrongConnectivityInspector sci;
	private List StronglyConnectedSubgraphs;
	private List StronglyConnectedSets;
	private int sccSize;
	private int[] sccSizes;

	public SCCFinder(DirectedGraph<String, DefaultEdge> directedGraph) {
		this.directedGraph = directedGraph;
		sci = new StrongConnectivityInspector(this.directedGraph);
		StronglyConnectedSubgraphs = sci.stronglyConnectedSubgraphs();
		StronglyConnectedSets = sci.stronglyConnectedSets();
		sccSize = StronglyConnectedSets.size();
		findSCCSizePerSubgraph();
	}

	public List findStronglyConnectedSubgraphs() {
		return StronglyConnectedSubgraphs;
	}

	public List findStronglyConnectedSets() {
		return StronglyConnectedSets;
	}

	public int getSCCSize() {
		return sccSize;
	}

	public int[] getSCCSizePerSubgraph() {
		return sccSizes;
	}

	private void findSCCSizePerSubgraph() {
		sccSizes = new int[sccSize];
		Iterator iter = StronglyConnectedSubgraphs.iterator();
		for (int pos = 0; pos < sccSize; pos++)
			sccSizes[pos] = ((Subgraph) StronglyConnectedSubgraphs.get(pos)).vertexSet().size();
	}

}
