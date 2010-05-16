
package Graph;

import org.jgraph.graph.DefaultEdge;

/**
 *
 * @author  Ivan Kanakarakis
 */
public class Edge extends DefaultEdge implements Comparable<Edge> {
	private final Node from, to;
	private final int weight;

	public Edge(final Node argFrom, final Node argTo, final int argWeight) {
		from = argFrom;
		to = argTo;
		weight = argWeight;
	}

	public int compareTo(final Edge argEdge) {
		return getWeight() - argEdge.getWeight();
	}

	/**
	 * @return the from
	 */
	public Node getFrom() {
		return from;
	}

	/**
	 * @return the to
	 */
	public Node getTo() {
		return to;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

}
