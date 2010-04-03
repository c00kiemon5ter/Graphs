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
	private int maxdiameter = 0;

	public GraphFinder(DirectedGraph<String, DefaultEdge> graph) {
		this.digraph = graph;
		calcDiameters();
	}

	private void calcDiameters() {
		SCCFinder sccf = new SCCFinder(digraph);
		List<DirectedSubgraph<String, DefaultEdge>> sccSubgraphs = sccf.findStronglyConnectedSubgraphs();
		// find greater SCC
		int greatestSccSize = 0;
		DirectedSubgraph<String, DefaultEdge> greatestScc = null;
		for (int pos = 0; pos != sccSubgraphs.size(); pos++)
			if (greatestSccSize < sccSubgraphs.get(pos).vertexSet().size()) {
				greatestSccSize = sccSubgraphs.get(pos).vertexSet().size();
				greatestScc = sccSubgraphs.get(pos);
			}
		// compute greatest SCC's diameter
		Iterator<String> sourceVertexes = greatestScc.vertexSet().iterator();
		while (sourceVertexes.hasNext()) {
			String source = sourceVertexes.next();
			Iterator<String> targetVertexes = greatestScc.vertexSet().iterator();
			while (targetVertexes.hasNext()) {
				String target = targetVertexes.next();
				int diameter = DijkstraShortestPath.findPathBetween(
					digraph, source, target).size();
				if (maxdiameter < diameter) {
					maxdiameter = diameter;
				}
				if (AppDefs.DEBUG) {
					System.out.format("SourceNode: %s\tTargetNode: %s"
							  + "\tDiamtr: %d\tMaxDiamtr: %d\n",
							  source, target, diameter, maxdiameter);
				}
			}
		}
//		for (DirectedSubgraph<String, DefaultEdge> subgraph : sccSubgraphs) {
//			Iterator<String> sourceVertexes = subgraph.vertexSet().iterator();
//			while (sourceVertexes.hasNext()) {
//				String source = sourceVertexes.next();
//				Iterator<String> targetVertexes = subgraph.vertexSet().iterator();
//				while (targetVertexes.hasNext()) {
//					String target = targetVertexes.next();
//					int diameter = DijkstraShortestPath.findPathBetween(
//						digraph, source, target).size();
//					if (maxdiameter < diameter) {
//						maxdiameter = diameter;
//					}
//					if (AppDefs.DEBUG) {
//						System.out.format("SourceNode: %s\tTargetNode: %s"
//								  + "\tDiamtr: %d\tMaxDiamtr: %d\n",
//								  source, target, diameter, maxdiameter);
//					}
//				}
//			}
//		}
	}

	public int getGreatestDiameter() {
		return maxdiameter;
	}

}
