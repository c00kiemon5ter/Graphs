
package Graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Node implements Comparable<Node> {
	private final String name;
	private boolean visited = false;	// used for Kosaraju's algorithm
	private int lowlink = -1, index = -1;   // used for Tarjan's algorithm
	private List<Node> neighbors;		// used for BFS algorithm
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

	public List<Node> getNeighbors() {
		return Collections.unmodifiableList(neighbors);
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
		return getName();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Node) {
			return hashCode() == obj.hashCode();
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 47 * hash + (this.name != null ? this.name.hashCode() : 0);
		return hash;
	}

	public String KosarajuString() {
		return String.format("Node %s has%s been visited", getName(), visited ? "" : " not");
	}

	public String tarjanString() {
		return String.format("Node %s lowlink %d, index %d", getName(), lowlink, index);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
