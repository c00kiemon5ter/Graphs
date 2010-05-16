
package Algos;

import Graph.Edge;
import Graph.Node;
import Graph.list.DisjointSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
	public ArrayList<Edge> getMST(Node[] nodes, List<Edge> edges) {
		Collections.sort(edges);
		ArrayList<Edge> MST = new ArrayList<Edge>(edges.size() / 2);
		DisjointSet<Node> nodeset = new DisjointSet<Node>();
		nodeset.createSubsets(nodes);
		for (Edge e : edges) {
			if (nodeset.find(e.getFrom()) != nodeset.find(e.getTo())) {
				nodeset.merge(nodeset.find(e.getFrom()), nodeset.find(e.getTo()));
				MST.add(e);
			}
		}
		return MST;
	}

}
