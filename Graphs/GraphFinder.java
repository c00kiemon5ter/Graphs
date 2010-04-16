package Graphs;

import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.graph.DirectedSubgraph;

public class GraphFinder {
	private DirectedGraph<String, DefaultEdge> digraph;
	SCCFinder sccf;
	private int sccIndex = 0;
	private int maxdiameter = 0;
	private int greatestSccSize = 0;
	private DirectedSubgraph<String, DefaultEdge> greatestScc = null;

	public GraphFinder(SCCFinder sccf) {
		// find greater SCC
		for (DirectedSubgraph<String, DefaultEdge> subgraph : sccf.getStronglyConnectedSubgraphs())
			if (greatestSccSize < subgraph.edgeSet().size()) {
				greatestSccSize = subgraph.edgeSet().size();
				greatestScc = subgraph;
			}
		// compute greatest SCC's diameter
		for (String source : greatestScc.vertexSet())
			for (String target : greatestScc.vertexSet()) {
				if (source.equals(target)) {
					continue;
				}
				int diameter = DijkstraShortestPath.findPathBetween(
					greatestScc, source, target).size();
				if (maxdiameter < diameter) {
					maxdiameter = diameter;
				}
			}
		sccIndex = sccf.getStronglyConnectedSubgraphs().indexOf(greatestScc);
	}

	public DirectedSubgraph<String, DefaultEdge> getGreatestScc() {
		return greatestScc;
	}

	public int getGreatestSccSize() {
		return greatestSccSize;
	}

	public int getGreatestSccIndex() {
		return sccIndex;
	}

	public int getGreatestDiameter() {
		return maxdiameter;
	}

}
