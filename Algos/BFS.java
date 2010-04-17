package Algos;

import Graph.Node;
import java.util.LinkedList;
import java.util.NoSuchElementException;

//public class Node {
//
//    private String name;
//    public LinkedList<Node> neighbors;
//    public boolean enqueued;
//
//    public Node(String name) {
//        this.name = name;
//        neighbors = new LinkedList<Node>();
//    }
//
//    @Override
//    public String toString() {
//        return "Node: " + name;
//    }
//}
public class BFS {
	private int pathLength;

	public BFS(Node source, Node target) {
		LinkedList<Node> nextQueue = new LinkedList<Node>();
		boolean found = false;
		pathLength = 0;
		// Enqueue root
		source.setEnqueued(true);
		nextQueue.offer(source);
		while (!found) {
			++pathLength;
			// Dequeue next node for comparison
			// And add it to list of traversed nodes
			Node node = null;
			try {
				node = nextQueue.remove();
			} catch (NoSuchElementException nsee) {
				// Exit early if we're out of next elements to search
				break;
			}
			if (node.equals(target)) {
				found = true;
				break;
			} else {
				// Enqueue new neighbors
				for (Node neighbor : node.getNeighbors())
					if (!neighbor.isEnqueued()) {
						neighbor.setEnqueued(true);
						nextQueue.offer(neighbor);
					}
			}
		}
	}

	public int getPathLength() {
		return pathLength;
	}

}
