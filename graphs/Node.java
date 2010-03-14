package graphs;

import java.util.Collection;
import java.util.Vector;

/**
 * A node is an element consisted of its name
 * and a collection of other node-names
 * which it follows
 * (A-->B : A follows B, B is followed by A)
 *
 * @author	Ivan Kanakarakis
 */
public class Node {
	private int nodename;
	private Vector<Integer> connections;

	public Node(int nodename) {
		this.nodename = nodename;
		this.connections = new Vector<Integer>();
	}

	public Node(int nodename, Collection<Integer> connectedTo) {
		this.nodename = nodename;
		this.connections = new Vector<Integer>(connectedTo);
	}

	public int getNodeName() {
		return nodename;
	}

	public Vector<Integer> getConnections() {
		return connections;
	}

	public boolean isConnectedTo(Node node) {
		return connections.contains(node.getNodeName());
	}

	public void addNode(int node) {
		connections.add(node);
	}

	public void addNodes(Collection<Integer> nodes) {
		connections.addAll(nodes);
	}

	public String toFileString() {
		StringBuffer tofile = new StringBuffer(connections.size() << 1);
		for (Integer integ : connections)
			tofile.append(String.format("%d\t%d\n", nodename, integ));
		return tofile.toString();
	}

	@Override
	public String toString() {
		return String.format("Node %d is connected to nodes %s", nodename, connections.toString());
	}

}
