package Algos;

import Graph.AdjacencyList;
import Graph.Node;
import java.util.ArrayList;
import java.util.Iterator;
import org.jgraph.graph.DefaultEdge;

public class Kosaraju {
	private ArrayList<Node> stack;

	public ArrayList<ArrayList<Node>> getSCC(Node root, AdjacencyList list) {
		stack = new ArrayList<Node>();
		// search the graph (depth-first search), adding nodes to the stack
		search(root, list, true);
		// reverse all the edges in the graph
		list.reverseGraph();
		// search the graph again in the stack's order
		ArrayList<ArrayList<Node>> SCC = new ArrayList<ArrayList<Node>>();
		while (!stack.isEmpty()) {
			ArrayList<Node> component = new ArrayList<Node>();
			search(stack.get(0), list, false);
			// any components we visited are strongly connected
			// remove them from the stack and add them to the component
			for (Iterator<Node> it = stack.iterator(); it.hasNext();) {
				Node n = it.next();
				if (!n.isVisited()) {
					component.add(n);
					it.remove();
				}
			}
			// add the component to the result set
			SCC.add(component);
		}
		return SCC;
	}

	private void search(Node root, AdjacencyList list, boolean forward) {
		root.setVisited(forward);
		if (list.getAdjacent(root) == null) {
			if (forward) {
				stack.add(0, root);
			}
			return;
		}
		for (DefaultEdge edge : list.getAdjacent(root))
			if (((Node) edge.getTarget()).isVisited() != forward) {
				search((Node) edge.getTarget(), list, forward);
			}
		if (forward) {
			stack.add(0, root);
		}
	}

}
