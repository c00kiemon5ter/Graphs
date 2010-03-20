package Graphs;

import Forms.MainWindow;
import java.util.Iterator;
import java.util.List;
import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.Subgraph;

/**
 *
 * @author Periklis Ntanasis
 */
public class GraphFinder implements Runnable {
	private DirectedGraph digraph;
	private int[] diamtrsArray;
	private int maxdiameter = 0;
	private Thread runner;
	private int diamint;
	private MainWindow gui;

	public GraphFinder(DirectedGraph graph) {
		this.digraph = graph;
		calcDiameters();
	}

	private void calcDiameters() {
		SCCFinder sccf = new SCCFinder(digraph);
		List<Subgraph> SSCGraphs = sccf.findStronglyConnectedSubgraphs();
		diamtrsArray = new int[SSCGraphs.size()];
		for (int pos = 0; pos < SSCGraphs.size(); pos++) {
			Object[] arr = SSCGraphs.get(pos).vertexSet().toArray();
			String start = (String) arr[0], finish = (String) arr[arr.length - 1];
			int diameter = DijkstraShortestPath.findPathBetween(digraph, start, finish).size();
			diamtrsArray[pos] = diameter;
			// find max diameter as you scan
			if (maxdiameter < diameter) {
				maxdiameter = diameter;
			}
			if (AppDefs.DEBUG) {
				System.out.format("%s \t %s \t %d \t %d \n",
						  start, finish, diameter, maxdiameter);
			}
		}
	}

	public int getGreatestDiameter() {
		return maxdiameter;
	}

	private Double[] SSCDiameters() {
		SCCFinder scc = new SCCFinder(digraph);
		DijkstraShortestPath alg;
		List<Subgraph> SSCGraphs = scc.findStronglyConnectedSubgraphs();
		Double[] diameters = new Double[SSCGraphs.size()];
		Double max;
		for (int i = 0; i < SSCGraphs.size(); i++) {
			Iterator it1 = SSCGraphs.get(i).vertexSet().iterator();
			Iterator it2;
			Object start;
			max = 0D;
			while (it1.hasNext()) {
				start = it1.next();
				it2 = SSCGraphs.get(i).vertexSet().iterator();
				while (it2.hasNext()) {
					alg = new DijkstraShortestPath(digraph, start, it2.next());
					if (alg.getPathLength() > max) {
						max = alg.getPathLength();
					}
				}
			}
			diameters[i] = max;
		}
		return diameters;
	}

	public Double Diameter() {
		Double max = 0D;
		Double[] diameters = this.SSCDiameters();
		for (int i = 0; i < diameters.length; i++)
			if (diameters[i] > max) {
				max = diameters[i];
			}
		return max;
	}

	public void run() {
		double retval = this.Diameter();
		diamint = (int) retval;
		gui.updateDiameter(diamint);
	}

	public void start() {
		if (runner == null) {
			runner = new Thread(this);
			runner.setDaemon(true);
			runner.start();
		}
	}

	public void setGUI(MainWindow gui) {
		this.gui = gui;
	}

}