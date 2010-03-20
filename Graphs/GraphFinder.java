package Graphs;

import java.util.Iterator;
import java.util.List;
import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.graph.DirectedSubgraph;

/**
 *
 * @author Periklis Ntanasis
 */
public class GraphFinder {
	private DirectedGraph<String, DefaultEdge> digraph;
	private int[] diameters;
	private int maxdiameter = 0;

	public GraphFinder(DirectedGraph<String, DefaultEdge> graph) {
		this.digraph = graph;
		calcDiameters();
	}

	private void calcDiameters() {
		SCCFinder sccf = new SCCFinder(digraph);
		List<DirectedSubgraph<String, DefaultEdge>> SSCGraphs = sccf.findStronglyConnectedSubgraphs();
		diameters = new int[SSCGraphs.size()];
		for (int pos = 0; pos < SSCGraphs.size(); pos++) {
			Iterator<String> startVertexes = SSCGraphs.get(pos).vertexSet().iterator();
			int diameter = 0;
			while (startVertexes.hasNext()) {
				String str = startVertexes.next();
				Iterator<String> finishVertexes = SSCGraphs.get(pos).vertexSet().iterator();
				while (finishVertexes.hasNext()) {
					String fin = finishVertexes.next();
					int tmpdiameter = DijkstraShortestPath.findPathBetween(
						digraph, str, fin).size();
					if (diameter < tmpdiameter) {
						diameter = tmpdiameter;
					}
					if (AppDefs.DEBUG) {
						System.out.format("StartNode: %s \tEndNode: %s \tDiamtr: %d \tSetDiamtr: %d\n",
								  str, fin, tmpdiameter, diameter);
					}
				}
			}
			diameters[pos] = diameter;
			// find max diameter as you scan
			if (maxdiameter < diameter) {
				maxdiameter = diameter;
			}
			if (AppDefs.DEBUG) {
				System.out.format("Current Max: %d\t..Next Set\n", maxdiameter);
			}
		}
	}

	public int getGreatestDiameter() {
		return maxdiameter;
	}

	public int[] getDiameters() {
		return diameters;
	}

}
