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
//	private Thread runner;
//	private int diamint;
//	private MainWindow gui;

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

//	private Double[] SSCDiameters() {
//		SCCFinder scc = new SCCFinder(digraph);
//		DijkstraShortestPath<String, DefaultEdge> alg;
//		List<DirectedSubgraph<String, DefaultEdge>> SSCGraphs = scc.findStronglyConnectedSubgraphs();
//		Double[] diameters = new Double[SSCGraphs.size()];
//		Double max;
//		for (int i = 0; i < SSCGraphs.size(); i++) {
//			Iterator it1 = SSCGraphs.get(i).vertexSet().iterator();
//			Iterator it2;
//			String start;
//			max = 0D;
//			while (it1.hasNext()) {
//				start = it1.next().toString();
//				it2 = SSCGraphs.get(i).vertexSet().iterator();
//				while (it2.hasNext()) {
//					alg = new DijkstraShortestPath<String, DefaultEdge>(digraph, start, it2.next().toString());
//					if (alg.getPathLength() > max) {
//						max = alg.getPathLength();
//					}
//				}
//			}
//			diameters[i] = max;
//		}
//		return diameters;
//	}
//
//	public Double Diameter() {
//		Double max = 0D;
//		Double[] diameters = this.SSCDiameters();
//		for (int i = 0; i < diameters.length; i++)
//			if (diameters[i] > max) {
//				max = diameters[i];
//			}
//		return max;
//	}
//
//	public void run() {
//		double retval = this.Diameter();
//		diamint = (int) retval;
//		gui.updateDiameter(diamint);
//	}
//
//	public void start() {
//		if (runner == null) {
//			runner = new Thread(this);
//			runner.setDaemon(true);
//			runner.start();
//		}
//	}
//
//	public void setGUI(MainWindow gui) {
//		this.gui = gui;
//	}
}
