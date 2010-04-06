package Graphs;

import java.util.Iterator;
import java.util.Set;
import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgraph.graph.DefaultEdge;

public class GraphFinder {
	private DirectedGraph<String, DefaultEdge> digraph;
	SCCFinder sccf;
	private int maxdiameter = 0;

	public GraphFinder(DirectedGraph<String, DefaultEdge> graph, SCCFinder sccf) {
		this.digraph = graph;
		this.sccf = sccf;
		calcDiameters();
	}

	private void calcDiameters() {
		// find greater SCC
		int greatestSccSize = 0;
		Set<String> greatestScc = null;
		for (Set<String> subgraph : sccf.findStronglyConnectedSets())
			if (greatestSccSize < subgraph.size()) {
				greatestSccSize = subgraph.size();
				greatestScc = subgraph;
			}
		// compute greatest SCC's diameter
		Iterator<String> sourceVertexes = greatestScc.iterator();
		while (sourceVertexes.hasNext()) {
			String source = sourceVertexes.next();
			Iterator<String> targetVertexes = greatestScc.iterator();
			while (targetVertexes.hasNext()) {
				String target = targetVertexes.next();
				if (source.equals(target)) {
					continue;
				}
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
//		// find greater SCC
//		List<DirectedSubgraph<String, DefaultEdge>> sccSubgraphs = sccf.findStronglyConnectedSubgraphs();
//		DirectedSubgraph<String, DefaultEdge> greatestScc = null;
//		for (int pos = 0; pos != sccSubgraphs.size(); pos++)
//			if (greatestSccSize < sccSubgraphs.get(pos).vertexSet().size()) {
//				greatestSccSize = sccSubgraphs.get(pos).vertexSet().size();
//				greatestScc = sccSubgraphs.get(pos);
//			}
//		// compute greatest SCC's diameter
//		Iterator<String> sourceVertexes = greatestScc.vertexSet().iterator();
//		while (sourceVertexes.hasNext()) {
//			String source = sourceVertexes.next();
//			Iterator<String> targetVertexes = greatestScc.vertexSet().iterator();
//			while (targetVertexes.hasNext()) {
//				String target = targetVertexes.next();
//				if (source.equals(target)) {
//					break;
//				}
//				int diameter = DijkstraShortestPath.findPathBetween(
//					digraph, source, target).size();
//				if (maxdiameter < diameter) {
//					maxdiameter = diameter;
//				}
//				if (AppDefs.DEBUG) {
//					System.out.format("SourceNode: %s\tTargetNode: %s"
//							  + "\tDiamtr: %d\tMaxDiamtr: %d\n",
//							  source, target, diameter, maxdiameter);
//				}
//			}
//		}
//		// check everything
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
