package Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jgraph.graph.DefaultEdge;

public class AdjacencyList {
	private Map<Node, ArrayList<DefaultEdge>> adjacencies = new HashMap<Node, ArrayList<DefaultEdge>>();

	public void addEdge(Node source, Node target) {
		ArrayList<DefaultEdge> list;
		if (!adjacencies.containsKey(source)) {
			list = new ArrayList<DefaultEdge>();
			adjacencies.put(source, list);
		} else {
			list = adjacencies.get(source);
		}
		DefaultEdge edge = new DefaultEdge();
		edge.setSource(source);
		edge.setTarget(target);
		list.add(edge);
	}

	public ArrayList<DefaultEdge> getAdjacent(Node source) {
		return adjacencies.get(source);
	}

	public void reverseEdge(DefaultEdge edge) {
		adjacencies.get((Node) edge.getSource()).remove(edge);
		addEdge((Node) edge.getTarget(), (Node) edge.getSource());
	}

	public void reverseGraph() {
		adjacencies = getReversedList().adjacencies;
	}

	public AdjacencyList getReversedList() {
		AdjacencyList reversedAdjecencyList = new AdjacencyList();
		for (ArrayList<DefaultEdge> edges : adjacencies.values())
			for (DefaultEdge edge : edges)
				reversedAdjecencyList.addEdge((Node) edge.getTarget(), (Node) edge.getSource());
		return reversedAdjecencyList;
	}

	public Set<Node> getSourceNodeSet() {
		return adjacencies.keySet();
	}

	public Collection<DefaultEdge> getAllEdges() {
		ArrayList<DefaultEdge> edges = new ArrayList<DefaultEdge>();
		for (List<DefaultEdge> e : adjacencies.values())
			edges.addAll(e);
		return edges;
	}

}
