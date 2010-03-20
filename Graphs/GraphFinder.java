package Graphs;

import java.util.List;
import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.Subgraph;

/**
 *
 * @author Periklis Ntanasis
 */
public class GraphFinder {
	DirectedGraph digraph;
	int[] diameters;
	int maxDiamtr = 0;

	public GraphFinder(DirectedGraph graph) {
		this.digraph = graph;
		calcDiameters();
	}

	private void calcDiameters() {
		SCCFinder sccf = new SCCFinder(digraph);
		List<Subgraph> SSCGraphs = sccf.findStronglyConnectedSubgraphs();
		diameters = new int[SSCGraphs.size()];
		for (int pos = 0; pos < SSCGraphs.size(); pos++) {
			String start = (String) SSCGraphs.get(pos).vertexSet().toArray()[0];
			String finish = (String) SSCGraphs.get(pos).vertexSet().toArray()[SSCGraphs.get(pos).vertexSet().toArray().length - 1];
			int diameter = DijkstraShortestPath.findPathBetween(digraph, start, finish).size();
			diameters[pos] = diameter;
			if (maxDiamtr < diameter) {
				maxDiamtr = diameter;
			}
		}
	}

	public int getGreatestDiameter() {
		return maxDiamtr;
	}

}
