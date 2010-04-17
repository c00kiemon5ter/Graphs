package Graph;

import java.util.LinkedList;

public class Node implements Comparable<Node> {
	private final String name;
	private boolean visited = false;	// used for Kosaraju's algorithm
	private int lowlink = -1, index = -1;   // used for Tarjan's algorithm
	private LinkedList<Node> neighbors;	// used for BFS algorithm
	private boolean enqueued;		// used for BFS algorithm

	public Node(final String argName) {
		name = argName;
		neighbors = new LinkedList<Node>();
	}

	public boolean isEnqueued() {
		return enqueued;
	}

	public void setEnqueued(boolean enqueued) {
		this.enqueued = enqueued;
	}

	public LinkedList<Node> getNeighbors() {
		return neighbors;
	}

	public int compareTo(final Node argNode) {
		return argNode == this ? 0 : -1;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getLowlink() {
		return lowlink;
	}

	public void setLowlink(int lowlink) {
		this.lowlink = lowlink;
	}

	@Override
	public String toString() {
		return name;
	}

	public String KosarajuString() {
		return String.format("Node %s has%s been visited", name, visited ? "" : " not");
	}

	public String tarjanString() {
		return String.format("Node %s lowlink %d, index %d", name, lowlink, index);
	}

}
