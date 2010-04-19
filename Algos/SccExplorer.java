package Algos;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.graph.DirectedSubgraph;

public class SccExplorer {
	private int sccIndex = 0;
	private int maxDiameter = 0;
	private int greatestSccSize = 0;
	private DirectedSubgraph<String, DefaultEdge> greatestScc = null;

	public SccExplorer(SccFinder sccf) {
		// find greatest Scc
		for (DirectedSubgraph<String, DefaultEdge> subgraph : sccf.getStronglyConnectedSubgraphs())
			// greatest means most vertices
			if (greatestSccSize < subgraph.vertexSet().size()) {
				greatestSccSize = subgraph.vertexSet().size();
				greatestScc = subgraph;
			}
//			// greatest means most edges
//			if (greatestSccSize < subgraph.edgeSet().size()) {
//				greatestSccSize = subgraph.edgeSet().size();
//				greatestScc = subgraph;
//			}
		// compute greatest Scc's diameter
		for (String source : greatestScc.vertexSet())
			for (String target : greatestScc.vertexSet()) {
				int diameter = DijkstraShortestPath.findPathBetween(greatestScc, source, target).size();
				if (maxDiameter < diameter) {
					maxDiameter = diameter;
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
		return maxDiameter;
	}

}
