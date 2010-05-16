
package Graph.list;

import Graph.Edge;
import Graph.Node;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdjacencyList {
	private Map<Node, ArrayList<Edge>> adjacencies;

	@SuppressWarnings("CollectionWithoutInitialCapacity")
	public AdjacencyList() {
		adjacencies = new HashMap<Node, ArrayList<Edge>>();
	}

	@SuppressWarnings("CollectionWithoutInitialCapacity")
	public void addEdge(Node source, Node target, int weight) {
		ArrayList<Edge> list;
		if (!adjacencies.containsKey(source)) {
			list = new ArrayList<Edge>();
			adjacencies.put(source, list);
		} else {
			list = adjacencies.get(source);
		}
		list.add(new Edge(source, target, weight));
	}

	public ArrayList<Edge> getAdjacent(Node source) {
		return adjacencies.get(source);
	}

	public void reverseEdge(Edge e) {
		adjacencies.get(e.getFrom()).remove(e);
		addEdge(e.getTo(), e.getFrom(), e.getWeight());
	}

	public void reverseGraph() {
		adjacencies = getReversedList().getAdjacencies();
	}

	public AdjacencyList getReversedList() {
		AdjacencyList newlist = new AdjacencyList();
		for (ArrayList<Edge> edges : adjacencies.values()) {
			for (Edge e : edges) {
				newlist.addEdge(e.getTo(), e.getFrom(), e.getWeight());
			}
		}
		return newlist;
	}

	public Set<Node> getSourceNodeSet() {
		return adjacencies.keySet();
	}

	public Collection<Edge> getAllEdges() {
		List<Edge> edges = new ArrayList<Edge>(adjacencies.values().size());
		for (List<Edge> e : adjacencies.values()) {
			edges.addAll(e);
		}
		return edges;
	}

	/**
	 * @return the adjacencies
	 */
	public Map<Node, ArrayList<Edge>> getAdjacencies() {
		return Collections.unmodifiableMap(adjacencies);
	}

}
